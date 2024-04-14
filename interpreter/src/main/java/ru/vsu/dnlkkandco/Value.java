package ru.vsu.dnlkkandco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Value {
    private final ValueType type;
    private final Object value;
    private final Map<String, Value> members;
    private final List<Value> indexable;

    public Value(ValueType type, Object value) {
        this.type = type;
        this.value = value;
        members = new HashMap<>();
        indexable = new ArrayList<>();
    }

    public ValueType getType() {
        return type;
    }
}
