package ru.vsu.dnlkkandco.interpreter.value;

import ru.vsu.dnlkkandco.interpreter.ValueType;

import java.util.List;
import java.util.Objects;

public class ArrayValue extends Value<List<Value<?>>> {

    public ArrayValue(List<Value<?>> value) {
        super(value);
    }

    public Value<?> get(int index) {
        return getValue().size() <= index ? new UndefinedValue() : getValue().get(index);
    }

    public Value<?> set(int index, Value<?> value) {
        while (getValue().size() <= index) {
            getValue().add(new UndefinedValue());
        }
        return getValue().set(index, value);
    }

    @Override
    public ValueType getType() {
        return ValueType.ARRAY;
    }

    @Override
    public ArrayValue asArray() {
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (!(obj instanceof ArrayValue)) return false;
        return getValue().equals(((ArrayValue) obj).getValue());
    }
}
