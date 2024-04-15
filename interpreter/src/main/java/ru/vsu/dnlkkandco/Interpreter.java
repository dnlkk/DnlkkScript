package ru.vsu.dnlkkandco;

import com.sun.jdi.IntegerValue;
import ru.vsu.dnlkkandco.value.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.IntStream;

public class Interpreter {
    public static void main(String[] args) throws IOException {
        Path source = Path.of(args[0]);
        Interpreter interpreter = new Interpreter(source);
        interpreter.exec();
    }

    private static final String LABEL_MARKER = "#";
    private static final String REFERENCE_MARKER = "@";
    private static final String NULL_MARKER = "!";
    private static final String UNDEFINED_MARKER = "$";
    private static final String NUM_MARKER = "N";
    private static final String DOUBLE_MARKER = "D";
    private static final String BOOL_MARKER = "B";

    private final Path source;
    private final Map<String, Integer> labels;
    private final List<InterpreterCommand> commands;
    private boolean preprocessed = false;
    private final Deque<String> stack;
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

        assert labels.containsKey("main");
        // processor register
        int ip = labels.get("main");


        while (ip < commands.size()) {
            InterpreterCommand command = commands.get(ip++);
            try {
                switch (command.operation()) {
                    case "POP" -> stack.pop();
                    case "PUSH" -> stack.push(command.argument());
                    case "SET" -> {
                        String var = getAsVar(stack.pop());
                        String argument = stack.pop();
                        context.setVariable(var, argumentToValue(argument));
                    }
                    case "LOAD" -> {
                        String var = getAsVar(stack.pop());
                        Value<?> val = context.get(var);
                        stack.push(val.toString());
                    }
                    case "ADD", "SUB", "MUL", "DIV", "MOD", "EQ", "NEQ", "GT", "GTE", "LT", "LTE" -> {
                        Value<?> val1 = argumentToValue(stack.pop());
                        Value<?> val2 = argumentToValue(stack.pop());
                        Value<?> result = Operation.binaryImplementation
                                .get(Operation.Binary.valueOf(command.operation()))
                                .get(val1.getType()).apply(val1, val2);
                        stack.push(result.toString());
                    }
                    case "NEG", "NOT" -> {
                        Value<?> val = argumentToValue(stack.pop());
                        Value<?> result = Operation.unaryImplementation
                                .get(Operation.Unary.valueOf(command.operation()))
                                .get(val.getType()).apply(val);
                        stack.push(result.toString());
                    }
                    case "JMF", "JMT" -> {
                        Value<?> val = argumentToValue(stack.pop());
                        if (val.getType() != ValueType.BOOL) {
                            throw new RuntimeException("Illegal value '" + val + "'");
                        }
                        boolean jump = command.operation().equals("JMT") ? val.asBool().getValue() : !val.asBool().getValue();
                        if (jump) {
                            ip = labels.get(command.argument());
                        }
                    }
                    case "JMP" -> ip = labels.get(command.argument());
                    case "NEWARRAY" -> {
                        String ref = getAsRef(stack.pop());
                        if (!context.containsVariable(ref)) {
                            context.setReference(ref, new ArrayValue(ref, new ArrayList<>()));
                        }
                    }
                    case "ASET" -> {
                        ArrayValue array = argumentToValue(stack.pop()).asArray();
                        int index = argumentToValue(stack.pop()).asNum().getValue();
                        Value<?> value = argumentToValue(stack.pop());

                        while (array.getValue().size() <= index) {
                            array.getValue().add(new UndefinedValue());
                        }
                        array.getValue().set(index, value);
                    }
                    case "ALOAD" -> {
                        ArrayValue array = argumentToValue(stack.pop()).asArray();
                        int index = argumentToValue(stack.pop()).asNum().getValue();

                        if (array.getValue().size() <= index) {
                            stack.push(new UndefinedValue().toString());
                        } else {
                            stack.push(array.getValue().get(index).toString());
                        }
                    }
                    case "NEWOBJECT" -> {
                        String ref = getAsRef(stack.pop());
                        if (!context.containsVariable(ref)) {
                            context.setReference(ref, new ObjectValue(ref, new HashMap<>()));
                        }
                    }
                    case "SETFIELD" -> {
                        ObjectValue object = argumentToValue(stack.pop()).asObject();
                        String fieldName = argumentToValue(stack.pop()).asString().getValue();
                        Value<?> value = argumentToValue(stack.pop());
                        object.getValue().put(fieldName, value);
                    }
                    case "GETFIELD" -> {
                        ObjectValue object = argumentToValue(stack.pop()).asObject();
                        String fieldName = argumentToValue(stack.pop()).asString().getValue();

                        if (object.getValue().containsKey(fieldName)) {
                            stack.push(object.getValue().get(fieldName).toString());
                        } else {
                            stack.push(new UndefinedValue().toString());
                        }
                    }
                    case "NEWFUNC" -> {
                        String ref = getAsRef(stack.pop());
                        String label = getAsLabel(stack.pop());

                        int argc = argumentToValue(stack.pop()).asNum().getValue();
                        String[] args = new String[argc];
                        IntStream.range(0, argc)
                                .forEach(i -> args[i] = stack.pop());
                        FunctionValue function = new FunctionValue(ref, label, args);
                        context.setReference(ref, function);
                    }
                    case "CALLFUNC" -> {
                        String ref = getAsRef(stack.pop());
                        int argc = argumentToValue(stack.pop()).asNum().getValue();
                        Value<?>[] args = new Value<?>[argc];
                        IntStream.range(0, argc)
                                .forEach(i -> args[i] = argumentToValue(stack.pop()));

                        FunctionValue function = context.get(ref).asFunction();
                        Context funcContext = new Context(context);
                        for (int i = 0; i < function.getArgs().length; i++) {
                            if (i >= argc) {
                                funcContext.setVariable(function.getArgs()[i], new UndefinedValue());
                            } else {
                                funcContext.setVariable(function.getArgs()[i], args[i]);
                            }
                        }
                        ipStack.push(ip);

                        context = funcContext;
                        ip = labels.get(function.getCodeBodyLabel());
                    }
                    case "RETURN" -> {
                        context = context.getParent();
                        ip = ipStack.pop() + 1;
                    }
                    case "HALT" -> {
                        return;
                    }
                }
            } catch (Exception e) {
                System.err.println("Error on line: " + command.lineNumber());
                System.err.println(e.getMessage());
                e.printStackTrace();
                break;
            }
        }

