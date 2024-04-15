package ru.vsu.dnlkkandco.value;

import ru.vsu.dnlkkandco.ValueType;

public class FunctionValue extends ReferenceValue<String> {
    private String[] args;
    public FunctionValue(String ref, String value, String ... args) {
        super(ref, value);
        this.args = args;
    }

    public String getCodeBodyLabel() {
        return getValue();
    }

    public String[] getArgs() {
        return args;
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
