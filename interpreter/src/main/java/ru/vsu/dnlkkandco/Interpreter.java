package ru.vsu.dnlkkandco;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Interpreter {
    public static void main(String[] args) {

    }

    private static final String LABEL_MARKER = "#";

    private final Path source;
    private final Map<String, Integer> labels;
    private final List<String> commands;
    private boolean preprocessed = false;
    private int ip; // processor register

    public Interpreter(Path source) {
        this.source = source;
        labels = new HashMap<>();
        commands = new ArrayList<>();
    }

    public void exec() {}

    private void preprocess() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(source.toFile()))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" ");
                if (tokens[0].startsWith(LABEL_MARKER)) {
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
                }

                commands.add(line);
            }

            for (var labelsEntry : labels.entrySet()) {
                if (labelsEntry.getValue() > commands.size()) {
                    throw new OutOfBoundsJumpTargetException("Out of bounds jump target: " + labelsEntry.getValue() + " for label " + labelsEntry.getKey());
                }
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
}
