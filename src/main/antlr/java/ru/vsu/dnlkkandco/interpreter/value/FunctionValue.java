package ru.vsu.dnlkkandco.interpreter.value;

import ru.vsu.dnlkkandco.interpreter.ValueType;

public class FunctionValue extends Value<String> {

    public FunctionValue(String value) {
        super(value);
    }

    public String getCodeBodyLabel() {
        return getValue();
    }

    @Override
    public ValueType getType() {
        return ValueType.FUNCTION;
    }

    @Override
    public FunctionValue asFunction() {
        return this;
    }
}
