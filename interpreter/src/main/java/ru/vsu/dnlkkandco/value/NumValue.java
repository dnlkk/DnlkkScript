package ru.vsu.dnlkkandco.value;

import ru.vsu.dnlkkandco.ValueType;

public class NumValue extends Value<Integer> implements Comparable<NumValue> {
    public NumValue(int value) {
        super(value);
    }

    @Override
    public ValueType getType() {
        return ValueType.NUM;
    }

    @Override
    public NumValue asNum() {
        return this;
    }

    @Override
    public DoubleValue asDouble() {
        return new DoubleValue(getValue().doubleValue());
    }

    @Override
    public StringValue asString() {
        return new StringValue(getValue().toString());
    }

    @Override
    public int compareTo(NumValue o) {
        return getValue().compareTo(o.getValue());
    }
}

