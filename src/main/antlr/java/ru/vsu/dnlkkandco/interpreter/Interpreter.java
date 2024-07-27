package ru.vsu.dnlkkandco.interpreter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vsu.dnlkkandco.interpreter.value.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.util.*;

public class Interpreter {
    private static final Logger log = LoggerFactory.getLogger(Interpreter.class);

    public static void main(String[] args) throws IOException {
        Path source = Path.of(args[0]);
        Interpreter interpreter = new Interpreter(source);
        interpreter.exec();
    }

    private static final String LABEL_MARKER = "#";
    private static final String NULL_MARKER = "!";
    private static final String UNDEFINED_MARKER = "$";
    private static final String NUM_MARKER = "N";
    private static final String DOUBLE_MARKER = "D";
    private static final String BOOL_MARKER = "B";

    private static final Scanner STDIN = new Scanner(System.in);
    private static final PrintStream STDOUT = System.out;

    private final Path source;
    private final Map<String, Integer> labels;
    private final List<InterpreterCommand> commands;
    private boolean preprocessed = false;
    private final Deque<Value<?>> stack;
    private final Deque<Integer> ipStack;
    private Context context = new Context(null);

    public Interpreter(Path source) {
        this.source = source;
        labels = new HashMap<>();
        commands = new ArrayList<>();
        stack = new ArrayDeque<>();
        ipStack = new ArrayDeque<>();
    }

    public void exec() throws IOException {
        if (!preprocessed) {
            // добавить обработку исключений
            preprocess();
        }

        initSycCalls();

        assert labels.containsKey("main");
        // processor register
        int ip = labels.get("main");

        log.info("Start interpreting from {}", source);
        while (ip != -1 && ip < commands.size()) {
            InterpreterCommand command = commands.get(ip++);
            try {
                switch (command.command()) {
                    case CommandType.POP -> {
                        log.debug("Executing pop command");
                        stack.pop();
                    }
                    case CommandType.PUSH -> {
                        log.debug("Executing push command");
                        stack.push(command.argument());
                    }
                    case CommandType.DUP -> {
                        log.debug("Executing dup command");
                        stack.push(stack.peek());
                    }
                    case CommandType.SET -> {
                        log.debug("Executing set command");
                        StringValue var = stack.pop().asString();
                        Value<?> argument = stack.pop();
                        context.setVariable(var.getValue(), argument);
                    }
                    case CommandType.LOAD -> {
                        log.debug("Executing load command");
                        StringValue var = stack.pop().asString();
                        Value<?> val = context.get(var.getValue());
                        stack.push(val);
                    }
                    case CommandType.ADD, CommandType.SUB, CommandType.MUL, CommandType.DIV, CommandType.MOD,
                         CommandType.EQ, CommandType.NEQ, CommandType.GT, CommandType.GTE, CommandType.LT,
                         CommandType.LTE -> {
                        log.debug("Executing binary {} command", command.command().name().toLowerCase());
                        Value<?> val1 = stack.pop();
                        Value<?> val2 = stack.pop();
                        Value<?> result = Operation.binaryImplementation
                                .get(Operation.Binary.valueOf(command.command().toString()))
                                .get(val1.getType()).apply(val1, val2);
                        stack.push(result);
                    }
                    case CommandType.NEG, CommandType.NOT -> {
                        log.debug("Executing unary {} command", command.command().name().toLowerCase());
                        Value<?> val = stack.pop();
                        Value<?> result = Operation.unaryImplementation
                                .get(Operation.Unary.valueOf(command.command().toString()))
                                .get(val.getType()).apply(val);
                        stack.push(result);
                    }
                    case CommandType.JMF, CommandType.JMT -> {
                        log.debug("Executing conditional jump {} command", command.command().name().toLowerCase());
                        Value<?> val = stack.pop();
                        if (val.getType() != ValueType.BOOL) {
                            throw new RuntimeException("Illegal value '" + val + "'");
                        }
                        boolean jump = command.command().equals(CommandType.JMT) == val.asBool().getValue();
                        if (jump) {
                            ip = labels.get(getAsLabel(command.argument().asString().getValue()));
                        }
                    }
                    case CommandType.JMP -> {
                        log.debug("Executing jmp command");
                        ip = labels.get(getAsLabel(command.argument().asString().getValue()));
                    }
                    case CommandType.NEWARRAY -> {
                        log.debug("Executing newarray command");
                        stack.push(new ArrayValue(new ArrayList<>()));
                    }
                    case CommandType.ASET -> {
                        log.debug("Executing aset command");
                        Value<?> value = stack.pop();
                        int index = stack.pop().asNum().getValue();
                        ArrayValue array = stack.pop().asArray();
                        array.set(index, value);
                    }
                    case CommandType.ALOAD -> {
                        log.debug("Executing aload command");
                        int index = stack.pop().asNum().getValue();
                        ArrayValue array = stack.pop().asArray();
                        stack.push(array.get(index));
                    }
                    case CommandType.NEWOBJECT -> {
                        log.debug("Executing newobject command");
                        stack.push(new ObjectValue(new HashMap<>()));
                    }
                    case CommandType.SETFIELD -> {
                        log.debug("Executing setfield command");
                        Value<?> value = stack.pop();
                        String fieldName = stack.pop().asString().getValue();
                        ObjectValue object = stack.pop().asObject();
                        object.put(fieldName, value);
                    }
                    case CommandType.GETFIELD -> {
                        log.debug("Executing getfield command");
                        String fieldName = stack.pop().asString().getValue();
                        ObjectValue object = stack.pop().asObject();
                        stack.push(object.get(fieldName));
                    }
                    case CommandType.NEWFUNC -> {
                        log.debug("Executing newfunc command");
                        String label = stack.pop().asString().getValue();
                        FunctionValue function = new FunctionValue(label);
                        stack.push(function);
                    }
                    case CommandType.CALLFUNC -> {
                        Value<?> callable = stack.pop();
                        context = new Context(context);
                        ArrayValue args = stack.pop().asArray();

                        switch (callable) {
                            case FunctionValue function -> {
                                log.debug("Executing callfunc command (function)");
                                ipStack.push(ip);
                                context.setVariable("__args__", args);
                                ip = labels.get(getAsLabel(function.getCodeBodyLabel()));
                            }
                            case SysCall sysCall -> {
                                log.debug("Executing callfunc command (syscall)");
                                sysCall.getValue().accept(args, stack);
                            }
                            default -> {
                                var e = new RuntimeException("Illegal call '" + callable + "'");
                                log.error(e.getMessage(), e);
                                throw e;
                            }
                        }

                    }
                    case CommandType.RETURN -> {
                        log.debug("Executing return command");
                        context = context.getParent();
                        ip = ipStack.pop();
                    }
                    case CommandType.HALT -> {
                        log.debug("Executing halt command");
                        ip = -1;
                    }
                }
            } catch (Exception e) {
                log.error("Error on line: {}", command.lineNumber(), e);
                break;
            }
        }
        log.info("End interpreting from {}", source);
    }

