package ru.vsu.dnlkkandco;

import ru.vsu.dnlkkandco.value.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Operation {
    public enum Binary {
        ADD, SUB, MUL, DIV, MOD, AND, OR, EQUAL, NOTEQUAL, LESS, LESS_EQUAL, GREATER, GREATER_EQUAL,
    }

    @FunctionalInterface
    public interface BinaryOperation extends BiFunction<Value<?>, Value<?>, Value<?>> {}

    public enum Unary {
        NEG, NOT
    }

    @FunctionalInterface
    public interface UnaryOperation extends Function<Value<?>, Value<?>> {}

    public final static Map<Binary, Map<ValueType, BinaryOperation>> binaryImplementation = new HashMap<>();
    public final static Map<Unary, Map<ValueType, UnaryOperation>> unaryImplementation = new HashMap<>();

    static {
        // BINARY OPERATIONS
        Map<ValueType, BinaryOperation> add = new HashMap<>();
        add.put(ValueType.NUM, (v1, v2) -> new NumValue(v1.asNum().getValue() + v2.asNum().getValue()));
        add.put(ValueType.DOUBLE, (v1, v2) -> new DoubleValue(v1.asDouble().getValue() + v2.asDouble().getValue()));
        add.put(ValueType.STRING, (v1, v2) -> new StringValue(v1.asString().getValue() + v2.asString().getValue()));
        binaryImplementation.put(Binary.ADD, add);

        Map<ValueType, BinaryOperation> sub = new HashMap<>();
        sub.put(ValueType.NUM, (v1, v2) -> new NumValue(v1.asNum().getValue() - v2.asNum().getValue()));
        sub.put(ValueType.DOUBLE, (v1, v2) -> new DoubleValue(v1.asDouble().getValue() - v2.asDouble().getValue()));
        binaryImplementation.put(Binary.SUB, sub);

        Map<ValueType, BinaryOperation> mul = new HashMap<>();
        mul.put(ValueType.NUM, (v1, v2) -> new NumValue(v1.asNum().getValue() * v2.asNum().getValue()));
        mul.put(ValueType.DOUBLE, (v1, v2) -> new DoubleValue(v1.asDouble().getValue() / v2.asDouble().getValue()));
        binaryImplementation.put(Binary.MUL, mul);

        Map<ValueType, BinaryOperation> div = new HashMap<>();
        div.put(ValueType.NUM, (v1, v2) -> new NumValue(v1.asNum().getValue() / v2.asNum().getValue()));
        div.put(ValueType.DOUBLE, (v1, v2) -> new DoubleValue(v1.asDouble().getValue() / v2.asDouble().getValue()));
        binaryImplementation.put(Binary.DIV, div);

        Map<ValueType, BinaryOperation> mod = new HashMap<>();
        mod.put(ValueType.NUM, (v1, v2) -> new NumValue(v1.asNum().getValue() % v2.asNum().getValue()));
        mod.put(ValueType.DOUBLE, (v1, v2) -> new DoubleValue(v1.asDouble().getValue() % v2.asDouble().getValue()));
        binaryImplementation.put(Binary.MOD, mod);

        Map<ValueType, BinaryOperation> and = new HashMap<>();
        and.put(ValueType.BOOL, (v1, v2) -> new BoolValue(v1.asBool().getValue() && v2.asBool().getValue()));
        binaryImplementation.put(Binary.AND, and);

        Map<ValueType, BinaryOperation> or = new HashMap<>();
        or.put(ValueType.BOOL, (v1, v2) -> new BoolValue(v1.asBool().getValue() || v2.asBool().getValue()));
        binaryImplementation.put(Binary.OR, or);

        Map<ValueType, BinaryOperation> equal = new HashMap<>();
        equal.put(ValueType.NULL, (_, v) -> new BoolValue(v.getType().equals(ValueType.NULL)));
        equal.put(ValueType.UNDEFINED, (_, _) -> new BoolValue(false));
        equal.put(ValueType.BOOL, (v1, v2) -> new BoolValue(v1.asBool() == v2.asBool()));
        equal.put(ValueType.NUM, (v1, v2) -> new BoolValue(v1.asNum() == v2.asNum()));
        equal.put(ValueType.DOUBLE, (v1, v2) -> new BoolValue(v1.asDouble() == v2.asDouble()));
        equal.put(ValueType.STRING, (v1, v2) -> new BoolValue(v1.asString().equals(v2.asString())));
        equal.put(ValueType.FUNCTION, (v1, v2) -> new BoolValue(v1.asFunction().equals(v2.asFunction())));
        equal.put(ValueType.ARRAY, (v1, v2) -> new BoolValue(v1.asArray().equals(v2.asArray())));
        equal.put(ValueType.OBJECT, (v1, v2) -> new BoolValue(v1.asObject().equals(v2.asObject())));
        binaryImplementation.put(Binary.EQUAL, equal);

        Map<ValueType, BinaryOperation> notequal = new HashMap<>();
        notequal.put(ValueType.NULL, (_, v) -> new BoolValue(!v.getType().equals(ValueType.NULL)));
        notequal.put(ValueType.UNDEFINED, (_, _) -> new BoolValue(false));
        notequal.put(ValueType.BOOL, (v1, v2) -> new BoolValue(v1.asBool() != v2.asBool()));
        notequal.put(ValueType.NUM, (v1, v2) -> new BoolValue(v1.asNum() != v2.asNum()));
        notequal.put(ValueType.DOUBLE, (v1, v2) -> new BoolValue(v1.asDouble() != v2.asDouble()));
        notequal.put(ValueType.STRING, (v1, v2) -> new BoolValue(!v1.asString().equals(v2.asString())));
        notequal.put(ValueType.FUNCTION, (v1, v2) -> new BoolValue(!v1.asFunction().equals(v2.asFunction())));
        notequal.put(ValueType.ARRAY, (v1, v2) -> new BoolValue(!v1.asArray().equals(v2.asArray())));
        notequal.put(ValueType.OBJECT, (v1, v2) -> new BoolValue(!v1.asObject().equals(v2.asObject())));
        binaryImplementation.put(Binary.NOTEQUAL, notequal);

        Map<ValueType, BinaryOperation> less = new HashMap<>();
        less.put(ValueType.NUM, (v1, v2) -> new BoolValue(v1.asNum().compareTo(v2.asNum()) < 0));
        less.put(ValueType.DOUBLE, (v1, v2) -> new BoolValue(v1.asDouble().compareTo(v2.asDouble()) < 0));
        less.put(ValueType.STRING, (v1, v2) -> new BoolValue(v1.asString().compareTo(v2.asString()) < 0));
        binaryImplementation.put(Binary.LESS, less);

        Map<ValueType, BinaryOperation> lessEqual = new HashMap<>();
        lessEqual.put(ValueType.NUM, (v1, v2) -> new BoolValue(v1.asNum().compareTo(v2.asNum()) <= 0));
        lessEqual.put(ValueType.DOUBLE, (v1, v2) -> new BoolValue(v1.asDouble().compareTo(v2.asDouble()) <= 0));
        lessEqual.put(ValueType.STRING, (v1, v2) -> new BoolValue(v1.asString().compareTo(v2.asString()) <= 0));
        binaryImplementation.put(Binary.LESS_EQUAL, lessEqual);

        Map<ValueType, BinaryOperation> greater = new HashMap<>();
        greater.put(ValueType.NUM, (v1, v2) -> new BoolValue(v1.asNum().compareTo(v2.asNum()) > 0));
        greater.put(ValueType.DOUBLE, (v1, v2) -> new BoolValue(v1.asDouble().compareTo(v2.asDouble()) > 0));
        greater.put(ValueType.STRING, (v1, v2) -> new BoolValue(v1.asString().compareTo(v2.asString()) > 0));
        binaryImplementation.put(Binary.GREATER, greater);

        Map<ValueType, BinaryOperation> greaterEqual = new HashMap<>();
        greaterEqual.put(ValueType.NUM, (v1, v2) -> new BoolValue(v1.asNum().compareTo(v2.asNum()) >= 0));
        greaterEqual.put(ValueType.DOUBLE, (v1, v2) -> new BoolValue(v1.asDouble().compareTo(v2.asDouble()) >= 0));
        greaterEqual.put(ValueType.STRING, (v1, v2) -> new BoolValue(v1.asString().compareTo(v2.asString()) >= 0));
        binaryImplementation.put(Binary.LESS_EQUAL, greaterEqual);


        // UNARY OPERATIONS
        Map<ValueType, UnaryOperation> neg = new HashMap<>();
        neg.put(ValueType.NUM, v -> new NumValue(-v.asNum().getValue()));
        neg.put(ValueType.DOUBLE, v -> new DoubleValue(-v.asDouble().getValue()));
        unaryImplementation.put(Unary.NEG, neg);

        Map<ValueType, UnaryOperation> not = new HashMap<>();
        not.put(ValueType.BOOL, v -> new BoolValue(!v.asBool().getValue()));
        unaryImplementation.put(Unary.NOT, not);
    }
}
