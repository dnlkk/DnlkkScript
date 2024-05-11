package ru.vsu.dnlkkandco;

import ru.vsu.dnlkkandco.value.Value;

public record InterpreterCommand(CommandType command, Value<?> argument, int lineNumber) {}