    private void initSycCalls() {
        final var sysCallDefinition = new SysCallsDefinition(STDIN, STDOUT);
        context.setVariable("iout", new ObjectValue(Map.of(
                "in", new SysCall((_, stack) -> {
                    var value = new StringValue(sysCallDefinition.in());
                    stack.push(value);
                }),
                "out", new SysCall((args, _) -> {
                    String[] values = args.asArray().getValue()
                            .stream()
                            .map(Value::getValue)
                            .map(Object::toString)
                            .toArray(String[]::new);
                    sysCallDefinition.out(values);
                }))
        ));
        context.setVariable("len", new SysCall((args, stack) -> {
            Value<?> value = args.get(0);
            int result = switch (value.getType()) {
                case ValueType.ARRAY -> sysCallDefinition.len(value.asArray().getValue());
                case ValueType.OBJECT -> sysCallDefinition.len(value.asObject().getValue());
                case ValueType.STRING -> sysCallDefinition.len(value.asString().getValue());
                default -> throw new RuntimeException("Illegal type '" + value.getType() + "'");
            };
            stack.push(new NumValue(result));
        }));
        context.setVariable("math", new ObjectValue(Map.of(
                "abs", new SysCall((args, stack) -> {
                    double value = args.get(0).asDouble().getValue();
                    var result = sysCallDefinition.abs(value);
                    stack.push(new DoubleValue(result));
                }),
                "sqrt", new SysCall((args, stack) -> {
                    double value = args.get(0).asDouble().getValue();
                    var result = sysCallDefinition.sqrt(value);
                    stack.push(new DoubleValue(result));
                }),
                "pow", new SysCall((args, stack) -> {
                    var base = args.get(0).asDouble().getValue();
                    var exponent = args.get(1).asDouble().getValue();
                    var value = sysCallDefinition.pow(base, exponent);
                    stack.push(new DoubleValue(value));
                }),
                "sin", new SysCall((args, stack) -> {
                    double value = args.get(0).asDouble().getValue();
                    var result = sysCallDefinition.sin(value);
                    stack.push(new DoubleValue(result));
                }),
                "cos", new SysCall((args, stack) -> {
                    double value = args.get(0).asDouble().getValue();
                    var result = sysCallDefinition.cos(value);
                    stack.push(new DoubleValue(result));
                }),
                "tan", new SysCall((args, stack) -> {
                    double value = args.get(0).asDouble().getValue();
                    var result = sysCallDefinition.tan(value);
                    stack.push(new DoubleValue(result));
                }),
                "antan", new SysCall((args, stack) -> {
                    double value = args.get(0).asDouble().getValue();
                    var result = sysCallDefinition.antan(value);
                    stack.push(new DoubleValue(result));
                }),
                "PI", new DoubleValue(Math.PI),
                "E", new DoubleValue(Math.E)
        )
        ));
        context.setVariable("credentials", new SysCall((_, _) -> {
            System.out.println("=== Авторы сего недоразумения! ===");
            System.out.println("Человек, который решил что знает ассемблер: Путин Павел");
            System.out.println("Frontender, нашедший способ писать на js даже компиляторы: Шлыков Данила");
            System.out.println("Кодогенератор во плоти, пожалуйста: Евгений Саков");
        }));
    }

