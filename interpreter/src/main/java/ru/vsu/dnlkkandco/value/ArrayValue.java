package ru.vsu.dnlkkandco.value;

import ru.vsu.dnlkkandco.ValueType;

import java.util.List;
import java.util.Objects;

public class ArrayValue extends ReferenceValue<List<Value<?>>> {

    public ArrayValue(String ref, List<Value<?>> value) {
        super(ref, value);
    }

    @Override
    public ValueType getType() {
        return ValueType.FUNCTION;
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
