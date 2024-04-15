package ru.vsu.dnlkkandco;

import ru.vsu.dnlkkandco.value.ArrayValue;
import ru.vsu.dnlkkandco.value.StringValue;

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

    private final Path source;
    private final Map<String, Integer> labels;
    private final List<InterpreterCommand> commands;
    private boolean preprocessed = false;
    private final Deque<String> stack;

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
        Context context = new Context(null);

        while (ip < commands.size()) {
            InterpreterCommand command = commands.get(ip++);

            switch (command.operation()) {
                case "POP" -> stack.pop();
                case "PUSH" -> stack.push(command.argument());
                case "SET" -> {
                    String var = stack.pop();
                    StringValue val = new StringValue(stack.pop());
                    context.setVariable(var, val);
                }
                case "SETARRAY" -> {
                    String var = stack.pop();
                    String ref = stack.pop();
                    if (!context.containsVariable(ref)) {
                        context.setReference(ref, new ArrayValue(ref, new ArrayList<>()));
                    }
                    context.setVariable(var, context.get(ref));
                }
                case "LOAD" -> {
                    String var = stack.pop();
                    StringValue val = context.get(var).asString();
                    stack.push(val.toString());
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
