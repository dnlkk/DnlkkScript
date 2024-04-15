package ru.vsu.dnlkkandco.value;

import ru.vsu.dnlkkandco.ValueType;

public class FunctionValue extends ReferenceValue<String> {
    public FunctionValue(String ref, String value) {
        super(ref, value);
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
