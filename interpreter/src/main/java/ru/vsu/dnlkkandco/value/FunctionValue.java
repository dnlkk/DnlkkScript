package ru.vsu.dnlkkandco.value;

import ru.vsu.dnlkkandco.ValueType;

public class FunctionValue extends Value<String> {
    private String[] args;
    public FunctionValue(String value, String ... args) {
        super(value);
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
