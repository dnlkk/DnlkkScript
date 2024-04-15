package ru.vsu.dnlkkandco;

import ru.vsu.dnlkkandco.value.ArrayValue;
import ru.vsu.dnlkkandco.value.StringValue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class Interpreter {
    public static void main(String[] args) {

    }

    private static final String LABEL_MARKER = "#";

    private final Path source;
    private final Map<String, Integer> labels;
    private final List<String> commands;
    private boolean preprocessed = false;
    private int ip; // processor register
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
        ip = labels.get("main");
        Context context = new Context(null);

        while (ip < commands.size()) {
            String command = commands.get(ip++);
            String operation = command.substring(0, command.indexOf(" ")).toUpperCase();
            String argument = command.substring(command.indexOf(" ") + 1);

            switch (operation) {
                case "POP" -> stack.pop();
                case "PUSH" -> stack.push(argument);
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
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" ");

                if (!tokens[0].startsWith(LABEL_MARKER))
                    continue;

                String label = tokens[0].substring(1);
                if (label.isEmpty()) {
                    throw new LabelIsEmptyException("Empty label");
                }

                if (labels.containsKey(label)) {
                    throw new DuplicateLabelException("Duplicate label: " + label + " on line " + lineNumber);
                }

                try {
                    int jumpNumber = Integer.parseInt(tokens[1]);
                    if (jumpNumber < 0) {
                        throw new NegativeJumpTargetException("Negative jump number: " + jumpNumber + " on line " + lineNumber);
                    }
                    labels.put(label, jumpNumber);
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new NoJumpTargetException("Bad label: " + label + " on line " + lineNumber);
                } catch (NumberFormatException e) {
                    throw new CantParseJumpTargetException("Can't parse jump destination for " + label + " on line " + lineNumber);
                }

                commands.add(line);
            }

            for (var labelsEntry : labels.entrySet()) {
                if (labelsEntry.getValue() > commands.size()) {
                    throw new OutOfBoundsJumpTargetException("Out of bounds jump target: " + labelsEntry.getValue() + " for label " + labelsEntry.getKey());
                }
            }

            if (!labels.containsKey("main")) {
                throw new NoMainLabelException("No main label");
            }

            preprocessed = true;
        }
    }

    private static class LabelIsEmptyException extends RuntimeException {
        public LabelIsEmptyException(String label) {}
    }

    private static class DuplicateLabelException extends RuntimeException {
        public DuplicateLabelException(String label) {}
    }

    private static class NoJumpTargetException extends RuntimeException {
        public NoJumpTargetException(String label) {}
    }

    private static class CantParseJumpTargetException extends RuntimeException {
        public CantParseJumpTargetException(String label) {}
    }

    private static class NegativeJumpTargetException extends RuntimeException {
        public NegativeJumpTargetException(String label) {}
    }

    private static class OutOfBoundsJumpTargetException extends RuntimeException {
        public OutOfBoundsJumpTargetException(String label) {}
    }

    private static class NoMainLabelException extends RuntimeException {
        public NoMainLabelException(String label) {}
    }
}
