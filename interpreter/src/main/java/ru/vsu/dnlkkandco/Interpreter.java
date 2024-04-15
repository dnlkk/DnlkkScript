package ru.vsu.dnlkkandco;

import com.sun.jdi.IntegerValue;
import ru.vsu.dnlkkandco.value.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

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
    private Context context = new Context(null);

    public Interpreter(Path source) {
        this.source = source;
        labels = new HashMap<>();
        commands = new ArrayList<>();
        stack = new ArrayDeque<>();
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

            switch (command.operation()) {
                case "POP" -> stack.pop();
                case "PUSH" -> stack.push(command.argument());
                case "SET" -> {
                    String var = stack.pop();
                    if (!(var.startsWith("\"") && var.endsWith("\""))) {
                        throw new RuntimeException("Illegal variable '" + var + "'");
                    }
                    var = var.substring(1, var.length() - 1);
                    String argument = stack.pop();

                    context.setVariable(var, argumentToValue(argument));
                }
                case "NEWARRAY" -> {
                    String ref = stack.pop();
                    if (!ref.startsWith(REFERENCE_MARKER)) {
                        throw new RuntimeException("Invalid reference: " + ref);
                    }
                    ref = ref.substring(1);
                    if (!context.containsVariable(ref)) {
                        context.setReference(ref, new ArrayValue(ref, new ArrayList<>()));
                    }
                }
                case "LOAD" -> {
                    String var = stack.pop();
                    StringValue val = context.get(var).asString();
                    stack.push(val.toString());
                }
                case "ADD" -> {
                    Value<?> val1 = argumentToValue(stack.pop());
                    Value<?> val2 = argumentToValue(stack.pop());
                    Value<?> result = Operation.binaryImplementation.get(Operation.Binary.ADD).get(val1.getType()).apply(val1, val2);
                    stack.push(result.toString());
                }
            }
        }
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
                        commands.add(new InterpreterCommand(line.toUpperCase(), null));
                    } else {
                        String operation = line.substring(0, delimiterIndex);
                        String argument = line.substring(delimiterIndex + 1);
                        commands.add(new InterpreterCommand(operation.toUpperCase(), argument));
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
