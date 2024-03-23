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
        children.add(funIdent == null ? new TerminalAstNode("<Anonymous>") : funIdent);
        children.addAll(args);
        children.add(body);
    }
}

class ObjectLiteralNode extends AstNode {
    public ObjectLiteralNode(List<AstNode> fields) {
        super("obj_def");
        children.addAll(fields);
    }
}

class ArrayLiteralNode extends AstNode {
    public ArrayLiteralNode(List<AstNode> elements) {
        super("array_def");
        children.addAll(elements);
    }
}

class FieldNode extends AstNode {
    public FieldNode(AstNode fieldName, AstNode value) {
        super("field");
        children.add(fieldName);
        children.add(value);
    }
}

class ReturnNode extends AstNode {
    public ReturnNode(AstNode value) {
        super("return");
        children.add(value);
    }
}

class AssignNode extends AstNode{
    public AssignNode(AstNode variable, AstNode value) {
        super("assign");
        children.add(variable);
        children.add(value);
    }
}

class WhileNode extends AstNode{
    public WhileNode(AstNode expr, BlockNode body) {
        super("while");
        children.add(expr);
        children.add(body);
    }
}

class ElseNode extends AstNode{
    public ElseNode(AstNode body) {
        super("else");
        children.add(body);
    }
}

class ElifNode extends AstNode{
    public ElifNode(AstNode expr, BlockNode body) {
        super("elif");
        children.add(expr);
        children.add(body);
    }
}


class IfNode extends AstNode{
    public IfNode(AstNode expr, BlockNode body, List<AstNode> elif, AstNode elsee) {
        super("if");
        children.add(expr);
        children.add(body);
        children.addAll(elif);
        children.add(elsee);
    }
}




