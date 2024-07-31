package ru.vsu.dnlkkandco.interpreter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.vsu.dnlkkandco.interpreter.value.*;

import java.util.*;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;
import static org.junit.jupiter.api.Assertions.*;

class InterpreterTest {

    private Map<String, Integer> labels;

    @BeforeEach
    public void init() {
        labels = Map.ofEntries(Map.entry("main", 0));
    }

    @Test
    public void addTest() {
        helper(CommandType.ADD, List.of(new NumValue(1), new NumValue(2)), List.of(new NumValue(3)));
    }

    @Test
    public void aloadTest() {
        helper(CommandType.ALOAD, List.of(new ArrayValue(List.of(new NumValue(1))), new NumValue(0)), List.of(new NumValue(1)));
    }

    @Test
    public void asetTest() {
        var commands = List.of(
                new InterpreterCommand(CommandType.ASET, null, 0)
        );
        var interpreter = new Interpreter(labels, commands);
        var stack = interpreter.getStack();
        var array = new ArrayValue(new ArrayList<>());
        stack.push(array);
        stack.push(new NumValue(0));
        stack.push(new StringValue("Hello"));
        interpreter.exec();

        assertTrue(stack.isEmpty());

        var expectedArray = new ArrayValue(List.of(new StringValue("Hello")));
        assertEquals(expectedArray, array);
    }

    @Test
    public void divTest() {
        helper(CommandType.DIV, List.of(new NumValue(2), new DoubleValue(1)), List.of(new DoubleValue(0.5)));
    }

    @Test
    public void dupTest() {
        helper(CommandType.DUP, List.of(new NumValue(2)), List.of(new NumValue(2), new NumValue(2)));
    }

    @Test
    public void eqTest() {
        helper(CommandType.EQ, List.of(new NumValue(2), new NumValue(1)), List.of(new BoolValue(false)));
    }

    @Test
    public void gtTest() {
        helper(CommandType.GT, List.of(new NumValue(2), new NumValue(1)), List.of(new BoolValue(false)));
    }

    @Test
    public void gteTest() {
        helper(CommandType.GTE, List.of(new NumValue(2), new NumValue(2)), List.of(new BoolValue(true)));
    }

    @Test
    public void loadTest() {
        helper(CommandType.LOAD, Map.of("foo", new NumValue(3)), List.of(new StringValue("foo")), List.of(new NumValue(3)));
    }

    @Test
    public void ltTest() {
        helper(CommandType.LT, List.of(new NumValue(2), new NumValue(1)), List.of(new BoolValue(true)));
    }

    @Test
    public void lteTest() {
        helper(CommandType.LTE, List.of(new NumValue(2), new NumValue(2)), List.of(new BoolValue(true)));
    }

    @Test
    public void modTest() {
        helper(CommandType.MOD, List.of(new NumValue(3), new NumValue(10)), List.of(new NumValue(1)));
    }

    @Test
    public void mulTest() {
        helper(CommandType.MUL, List.of(new NumValue(3), new NumValue(10)), List.of(new NumValue(30)));
    }

    @Test
    public void negTest() {
        helper(CommandType.NEG, List.of(new NumValue(3)), List.of(new NumValue(-3)));
    }

    @Test
    public void neqTest() {
        helper(CommandType.NEQ, List.of(new NumValue(3), new NumValue(-3)), List.of(new BoolValue(true)));
    }

    @Test
    public void newarrayTest() {
        helper(CommandType.NEWARRAY, emptyList(), List.of(new ArrayValue(emptyList())));
    }

    @Test
    public void newfuncTest() {
        helper(CommandType.NEWFUNC, List.of(new StringValue("foo")), List.of(new FunctionValue("foo")));
    }

    @Test
    public void newobjectTest() {
        helper(CommandType.NEWOBJECT, emptyList(), List.of(new ObjectValue(emptyMap())));
    }

    @Test
    public void notTest() {
        helper(CommandType.NOT, List.of(new BoolValue(true)), List.of(new BoolValue(false)));
    }

    @Test
    public void popTest() {
        helper(CommandType.POP, List.of(new BoolValue(true)), emptyList());
    }

    @Test
    public void pushTest() {
        helper(new StringValue("Hello"), CommandType.PUSH, emptyList(), List.of(new StringValue("Hello")));
    }

    @Test
    public void setTest() {
        var commands = List.of(
                new InterpreterCommand(CommandType.SET, null, 0)
        );
        var interpreter = new Interpreter(labels, commands);
        var stack = interpreter.getStack();
        stack.push(new NumValue(1));
        stack.push(new StringValue("Hello"));

        interpreter.exec();

        assertTrue(stack.isEmpty());
        assertTrue(interpreter.getContext().containsVariable("Hello"));
        assertEquals(new NumValue(1), interpreter.getContext().get("Hello"));
    }

    @Test
    public void subTest() {
        helper(CommandType.SUB, List.of(new NumValue(2), new NumValue(1)), List.of(new NumValue(-1)));
    }

    private void helper(CommandType commandType, List<Value<?>> init, List<Value<?>> expected) {
        helper(commandType, null, init, expected);
    }

    private void helper(Value<?> argument, CommandType commandType, List<Value<?>> init, List<Value<?>> expected) {
        var commands = List.of(
                new InterpreterCommand(commandType, argument, 0)
        );
        var interpreter = new Interpreter(labels, commands);
        var stack = interpreter.getStack();
        init.forEach(stack::push);
        interpreter.exec();

        var expectedStack = new ArrayDeque<Value<?>>();
        expected.forEach(expectedStack::push);

        assertIterableEquals(expectedStack, interpreter.getStack());
    }

    private void helper(CommandType commandType, Map<String, Value<?>> initContext, List<Value<?>> init, List<Value<?>> expected) {
        var commands = List.of(
                new InterpreterCommand(commandType, null, 0)
        );
        var interpreter = new Interpreter(labels, commands);
        var stack = interpreter.getStack();
        init.forEach(stack::push);

        if (initContext != null) {
            var context = interpreter.getContext();
            initContext.forEach(context::setVariable);
        }
        interpreter.exec();

        var expectedStack = new ArrayDeque<Value<?>>();
        expected.forEach(expectedStack::push);

        assertIterableEquals(expectedStack, interpreter.getStack());
    }
}