    private String getAsLabel(String label) {
        if (!label.startsWith(LABEL_MARKER)) {
            throw new RuntimeException("Illegal label '" + label + "'");
        }
        label = label.substring(1);
        if (!labels.containsKey(label)) {
            throw new RuntimeException("Illegal label '" + label + "'");
        }
        return label;
    }

    private void preprocess() throws IOException {
        log.debug("Preprocessing");
        try (BufferedReader reader = new BufferedReader(new FileReader(source.toFile()))) {
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                lineNumber++;
                if (line.isBlank()) continue;

                if (line.startsWith(LABEL_MARKER)) {
                    String label = line.substring(1);
                    if (label.isEmpty()) {
                        var e = new LabelIsEmptyException("Empty label");
                        log.error(e.getMessage(), e);
                        throw e;
                    }

                    if (labels.containsKey(label)) {
                        var e = new DuplicateLabelException("Duplicate label: " + label + " on line " + lineNumber);
                        log.error(e.getMessage(), e);
                        throw e;
                    }

                    labels.put(label, commands.size());
                } else {
                    int delimiterIndex = line.indexOf(" ");
                    if (delimiterIndex == -1) {
                        commands.add(new InterpreterCommand(CommandType.valueOf(line.toUpperCase()), null, lineNumber));
                    } else {
                        String operation = line.substring(0, delimiterIndex);
                        String argument = line.substring(delimiterIndex + 1);
                        commands.add(new InterpreterCommand(CommandType.valueOf(operation.toUpperCase()), argumentToValue(argument), lineNumber));
                    }
                }
            }

            if (!labels.containsKey("main")) {
                var e = new NoMainLabelException("No main label");
                log.error(e.getMessage(), e);
                throw e;
            }

            preprocessed = true;
        }
    }

    private Value<?> argumentToValue(String argument) {
        if (argument.startsWith("\"") && argument.endsWith("\"")) {
            argument = argument.substring(1, argument.length() - 1);
            return new StringValue(argument);
        } else {
            String marker = argument.substring(0, 1);
            argument = argument.substring(1);

            return switch (marker) {
                case NULL_MARKER -> new NullValue();
                case UNDEFINED_MARKER -> new UndefinedValue();
                case NUM_MARKER -> new NumValue(Integer.parseInt(argument));
                case DOUBLE_MARKER -> new DoubleValue(Double.parseDouble(argument));
                case BOOL_MARKER -> new BoolValue(Boolean.parseBoolean(argument));
                default -> throw new IllegalStateException("Unexpected value: " + marker);
            };
        }
    }

    private static class LabelIsEmptyException extends RuntimeException {
        public LabelIsEmptyException(String label) {
            super(label);
        }
    }

    private static class DuplicateLabelException extends RuntimeException {
        public DuplicateLabelException(String label) {
            super(label);
        }
    }

    private static class NoMainLabelException extends RuntimeException {
        public NoMainLabelException(String label) {
            super(label);
        }
    }
}
