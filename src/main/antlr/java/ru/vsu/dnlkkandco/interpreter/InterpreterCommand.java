package ru.vsu.dnlkkandco.interpreter;

import ru.vsu.dnlkkandco.interpreter.value.Value;

public record InterpreterCommand(CommandType command, Value<?> argument, int lineNumber) {}
