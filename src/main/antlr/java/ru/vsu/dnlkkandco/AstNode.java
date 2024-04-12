package ru.vsu.dnlkkandco;

import java.util.ArrayList;
import java.util.List;

public abstract class AstNode {
    private TerminalAstNode terminalAstNode;

    private ProgramNode programNode;

    private BlockNode blockNode;

    private BinOpNode binOpNode;

    private UnaryOpNode unaryOpNode;

    private ObjectCallNode objectCallNode;

    private ArrayCallNode arrayCallNode;

    private FunctionCallNode functionCallNode;


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

    private List<AstNode> stmts;

    public List<AstNode> getStmts() {
        return stmts;
    }

    public void setStmts(List<AstNode> stmts) {
        this.stmts = stmts;
    }

    public ProgramNode() {
        super("program");
    }

    public ProgramNode(List<AstNode> stmts) {
        super("program");
        children.addAll(stmts);
    }
}

class BlockNode extends AstNode {

    private List<AstNode> stmts;

    public List<AstNode> getStmts() {
        return stmts;
    }

    public void setStmts(List<AstNode> stmts) {
        this.stmts = stmts;
    }

    public BlockNode(List<AstNode> stmts) {
        super("...");
        children.addAll(stmts);
    }
}

class BinOpNode extends AstNode {

    private AstNode left;

    private AstNode right;

    public AstNode getLeft() {
        return left;
    }

    public void setLeft(AstNode left) {
        this.left = left;
    }

    public AstNode getRight() {
        return right;
    }

    public void setRight(AstNode right) {
        this.right = right;
    }

    public BinOpNode(String op, AstNode left, AstNode right) {
        super(op);
        children.add(left);
        children.add(right);
    }
}

class UnaryOpNode extends AstNode {

    private AstNode child;

    public AstNode getChild() {
        return child;
    }

    public void setChild(AstNode child) {
        this.child = child;
    }

    public UnaryOpNode(String op, AstNode child) {
        super(op);
        children.add(child);
    }
}

class ObjectCallNode extends AstNode {

    private AstNode obj;

    private AstNode field;

    public AstNode getObj() {
        return obj;
    }

    public void setObj(AstNode obj) {
        this.obj = obj;
    }

    public AstNode getField() {
        return field;
    }

    public void setField(AstNode field) {
        this.field = field;
    }

    public ObjectCallNode(AstNode obj, AstNode field) {
        super(".");
        children.add(obj);
        children.add(field);
    }
}

class ArrayCallNode extends AstNode {

    private AstNode obj;

    private AstNode field;

    public AstNode getObj() {
        return obj;
    }

    public void setObj(AstNode obj) {
        this.obj = obj;
    }

    public AstNode getField() {
        return field;
    }

    public void setField(AstNode field) {
        this.field = field;
    }

    public ArrayCallNode(AstNode obj, AstNode field) {
        super("[]");
        children.add(obj);
        children.add(field);
    }
}

class FunctionCallNode extends AstNode {

    private AstNode func;

    public AstNode getFunc() {
        return func;
    }

    public void setFunc(AstNode func) {
        this.func = func;
    }

    public List<AstNode> getArgs() {
        return args;
    }

    public void setArgs(List<AstNode> args) {
        this.args = args;
    }

    private List<AstNode> args;

    public FunctionCallNode(AstNode func, List<AstNode> args) {
        super("fun_call");
        children.add(func);
        children.addAll(args);
    }
}

class FunctionDefinitionNode extends AstNode {

    private TerminalAstNode funIdent;

    private List<AstNode> args;

    private BlockNode body;

    public TerminalAstNode getFunIdent() {
        return funIdent;
    }

    public void setFunIdent(TerminalAstNode funIdent) {
        this.funIdent = funIdent;
    }

    public List<AstNode> getArgs() {
        return args;
    }

    public void setArgs(List<AstNode> args) {
        this.args = args;
    }

    public BlockNode getBody() {
        return body;
    }

    public void setBody(BlockNode body) {
        this.body = body;
    }

    public FunctionDefinitionNode(TerminalAstNode funIdent, List<AstNode> args, BlockNode body) {
        super("def " + (funIdent == null ? "<Anonymous>" : funIdent.getName()));
        children.add(funIdent);
        children.addAll(args);
        children.add(body);
    }
}

class ObjectLiteralNode extends AstNode {

    private List<AstNode> fields;

    public List<AstNode> getFields() {
        return fields;
    }

    public void setFields(List<AstNode> fields) {
        this.fields = fields;
    }

