package ru.vsu.dnlkkandco.value;

import ru.vsu.dnlkkandco.ValueType;

public class StringValue extends Value<String> implements Comparable<StringValue> {
    public StringValue(String value) {
        super(value);
    }

    @Override
    public ValueType getType() {
        return ValueType.STRING;
    }

    @Override
    public NumValue asNum() {
        return new NumValue(Integer.parseInt(getValue()));
    }

    @Override
    public DoubleValue asDouble() {
        return new DoubleValue(Double.parseDouble(getValue()));
    }

    @Override
    public BoolValue asBool() {
        return new BoolValue(Boolean.parseBoolean(getValue()));
    }

    @Override
    public StringValue asString() {
        return this;
    }

    @Override
    public int compareTo(StringValue o) {
        return getValue().compareTo(o.getValue());
    }

    @Override
    public String toString() {
        return "\"" + getValue() + "\"";
    }
}
