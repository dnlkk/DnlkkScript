package ru.vsu.dnlkkandco;

import ru.vsu.dnlkkandco.value.ReferenceValue;
import ru.vsu.dnlkkandco.value.Value;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class Context implements Iterable<Context> {
    private final Context parent;
    private final Map<String, Value<?>> variables;
    private final Map<String, ReferenceValue<?>> references;

    public Context(Context parent) {
        this.parent = parent;
        this.variables = new HashMap<>();
        this.references = new HashMap<>();
    }

    public boolean containsVariable(String key) {
        return variables.containsKey(key);
    }

    public Value<?> get(String varName) {
        for (var context : this) {
            if (context.containsVariable(varName)) {
                return context.get(varName);
            }
        }
        throw new NoSuchElementException("No such variable: " + varName);
    }

    public void setVariable(String key, Value<?> value) {
        variables.put(key, value);
    }

    public void setReference(String key, ReferenceValue<?> value) {
        references.put(key, value);
    }

    @Override
    public Iterator<Context> iterator() {
        final Context start = this;
        return new Iterator<>() {
            Context current = start;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Context next() {
                Context next = current;
                current = current.parent;
                return next;
            }
        };
    }
}
