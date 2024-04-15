package ru.vsu.dnlkkandco.value;

import ru.vsu.dnlkkandco.ValueType;

import java.util.Map;
import java.util.Objects;

public class ObjectValue extends ReferenceValue<Map<String, Value<?>>> {
    public ObjectValue(String ref, Map<String, Value<?>> value) {
        super(ref, value);
    }

    @Override
    public ValueType getType() {
        return ValueType.OBJECT;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (!(obj instanceof ObjectValue)) return false;
        return getValue().equals(((ObjectValue) obj).getValue());
    }
}

