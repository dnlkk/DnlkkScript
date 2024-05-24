package ru.vsu.dnlkkandco.value;

import ru.vsu.dnlkkandco.ValueType;

import java.util.Deque;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class SysCall extends Value<BiConsumer<ArrayValue, Deque<Value<?>>>>{
    public SysCall(BiConsumer<ArrayValue, Deque<Value<?>>> value) {
        super(value);
    }

    @Override
    public ValueType getType() {
        return ValueType.FUNCTION;
    }
}
