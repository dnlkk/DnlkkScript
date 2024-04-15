package ru.vsu.dnlkkandco.value;

import ru.vsu.dnlkkandco.ValueType;

public class NullValue extends Value<Object> {
    public NullValue() {
        super(null);
    }

    @Override
    public StringValue asString() {
        return new StringValue("!null");
    }

    @Override
    public ValueType getType() {
        return ValueType.NULL;
    }

    @Override
    public String toString() {
        return "!null";
    }
}
