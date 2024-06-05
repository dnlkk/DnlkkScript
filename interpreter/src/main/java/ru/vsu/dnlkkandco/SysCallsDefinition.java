package ru.vsu.dnlkkandco;

import ru.vsu.dnlkkandco.value.ArrayValue;
import ru.vsu.dnlkkandco.value.StringValue;
import ru.vsu.dnlkkandco.value.SysCall;
import ru.vsu.dnlkkandco.value.Value;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.stream.Collectors;

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

    public void out(ArrayValue args) {
        STDOUT.println(args.getValue()
                .stream()
                .map(Value::getValue)
                .map(Object::toString)
                .collect(Collectors.joining(" "))
        );
    }
}
