package ru.vsu.dnlkkandco;

import java.io.FileWriter;
import java.io.IOException;

public class CodeGeneration {

    private final StringBuilder output = new StringBuilder();
    private int a;
    private int b;
    private int c;
    private int d;

    public String generate(AstNode node) {
        output.setLength(0);
        output.append("#main\n");
        processNode(node);
        return output.toString();
    }

    private void processNode(AstNode node) {
        if (node != null) {
            switch (node) {
                case TerminalAstNode terminalAstNode -> processTerminal(terminalAstNode);
                case ProgramNode programNode -> processProgram(programNode);
                case BlockNode blockNode -> processBlock(blockNode);
                case BinOpNode binOpNode -> processBinOp(binOpNode);
                case UnaryOpNode unaryOpNode -> processUnaryOp(unaryOpNode);
                case ObjectCallNode objectCallNode -> processObjectCall(objectCallNode);
                case ArrayCallNode arrayCallNode -> processArrayCall(arrayCallNode);
                case FunctionCallNode functionCallNode -> processFunctionCall(functionCallNode);
                case FunctionDefinitionNode functionDefinitionNode -> processFunctionDefinition(functionDefinitionNode);
                case ObjectLiteralNode objectLiteralNode -> processObjectLiteral(objectLiteralNode);
                case ArrayLiteralNode arrayLiteralNode -> processArrayLiteral(arrayLiteralNode);
                case FieldNode fieldNode -> processField(fieldNode);
                case ReturnNode returnNode -> processReturn(returnNode);
                case AssignNode assignNode -> processAssign(assignNode);
                case WhileNode whileNode -> processWhile(whileNode);
                case ElseNode elseNode -> processElse(elseNode);
                case ElifNode elifNode -> processElif(elifNode);
                case IfNode ifNode -> processIf(ifNode);
                case ForNode forNode -> processFor(forNode);
                default -> throw new IllegalArgumentException("Unsupported AST node type");
            }
        }

    }

    private void processTerminal(TerminalAstNode node) {
        String name = node.getName();
        if (isNumeric(name)) {
            output.append("PUSH N").append(name).append("\n");
        } else if (isDouble(name)) {
            output.append("PUSH D").append(name).append("\n");
        } else if (isBoolean(name)) {
            output.append("PUSH B").append(name).append("\n");
        } else if (isStringLiteral(name)) {
            output.append("PUSH \"").append(name).append("\"\n");
        } else {
            output.append("PUSH \"").append(name).append("\"\n").append("LOAD\n");
        }
    }

    private boolean isStringLiteral(String name) {
        return name.startsWith("\"") && name.endsWith("\"");
    }

    private void processProgram(ProgramNode node) {
        for (AstNode child : node.children) {
            processNode(child);
        }
    }

    private void processBlock(BlockNode node) {
        for (AstNode child : node.children) {
            processNode(child);
        }
    }

    private void processBinOp(BinOpNode node) {

        if (node.getName().equals("var")){
            processNode(node.getChild(1));
            output.append("PUSH \"").append(node.getChild(0).getName()).append("\"\n").append("SET\n");
        } else {
            processNode(node.getChild(0));
            processNode(node.getChild(1));
            String operator = switch (node.getName()) {
                case "+" -> "ADD";
                case "-" -> "SUB";
                case "*" -> "MUL";
                case "/" -> "DIV";
                case "%" -> "MOD";
                case "==" -> "EQ";
                case "!=" -> "NEQ";
                case ">" -> "GT";
                case ">=" -> "GTE";
                case "<" -> "LT";
                case "<=" -> "LTE";
                default -> throw new RuntimeException("Unknown binop");
            };
            output.append(operator).append("\n");
        }
    }


    private void processUnaryOp(UnaryOpNode node) {
        processNode(node.getChild(0));
        String operator = switch (node.getName()) {
            case "-" -> "NEG";
            case "!" -> "NOT";
            default -> throw new RuntimeException("Unknown unop");
        };
        output.append(operator).append("\n");
    }

    private void processObjectCall(ObjectCallNode node) {
        processNode(node.getChild(1));
        output.append("PUSH \"").append(node.getChild(0).getName()).append("\"\n").append("LOAD\n")
                .append("GETFIELD\n");
    }

    private void processArrayCall(ArrayCallNode node) {
        processNode(node.getChild(0));
        processNode(node.getChild(1));
        output.append("ALOAD\n");
    }

    private void processFunctionCall(FunctionCallNode node) {
        processNode(node.getChild(0));
        for (int i = 1; i < node.getChildrenAmount(); i++) {
            processNode(node.getChild(i));
        }
        output.append("CALLFUNC\n");
    }

    private void processFunctionDefinition(FunctionDefinitionNode node) {
        output.append("NEWFUNC ").append(node.getName()).append(" ")
                .append(node.getChildrenAmount() - 2).append("\n");
        for (int i = 1; i < node.getChildrenAmount() - 1; i++) {
            output.append(node.getChild(i).getName()).append(" ");
        }
        output.append("\n");
        processNode(node.getChild(node.getChildrenAmount() - 1));
    }

