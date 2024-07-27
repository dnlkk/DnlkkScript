package ru.vsu.dnlkkandco.interpreter.value;

import ru.vsu.dnlkkandco.interpreter.ValueType;

public abstract class Value<T> {
    private final T value;

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
}
