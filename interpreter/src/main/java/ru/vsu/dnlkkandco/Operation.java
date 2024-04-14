package ru.vsu.dnlkkandco;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Operation {
    public enum Binary {
        ADD, SUB, MUL, DIV, MOD, AND, OR, EQUAL, NOTEQUAL, LESS, LESS_EQUAL, GREATER, GREATER_EQUAL,
    }

    @FunctionalInterface
    public interface BinaryOperation extends BiFunction<Value, Value, Value> {}

    public enum Unary {
        NEG, NOT
    }

    @FunctionalInterface
    public interface UnaryOperation extends Function<Value, Value> {}

    public static Map<Binary, Map<ValueType, BinaryOperation>> binaryImplementation = new HashMap<>();
    public static Map<Unary, Map<ValueType, UnaryOperation>> unaryImplementation = new HashMap<>();

    static {
        // BINARY OPERATIONS
        Map<ValueType, BinaryOperation> add = new HashMap<>();
        add.put(ValueType.NUM, (v1, v2) -> new NumValue(v1.asNum() + v2.asNum()));
        add.put(ValueType.DOUBLE, (v1, v2) -> new DoubleValue(v1.asDouble() + v2.asDouble()));
        add.put(ValueType.STRING, (v1, v2) -> new Value(ValueType.STRING, v1.asString() + v2.asString()));
        binaryImplementation.put(Binary.ADD, add);

        Map<ValueType, BinaryOperation> sub = new HashMap<>();
        sub.put(ValueType.NUM, (v1, v2) -> new NumValue(v1.asNum() - v2.asNum()));
        sub.put(ValueType.DOUBLE, (v1, v2) -> new DoubleValue(v1.asDouble() - v2.asDouble()));
        binaryImplementation.put(Binary.SUB, sub);

        Map<ValueType, BinaryOperation> mul = new HashMap<>();
        mul.put(ValueType.NUM, (v1, v2) -> new NumValue(v1.asNum() * v2.asNum()));
        mul.put(ValueType.DOUBLE, (v1, v2) -> new DoubleValue(v1.asDouble() / v2.asDouble()));
        binaryImplementation.put(Binary.MUL, mul);

        Map<ValueType, BinaryOperation> div = new HashMap<>();
        div.put(ValueType.NUM, (v1, v2) -> new NumValue(v1.asNum() / v2.asNum()));
        div.put(ValueType.DOUBLE, (v1, v2) -> new DoubleValue(v1.asDouble() / v2.asDouble()));
        binaryImplementation.put(Binary.DIV, div);

        Map<ValueType, BinaryOperation> mod = new HashMap<>();
        mod.put(ValueType.NUM, (v1, v2) -> new NumValue(v1.asNum() % v2.asNum()));
        mod.put(ValueType.DOUBLE, (v1, v2) -> new DoubleValue(v1.asDouble() % v2.asDouble()));
        binaryImplementation.put(Binary.MOD, mod);

        Map<ValueType, BinaryOperation> and = new HashMap<>();
        and.put(ValueType.BOOL, (v1, v2) -> new BoolValue(v1.asBool() && v2.asBool()));
        binaryImplementation.put(Binary.AND, and);

        Map<ValueType, BinaryOperation> or = new HashMap<>();
        or.put(ValueType.BOOL, (v1, v2) -> new BoolValue(v1.asBool() || v2.asBool()));
        binaryImplementation.put(Binary.OR, or);

        Map<ValueType, BinaryOperation> equal = new HashMap<>();
        equal.put(ValueType.NULL, (v1, v2) -> new BoolValue(v2.getType().equals(ValueType.NULL)));
        equal.put(ValueType.UNDEFINED, (v1, v2) -> new BoolValue(false));
        equal.put(ValueType.BOOL, (v1, v2) -> new BoolValue(v1.asBool() == v2.asBool()));
        equal.put(ValueType.NUM, (v1, v2) -> new BoolValue(v1.asNum() == v2.asNum()));
        equal.put(ValueType.DOUBLE, (v1, v2) -> new BoolValue(v1.asDouble() == v2.asDouble()));
        equal.put(ValueType.STRING, (v1, v2) -> new BoolValue(v1.asString().equals(v2.asString())));
        equal.put(ValueType.FUNCTION, (v1, v2) -> new BoolValue(v1.asFunction().equals(v2.asFunction())));
        equal.put(ValueType.ARRAY, (v1, v2) -> new BoolValue(v1.asArray().equals(v2.asArray())));
        equal.put(ValueType.OBJECT, (v1, v2) -> new BoolValue(v1.asObject().equals(v2.asObject())));
        binaryImplementation.put(Binary.EQUAL, equal);

        Map<ValueType, BinaryOperation> notequal = new HashMap<>();
        notequal.put(ValueType.NULL, (v1, v2) -> new BoolValue(!v2.getType().equals(ValueType.NULL)));
        notequal.put(ValueType.UNDEFINED, (v1, v2) -> new BoolValue(false));
        notequal.put(ValueType.BOOL, (v1, v2) -> new BoolValue(v1.asBool() != v2.asBool()));
        notequal.put(ValueType.NUM, (v1, v2) -> new BoolValue(v1.asNum() != v2.asNum()));
        notequal.put(ValueType.DOUBLE, (v1, v2) -> new BoolValue(v1.asDouble() != v2.asDouble()));
        notequal.put(ValueType.STRING, (v1, v2) -> new BoolValue(!v1.asString().equals(v2.asString())));
        notequal.put(ValueType.FUNCTION, (v1, v2) -> new BoolValue(!v1.asFunction().equals(v2.asFunction())));
        notequal.put(ValueType.ARRAY, (v1, v2) -> new BoolValue(!v1.asArray().equals(v2.asArray())));
        notequal.put(ValueType.OBJECT, (v1, v2) -> new BoolValue(!v1.asObject().equals(v2.asObject())));
        binaryImplementation.put(Binary.NOTEQUAL, notequal);

        Map<ValueType, BinaryOperation> less = new HashMap<>();
        less.put(ValueType.NUM, (v1, v2) -> new BoolValue(v1.asNum() < v2.asNum()));
        less.put(ValueType.DOUBLE, (v1, v2) -> new BoolValue(v1.asDouble() < v2.asDouble()));
        less.put(ValueType.STRING, (v1, v2) -> new BoolValue(v1.asString().compareTo(v2.asString()) < 0));
        binaryImplementation.put(Binary.LESS, less);

        Map<ValueType, BinaryOperation> lessEqual = new HashMap<>();
        lessEqual.put(ValueType.NUM, (v1, v2) -> new BoolValue(v1.asNum() <= v2.asNum()));
        lessEqual.put(ValueType.DOUBLE, (v1, v2) -> new BoolValue(v1.asDouble() <= v2.asDouble()));
        lessEqual.put(ValueType.STRING, (v1, v2) -> new BoolValue(v1.asString().compareTo(v2.asString()) <= 0));
        binaryImplementation.put(Binary.LESS_EQUAL, lessEqual);

        Map<ValueType, BinaryOperation> greater = new HashMap<>();
        greater.put(ValueType.NUM, (v1, v2) -> new BoolValue(v1.asNum() > v2.asNum()));
        greater.put(ValueType.DOUBLE, (v1, v2) -> new BoolValue(v1.asDouble() > v2.asDouble()));
        greater.put(ValueType.STRING, (v1, v2) -> new BoolValue(v1.asString().compareTo(v2.asString()) > 0));
        binaryImplementation.put(Binary.GREATER, greater);

        Map<ValueType, BinaryOperation> greaterEqual = new HashMap<>();
        greaterEqual.put(ValueType.NUM, (v1, v2) -> new BoolValue(v1.asNum() >= v2.asNum()));
        greaterEqual.put(ValueType.DOUBLE, (v1, v2) -> new BoolValue(v1.asDouble() >= v2.asDouble()));
        greaterEqual.put(ValueType.STRING, (v1, v2) -> new BoolValue(v1.asString().compareTo(v2.asString()) >= 0));
        binaryImplementation.put(Binary.LESS_EQUAL, greaterEqual);


        // UNARY OPERATIONS
        Map<ValueType, UnaryOperation> neg = new HashMap<>();
        neg.put(ValueType.NUM, v -> new NumValue(-v.asNum()));
        neg.put(ValueType.DOUBLE, v -> new DoubleValue(-v.asDouble()));
        unaryImplementation.put(Unary.NEG, neg);

        Map<ValueType, UnaryOperation> not = new HashMap<>();
        not.put(ValueType.BOOL, v -> new BoolValue(-v.asBool()));
        unaryImplementation.put(Unary.NOT, not);
    }
}
