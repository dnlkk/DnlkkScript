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

    public int getChildrenAmount() {
        return children.size();
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

class TerminalAstNode extends AstNode {
    public TerminalAstNode(String name) {
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

class BlockNode extends AstNode {
    public BlockNode(List<AstNode> stmts) {
        super("...");
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

class UnaryOpNode extends AstNode {
    public UnaryOpNode(String op, AstNode child) {
        super(op);
        children.add(child);
    }
}

class ObjectCallNode extends AstNode {
    public ObjectCallNode(AstNode obj, AstNode field) {
        super(".");
        children.add(obj);
        children.add(field);
    }
}

class ArrayCallNode extends AstNode {
    public ArrayCallNode(AstNode obj, AstNode field) {
        super("[]");
        children.add(obj);
        children.add(field);
    }
}

class FunctionCallNode extends AstNode {
    public FunctionCallNode(AstNode func, List<AstNode> args) {
        super("fun_call");
        children.add(func);
        children.addAll(args);
    }
}

class FunctionDefinitionNode extends AstNode {
    public FunctionDefinitionNode(TerminalAstNode funIdent, List<AstNode> args, BlockNode body) {
        super("def " + (funIdent == null ? "<Anonymous>" : funIdent.getName()));
        children.add(funIdent);
        children.addAll(args);
        children.add(body);
    }
}

class ReturnNode extends AstNode {
    public ReturnNode(AstNode value) {
        super("return");
        children.add(value);
    }
}
