package ru.vsu.dnlkkandco.interpreter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vsu.dnlkkandco.interpreter.value.*;

import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class Interpreter {
    private static final Logger log = LoggerFactory.getLogger(Interpreter.class);

    private static final Scanner STDIN = new Scanner(System.in);
    private static final PrintStream STDOUT = System.out;

    private final Map<String, Integer> labels;
    private final List<InterpreterCommand> commands;
    private final Deque<Value<?>> stack = new ArrayDeque<>();
    private final Deque<Integer> returnPoints = new ArrayDeque<>();
    private int currentCommandIndex = -1;

    private Context context = new Context(null);

    public Interpreter(
            Map<String, Integer> labels,
            List<InterpreterCommand> commands
    ) {
        this.labels = labels;
        this.commands = commands;
    }

    public void exec() {
        initSycCalls();
        currentCommandIndex = labels.get("main");
        while (currentCommandIndex != -1 && currentCommandIndex < commands.size()) {
            InterpreterCommand command = commands.get(currentCommandIndex++);
            try {
                switch (command.command()) {
                    case CommandType.POP -> processPop();
                    case CommandType.PUSH -> processPush(command);
                    case CommandType.DUP -> processDup();
                    case CommandType.SET -> processSet();
                    case CommandType.LOAD -> processLoad();
                    case CommandType.ADD, CommandType.SUB, CommandType.MUL, CommandType.DIV, CommandType.MOD,
                         CommandType.EQ, CommandType.NEQ, CommandType.GT, CommandType.GTE, CommandType.LT,
                         CommandType.LTE -> processBinaryOperation(command);
                    case CommandType.NEG, CommandType.NOT -> processUnaryOperation(command);
                    case CommandType.JMF, CommandType.JMT -> processConditinalJump(command);
                    case CommandType.JMP -> processJump(command);
                    case CommandType.NEWARRAY -> processNewArray();
                    case CommandType.ASET -> processArraySet();
                    case CommandType.ALOAD -> processArrayLoad();
                    case CommandType.NEWOBJECT -> processNewObject();
                    case CommandType.SETFIELD -> processSetField();
                    case CommandType.GETFIELD -> processGetField();
                    case CommandType.NEWFUNC -> processNewFunction();
                    case CommandType.CALLFUNC -> processCallFunction();
                    case CommandType.RETURN -> processReturn();
                    case CommandType.HALT -> processHalt();
                }
            } catch (Exception e) {
                log.error("Error on line: {}", command.lineNumber(), e);
                break;
            }
        }
    }

    public Map<String, Integer> getLabels() {
        return labels;
    }

    public List<InterpreterCommand> getCommands() {
        return commands;
    }

    public Deque<Value<?>> getStack() {
        return stack;
    }

    public Deque<Integer> getReturnPoints() {
        return returnPoints;
    }

    public Context getContext() {
        return context;
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
            STDOUT.println("=== Авторы сего недоразумения! ===");
            STDOUT.println("Человек, который решил что знает ассемблер: Путин Павел");
            STDOUT.println("Frontender, нашедший способ писать на js даже компиляторы: Шлыков Данила");
            STDOUT.println("Кодогенератор во плоти, пожалуйста: Евгений Саков");
        }));
    }

    private void processHalt() {
        log.debug("Executing halt command");
        currentCommandIndex = -1;
    }

    private void processReturn() {
        log.debug("Executing return command");
        context = context.getParent();
        currentCommandIndex = returnPoints.pop();
    }

    private void processCallFunction() {
        Value<?> callable = stack.pop();
        context = new Context(context);
        ArrayValue args = stack.pop().asArray();

        switch (callable) {
            case FunctionValue function -> {
                log.debug("Executing callfunc command (function)");
                returnPoints.push(currentCommandIndex);
                context.setVariable("__args__", args);
                currentCommandIndex = labels.get(function.getCodeBodyLabel());
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

    private void processNewFunction() {
        log.debug("Executing newfunc command");
        String label = stack.pop().asString().getValue();
        FunctionValue function = new FunctionValue(label);
        stack.push(function);
    }

    private void processGetField() {
        log.debug("Executing getfield command");
        String fieldName = stack.pop().asString().getValue();
        ObjectValue object = stack.pop().asObject();
        stack.push(object.get(fieldName));
    }

    private void processSetField() {
        log.debug("Executing setfield command");
        Value<?> value = stack.pop();
        String fieldName = stack.pop().asString().getValue();
        ObjectValue object = stack.pop().asObject();
        object.put(fieldName, value);
    }

    private void processNewObject() {
        log.debug("Executing newobject command");
        stack.push(new ObjectValue(new HashMap<>()));
    }

    private void processArrayLoad() {
        log.debug("Executing aload command");
        int index = stack.pop().asNum().getValue();
        ArrayValue array = stack.pop().asArray();
        stack.push(array.get(index));
    }

    private void processArraySet() {
        log.debug("Executing aset command");
        Value<?> value = stack.pop();
        int index = stack.pop().asNum().getValue();
        ArrayValue array = stack.pop().asArray();
        array.set(index, value);
    }

    private void processNewArray() {
        log.debug("Executing newarray command");
        stack.push(new ArrayValue(new ArrayList<>()));
    }

    private void processJump(InterpreterCommand command) {
        log.debug("Executing jmp command");
        currentCommandIndex = labels.get(command.argument().asString().getValue());
    }

    private void processConditinalJump(InterpreterCommand command) {
        log.debug("Executing conditional jump {} command", command.command().name().toLowerCase());
        Value<?> val = stack.pop();
        if (val.getType() != ValueType.BOOL) {
            throw new RuntimeException("Illegal value '" + val + "'");
        }
        boolean jump = command.command().equals(CommandType.JMT) == val.asBool().getValue();
        if (jump) {
            currentCommandIndex = labels.get(command.argument().asString().getValue());
        }
    }

    private void processUnaryOperation(InterpreterCommand command) {
        log.debug("Executing unary {} command", command.command().name().toLowerCase());
        Value<?> val = stack.pop();
        Value<?> result = Operation.unaryImplementation
                .get(Operation.Unary.valueOf(command.command().toString()))
                .get(val.getType()).apply(val);
        stack.push(result);
    }

    private void processBinaryOperation(InterpreterCommand command) {
        log.debug("Executing binary {} command", command.command().name().toLowerCase());
        Value<?> val1 = stack.pop();
        Value<?> val2 = stack.pop();
        Value<?> result = Operation.binaryImplementation
                .get(Operation.Binary.valueOf(command.command().toString()))
                .get(val1.getType()).apply(val1, val2);
        stack.push(result);
    }

    private void processLoad() {
        log.debug("Executing load command");
        StringValue var = stack.pop().asString();
        Value<?> val = context.get(var.getValue());
        stack.push(val);
    }

    private void processSet() {
        log.debug("Executing set command");
        StringValue var = stack.pop().asString();
        Value<?> argument = stack.pop();
        context.setVariable(var.getValue(), argument);
    }

    private void processDup() {
        log.debug("Executing dup command");
        stack.push(stack.peek());
    }

    private void processPush(InterpreterCommand command) {
        log.debug("Executing push command");
        stack.push(command.argument());
    }

    private void processPop() {
        log.debug("Executing pop command");
        stack.pop();
    }
}
