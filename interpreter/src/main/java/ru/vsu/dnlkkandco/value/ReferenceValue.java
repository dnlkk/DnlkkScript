package ru.vsu.dnlkkandco.value;

public abstract class ReferenceValue<T> extends Value<T> {
    private final String ref;

    public ReferenceValue(String ref, T value) {
        super(value);
        this.ref = ref;
    }

    public String getRef() {
        return ref;
    }

    @Override
    public StringValue asString() {
        return new StringValue(getRef());
    }

    @Override
    public String toString() {
        return "@" + getRef();
    }
}
