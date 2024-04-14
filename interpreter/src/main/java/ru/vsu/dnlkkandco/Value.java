package ru.vsu.dnlkkandco;

public abstract class Value<T> {
    private T value;

    public Value(ValueType type) {}

    public abstract ValueType getType();
    public NumValue asNum() {throw new UnsupportedOperationException("Cannot convert to NumValue");};
    public DoubleValue asDouble() {throw new UnsupportedOperationException("Cannot convert to DoubleValue");};
    public BoolValue asBool() {throw new UnsupportedOperationException("Cannot convert to BoolValue");};
    public StringValue asString() {throw new UnsupportedOperationException("Cannot convert to StringValue");};
    public FunctionValue asFunction() {throw new UnsupportedOperationException("Cannot convert to FunctionValue");};
    public ArrayValue asArray() {throw new UnsupportedOperationException("Cannot convert to ArrayValue");};
    public ObjectValue asObject() {throw new UnsupportedOperationException("Cannot convert to ObjectValue");};
}
