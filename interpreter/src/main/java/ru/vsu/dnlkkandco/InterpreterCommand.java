package ru.vsu.dnlkkandco;

public record InterpreterCommand(CommandType command, String argument, int lineNumber) {}
