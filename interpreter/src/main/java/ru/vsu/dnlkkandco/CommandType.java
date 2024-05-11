package ru.vsu.dnlkkandco;

public enum CommandType {
    POP, PUSH, SET, LOAD,
    ADD, SUB, MUL, DIV, MOD, EQ, NEQ, GT, GTE, LT, LTE,
    NEG, NOT,
    JMF, JMT, JMP,
    NEWARRAY, ASET, ALOAD,
    NEWOBJECT, SETFIELD, GETFIELD,
    NEWFUNC, CALLFUNC, RETURN,
    HALT
}
