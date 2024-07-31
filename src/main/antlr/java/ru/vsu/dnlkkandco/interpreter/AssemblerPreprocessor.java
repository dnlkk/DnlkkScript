package ru.vsu.dnlkkandco.interpreter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vsu.dnlkkandco.interpreter.value.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class AssemblerPreprocessor {
    private static final Logger log = LoggerFactory.getLogger(Interpreter.class);

    private static final String LABEL_MARKER = "#";
    private static final String NULL_MARKER = "!";
    private static final String UNDEFINED_MARKER = "$";
    private static final String NUM_MARKER = "N";
    private static final String DOUBLE_MARKER = "D";
    private static final String BOOL_MARKER = "B";

    private final Path source;
    private final Map<String, Integer> labels = new HashMap<>();
    private final List<InterpreterCommand> commands = new ArrayList<>();

    public AssemblerPreprocessor(Path source) {
        this.source = source;
    }

    public Interpreter preprocess() throws IOException {
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

            return new Interpreter(labels, commands);
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
