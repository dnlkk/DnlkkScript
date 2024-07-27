package ru.vsu.dnlkkandco.interpreter.value;

import ru.vsu.dnlkkandco.interpreter.ValueType;

public class UndefinedValue extends Value<Object> {
    public UndefinedValue() {
        super(null);
    }

    @Override
    public ValueType getType() {
        return ValueType.UNDEFINED;
    }

    @Override
    public StringValue asString() {
        return new StringValue("$undefined");
    }

    @Override
    public String toString() {
        return "$undefined";
    }
}
