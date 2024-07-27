package ru.vsu.dnlkkandco.interpreter;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SysCallsDefinition {

    private final Scanner STDIN;
    private final PrintStream STDOUT;

    public SysCallsDefinition(Scanner stdin, PrintStream stdout) {
        STDIN = stdin;
        STDOUT = stdout;
    }

    public String in() {
        return STDIN.nextLine();
    }

    public void out(String ... valuesToPrint) {
        STDOUT.println(String.join(" ", valuesToPrint));
    }

    public int len(List<?> value) {
        return value.size();
    }

    public int len(String value) {
        return value.length();
    }

    public int len(Map<?, ?> value) {
        return value.size();
    }

    public double abs(double value) {
        return Math.abs(value);
    }

    public double sqrt(double value) {
        return Math.sqrt(value);
    }

    public double pow(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public double sin(double value) {
        return Math.sin(value);
    }

    public double cos(double value) {
        return Math.cos(value);
    }

    public double tan(double value) {
        return Math.tan(value);
    }

    public double antan(double value) {
        return Math.atan(value);
    }
}
