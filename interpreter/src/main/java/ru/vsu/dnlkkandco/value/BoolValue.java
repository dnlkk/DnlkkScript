package ru.vsu.dnlkkandco.value;

import ru.vsu.dnlkkandco.ValueType;

public class BoolValue extends Value<Boolean> {
    public BoolValue(boolean value) {
        super(value);
    }

    @Override
    public ValueType getType() {
        return ValueType.BOOL;
    }

    @Override
    public BoolValue asBool() {
        return this;
    }

    @Override
    public StringValue asString() {
        return new StringValue(getValue().toString());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (!(obj instanceof BoolValue)) return false;
        return getValue().equals(((BoolValue) obj).getValue());
    }

    @Override
    public String toString() {
        return "B" + getValue().toString();
    }
}