        // todo: to remove
        System.out.println(stack.peek());
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
                        throw new LabelIsEmptyException("Empty label");
                    }

                    if (labels.containsKey(label)) {
                        throw new DuplicateLabelException("Duplicate label: " + label + " on line " + lineNumber);
                    }

                    labels.put(label, commands.size());
                } else {
                    int delimiterIndex = line.indexOf(" ");
                    if (delimiterIndex == -1) {
                        commands.add(new InterpreterCommand(line.toUpperCase(), null, lineNumber));
                    } else {
                        String operation = line.substring(0, delimiterIndex);
                        String argument = line.substring(delimiterIndex + 1);
                        commands.add(new InterpreterCommand(operation.toUpperCase(), argument, lineNumber));
                    }
                }
            }

            if (!labels.containsKey("main")) {
                throw new NoMainLabelException("No main label");
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
                case REFERENCE_MARKER -> context.getReference(argument);
                case NULL_MARKER -> new NullValue();
                case UNDEFINED_MARKER -> new UndefinedValue();
                case NUM_MARKER -> new NumValue(Integer.parseInt(argument));
                case DOUBLE_MARKER ->
                        new DoubleValue(Double.parseDouble(argument));
                case BOOL_MARKER -> new BoolValue(Boolean.parseBoolean(argument));
                default -> throw new IllegalStateException("Unexpected value: " + marker);
            };
        }
    }

    private String getAsVar(String var) {
        if (!(var.startsWith("\"") && var.endsWith("\""))) {
            throw new RuntimeException("Illegal variable '" + var + "'");
        }
        return var.substring(1, var.length() - 1);
    }

    private String getAsRef(String ref) {
        if (!ref.startsWith(REFERENCE_MARKER)) {
            throw new RuntimeException("Invalid reference: " + ref);
        }
        return ref.substring(1);
    }

    private static class LabelIsEmptyException extends RuntimeException {
        public LabelIsEmptyException(String label) {super(label);}
    }

    private static class DuplicateLabelException extends RuntimeException {
        public DuplicateLabelException(String label) {super(label);}
    }

    private static class NoMainLabelException extends RuntimeException {
        public NoMainLabelException(String label) {super(label);}
    }
}
