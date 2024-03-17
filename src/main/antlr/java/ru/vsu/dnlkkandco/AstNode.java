package ru.vsu.dnlkkandco;

import java.util.ArrayList;
import java.util.List;

public abstract class AstNode {
    private final String name;
    protected final List<AstNode> children;

    public AstNode(String name) {
        this.name = name;
        children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public AstNode getChild(int i) {
        return children.get(i);
    }

    public boolean isEmpty() {
        return children.isEmpty();
    }

    public boolean add(AstNode e) {
        return children.add(e);
    }
}

class TerminalNode extends AstNode {
    public TerminalNode(String name) {
        super(name);
    }
}

class ProgramNode extends AstNode {
    public ProgramNode() {
        super("program");
    }

    public ProgramNode(List<AstNode> stmts) {
        super("program");
        children.addAll(stmts);
    }
}

class BinOpNode extends AstNode {
    public BinOpNode(String op, AstNode left, AstNode right) {
        super(op);
        children.add(left);
        children.add(right);
    }
}