    private void processObjectLiteral(ObjectLiteralNode node) {
        output.append("NEWOBJECT\n");
        for (AstNode child : node.children) {
            processNode(child);
        }
    }

    private void processArrayLiteral(ArrayLiteralNode node) {
        output.append("NEWARRAY\n");
        for (int i = 0; i < node.getChildrenAmount(); i++) {
            output.append("DUP\n");
            processNode(node.getChild(i));
            output.append("PUSH" + " N" + i + "\n");
            output.append("ASET\n");
        }
    }

    private void processField(FieldNode node) {
        processNode(node.getChild(1));
        processNode(node.getChild(0));
        output.append("LOAD\n").append("SETFIELD").append(node.getChild(0).getName()).append("\n");
    }

    private void processReturn(ReturnNode node) {
        processNode(node.getChild(0));
        output.append("RETURN\n");
    }

    private void processAssign(AssignNode node) {
        if (node.getChild(0) instanceof ObjectCallNode) {
            processNode(node.getChild(1));
            output.append("PUSH \"").append(node.getChild(0).getChild(1).getName()).append("\"\n");
            output.append("PUSH \"").append(node.getChild(0).getChild(0).getName()).append("\"\n").append("LOAD\n")
                    .append("SETFIELD\n");
        } else if (node.getChild(0) instanceof ArrayCallNode) {
            output.append("PUSH \"").append(node.getChild(0).getChild(0).getName()).append("\"\n").append("LOAD\n")
                    .append("PUSH \"").append(node.getChild(0).getChild(1).getName()).append("\"\n");
            processNode(node.getChild(1));
            output.append("ASET\n");
        }
        processNode(node.getChild(0));
        output.append("SET\n").append("PUSH \"").append(node.getChild(0).getName()).append("\"\n");
    }

    private void processWhile(WhileNode node) {
        output.append("#start_while").append(c).append("\n");
        processNode(node.getChild(0));
        output.append("JMF #end_while").append(c).append("\n");
        ;
        processNode(node.getChild(1));
        output.append("JMP #start_while").append(c).append("\n").append("#end_while").append(c).append("\n");
        c++;
    }

    private void processElse(ElseNode node) {
        processNode(node.getChild(0));
    }

    private void processElif(ElifNode node) {
        output.append("#elif").append(d).append("\n");
        processNode(node.getChild(0));
        output.append("JMT #elif_body").append(d).append("\n");
        processNode(node.getChild(1));
        output.append("#elif_body").append(d).append("\n");
        d++;
    }

    private void processIf(IfNode node) {
        output.append("#if").append(a).append("\n");
        processNode(node.getChild(0));
        output.append("JMF #else_block").append(a).append("\n");
        processNode(node.getChild(1));
        output.append("JMP #end_if").append(a).append("\n").append("else_block").append(a).append("\n");
        for (int i = 2; i < node.getChildrenAmount() - 1; i++) {
            processNode(node.getChild(i));
        }
        processNode(node.getChild(node.getChildrenAmount() - 1));
        output.append("#end_if").append(a).append("\n");
        a++;
    }

    private void processFor(ForNode node) {
        processNode(node.getChild(0));
        output.append("#for").append(b).append("\n");
        processNode(node.getChild(1));
        output.append("JMF end_for").append(b).append("\n");
        processNode(node.getChild(3));
        processNode(node.getChild(2));
        output.append("JMP for").append(b).append("\n");
        output.append("#end_for").append(b).append("\n");
        b++;
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isBoolean(String str) {
        return str.equalsIgnoreCase("true") || str.equalsIgnoreCase("false");
    }

    public void writeToFile(String filename, AstNode node) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(generate(node));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//#main
//        NEWARRAY
//dup
//PUSH N1
//PUSH N0
//ASET
//        DUP
//PUSH N2
//PUSH N1
//ASET
//        DUP
//PUSH N3
//PUSH N2
//ASET
//PUSH "a"
//SET
//for
//PUSH "a"
//LOAD
//PUSH N0
//ALOAD
//PUSH N2
//LT
//JMF end_for
//#start_for
//PUSH N3
//PUSH N5
//PUSH N2
//ADD
//        MUL
//PUSH N3
//PUSH N1
//ADD
//        ADD
//PUSH "c"
//SET
//        NEWARRAY
//dup
//PUSH N0
//PUSH "a"
//LOAD
//        ASET
//dup
//PUSH N1
//PUSH "b"
//LOAD
//        ASET
//PUSH "c"
//LOAD
//PUSH N2
//ALOAD
//PUSH "foo"
//GETFIELD
//        CALLFUNC
//PUSH N0
//ALOAD
//        RETURN
//PUSH "a"
//LOAD
//PUSH "a"
//LOAD
//PUSH N0
//ALOAD
//PUSH N2
//ADD
//PUSH N0
//ASET
//JMP #start_for
//#end_for
//        HALT