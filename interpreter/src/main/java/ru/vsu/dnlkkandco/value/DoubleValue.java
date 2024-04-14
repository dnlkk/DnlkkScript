package ru.vsu.dnlkkandco.value;

import ru.vsu.dnlkkandco.ValueType;

public class DoubleValue extends Value<Double> implements Comparable<DoubleValue> {
    public DoubleValue(double value) {
        super(value);
    }

    @Override
    public ValueType getType() {
        return ValueType.DOUBLE;
    }

    @Override
    public NumValue asNum() {
        return new NumValue(getValue().intValue());
    }

    @Override
    public DoubleValue asDouble() {
        return this;
    }

    @Override
    public int compareTo(DoubleValue o) {
        return getValue().compareTo(o.getValue());
    }
}

