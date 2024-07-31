package ru.vsu.dnlkkandco.interpreter;

import ru.vsu.dnlkkandco.interpreter.value.Value;

import java.util.*;

public class Context implements Iterable<Context> {
    private final Context parent;
    private final Map<String, Value<?>> variables;

    public Context(Context parent) {
        this.parent = parent;
        this.variables = new HashMap<>();
    }

    public boolean containsVariable(String key) {
        return variables.containsKey(key);
    }

    public Value<?> get(String varName) {
        for (var context : this) {
            if (context.containsVariable(varName)) {
                return context.variables.get(varName);
            }
        }
        throw new NoSuchElementException("No such variable: " + varName);
    }

    public void setVariable(String key, Value<?> value) {
        variables.put(key, value);
    }

    public Context getParent() {
        return parent;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Context context = (Context) o;
        return Objects.equals(parent, context.parent) && Objects.equals(variables, context.variables);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parent, variables);
    }
}
