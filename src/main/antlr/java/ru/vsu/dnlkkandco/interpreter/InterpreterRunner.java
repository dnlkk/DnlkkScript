package ru.vsu.dnlkkandco.interpreter;

import java.io.IOException;
import java.nio.file.Path;

public class InterpreterRunner {
    public static void main(String[] args) throws IOException {
        Path source = Path.of(args[0]);
        var preprocessor = new AssemblerPreprocessor(source);
        Interpreter interpreter = preprocessor.preprocess();
        interpreter.exec();
    }
}
