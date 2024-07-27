package ru.vsu.dnlkkandco.interpreter.value;

import ru.vsu.dnlkkandco.interpreter.ValueType;

import java.util.Map;
import java.util.Objects;

public class ObjectValue extends Value<Map<String, Value<?>>> {
    public ObjectValue(Map<String, Value<?>> value) {
        super(value);
    }

    public Value<?> put(String fieldName, Value<?> value) {
        return getValue().put(fieldName, value);
    }

    public Value<?> get(String fieldName) {
        return getValue().getOrDefault(fieldName, new UndefinedValue());
    }

    @Override
    public ValueType getType() {
        return ValueType.OBJECT;
    }

    @Override
    public ObjectValue asObject() {
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
        if (!(obj instanceof ObjectValue)) return false;
        return getValue().equals(((ObjectValue) obj).getValue());
    }
}

