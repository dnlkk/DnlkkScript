package ru.vsu.dnlkkandco;

import java.util.Objects;

public abstract class Value<T> {
    private T value;

    public Value(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public abstract ValueType getType();

    public NumValue asNum() {throw new UnsupportedOperationException("Cannot convert to NumValue");}
    public DoubleValue asDouble() {throw new UnsupportedOperationException("Cannot convert to DoubleValue");}
    public BoolValue asBool() {throw new UnsupportedOperationException("Cannot convert to BoolValue");}
    public StringValue asString() {throw new UnsupportedOperationException("Cannot convert to StringValue");}
    public FunctionValue asFunction() {throw new UnsupportedOperationException("Cannot convert to FunctionValue");}
    public ArrayValue asArray() {throw new UnsupportedOperationException("Cannot convert to ArrayValue");}
    public ObjectValue asObject() {throw new UnsupportedOperationException("Cannot convert to ObjectValue");}

    public static class NumValue extends Value<Integer> implements Comparable<NumValue> {
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
        public int compareTo(NumValue o) {
            return getValue().compareTo(o.getValue());
        }
    }

    public static class DoubleValue extends Value<Double> implements Comparable<DoubleValue> {
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

    public static class BoolValue extends Value<Boolean> {
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
    }
}