    public ObjectLiteralNode(List<AstNode> fields) {
        super("obj_def");
        children.addAll(fields);
    }
}

class ArrayLiteralNode extends AstNode {

    private List<AstNode> elements;

    public List<AstNode> getElements() {
        return elements;
    }

    public void setElements(List<AstNode> elements) {
        this.elements = elements;
    }

    public ArrayLiteralNode(List<AstNode> elements) {
        super("array_def");
        children.addAll(elements);
    }
}

class FieldNode extends AstNode {

    private AstNode fieldName;

    private AstNode value;

    public AstNode getFieldName() {
        return fieldName;
    }

    public void setFieldName(AstNode fieldName) {
        this.fieldName = fieldName;
    }

    public AstNode getValue() {
        return value;
    }

    public void setValue(AstNode value) {
        this.value = value;
    }

    public FieldNode(AstNode fieldName, AstNode value) {
        super("field");
        children.add(fieldName);
        children.add(value);
    }
}

class ReturnNode extends AstNode {

    private AstNode value;

    public AstNode getValue() {
        return value;
    }

    public void setValue(AstNode value) {
        this.value = value;
    }

    public ReturnNode(AstNode value) {
        super("return");
        children.add(value);
    }
}

class AssignNode extends AstNode {

    private AstNode variable;

    private AstNode value;

    public AstNode getVariable() {
        return variable;
    }

    public void setVariable(AstNode variable) {
        this.variable = variable;
    }

    public AstNode getValue() {
        return value;
    }

    public void setValue(AstNode value) {
        this.value = value;
    }

    public AssignNode(AstNode variable, AstNode value) {
        super("assign");
        children.add(variable);
        children.add(value);
    }
}

class WhileNode extends AstNode {

    private AstNode expr;

    private BlockNode body;

    public AstNode getExpr() {
        return expr;
    }

    public void setExpr(AstNode expr) {
        this.expr = expr;
    }

    public BlockNode getBody() {
        return body;
    }

    public void setBody(BlockNode body) {
        this.body = body;
    }

    public WhileNode(AstNode expr, BlockNode body) {
        super("while");
        children.add(expr);
        children.add(body);
    }
}

class ElseNode extends AstNode {

    private AstNode body;

    public AstNode getBody() {
        return body;
    }

    public void setBody(AstNode body) {
        this.body = body;
    }

    public ElseNode(AstNode body) {
        super("else");
        children.add(body);
    }
}

class ElifNode extends AstNode {

    private AstNode expr;

    private BlockNode body;

    public AstNode getExpr() {
        return expr;
    }

    public void setExpr(AstNode expr) {
        this.expr = expr;
    }

    public BlockNode getBody() {
        return body;
    }

    public void setBody(BlockNode body) {
        this.body = body;
    }

    public ElifNode(AstNode expr, BlockNode body) {
        super("elif");
        children.add(expr);
        children.add(body);
    }
}


class IfNode extends AstNode {

    private AstNode expr;

    private BlockNode body;

    private List<AstNode> elif;

    private AstNode elsee;

    public AstNode getExpr() {
        return expr;
    }

    public void setExpr(AstNode expr) {
        this.expr = expr;
    }

    public BlockNode getBody() {
        return body;
    }

    public void setBody(BlockNode body) {
        this.body = body;
    }

    public List<AstNode> getElif() {
        return elif;
    }

    public void setElif(List<AstNode> elif) {
        this.elif = elif;
    }

    public AstNode getElsee() {
        return elsee;
    }

    public void setElsee(AstNode elsee) {
        this.elsee = elsee;
    }

    public IfNode(AstNode expr, BlockNode body, List<AstNode> elif, AstNode elsee) {
        super("if");
        children.add(expr);
        children.add(body);
        children.addAll(elif);
        children.add(elsee);
    }
}

class ForNode extends AstNode {

    private AstNode definition;

    private AstNode logical;

    private AstNode assign;

    private AstNode body;

    public AstNode getDefinition() {
        return definition;
    }

    public void setDefinition(AstNode definition) {
        this.definition = definition;
    }

    public AstNode getLogical() {
        return logical;
    }

    public void setLogical(AstNode logical) {
        this.logical = logical;
    }

    public AstNode getAssign() {
        return assign;
    }

    public void setAssign(AstNode assign) {
        this.assign = assign;
    }

    public AstNode getBody() {
        return body;
    }

    public void setBody(AstNode body) {
        this.body = body;
    }

    public ForNode(AstNode definition, AstNode logical, AstNode assign, AstNode body) {
        super("for");
        children.add(definition);
        children.add(logical);
        children.add(assign);
        children.add(body);
    }
}
