package ru.vsu.dnlkkandco;

import java.io.FileWriter;
import java.io.IOException;

public class CodeGeneration {

    private final StringBuilder output = new StringBuilder();
    private final StringBuilder function = new StringBuilder();
    private int counterForIf;
    private int counterForFor;
    private int counterForWhile;
    private int counterForElif;

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
            output.append("push N").append(name).append("\n");
        } else if (isDouble(name)) {
            output.append("push D").append(name).append("\n");
        } else if (isBoolean(name)) {
            output.append("push B").append(name).append("\n");
        } else if (isStringLiteral(name)) {
            output.append("push \"").append(name).append("\"\n");
        } else {
            output.append("push \"").append(name).append("\"\n").append("load\n");
        }
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
            output.append("push \"").append(node.getChild(0).getName()).append("\"\n").append("SET\n");
        } else {
            processNode(node.getChild(0));
            processNode(node.getChild(1));
            String operator = switch (node.getName()) {
                case "+" -> "add";
                case "-" -> "sub";
                case "*" -> "mul";
                case "/" -> "div";
                case "%" -> "mod";
                case "==" -> "eq";
                case "!=" -> "neq";
                case ">" -> "gt";
                case ">=" -> "gte";
                case "<" -> "lt";
                case "<=" -> "lte";
                default -> throw new RuntimeException("Unknown binop");
            };
            output.append(operator).append("\n");
        }
    }


    private void processUnaryOp(UnaryOpNode node) {
        processNode(node.getChild(0));
        String operator = switch (node.getName()) {
            case "-" -> "neg";
            case "!" -> "not";
            default -> throw new RuntimeException("Unknown unop");
        };
        output.append(operator).append("\n");
    }

    private void processObjectCall(ObjectCallNode node) {
        processNode(node.getChild(1));
        output.append("push \"").append(node.getChild(0).getName()).append("\"\n").append("load\n")
                .append("getfield\n");
    }

    private void processArrayCall(ArrayCallNode node) {
        processNode(node.getChild(0));
        processNode(node.getChild(1));
        output.append("aload\n");
    }

    private void processFunctionCall(FunctionCallNode node) {
        int index = output.indexOf("#main\n");
        String insert = "push \"#" + node.getChild(0).getName() + "\"\n" + "newfunc\n" + "push \""
                + node.getChild(0).getName() + "\"\n" + "set\n";
        output.insert(index + "#main\n".length(), insert);
        output.append("newarray\n");
        for (int i = 1; i < node.getChildrenAmount(); i++) {
            output.append("dup\n");
            output.append("push N").append(i - 1).append("\n");
            processNode(node.getChild(i));
            output.append("aset\n");
        }
        processNode(node.getChild(0));
        output.append("callfunc\n");
    }

    private void processFunctionDefinition(FunctionDefinitionNode node) {
        String functionName = node.getChild(0).getName();
        output.append("\n");
        output.append("#").append(functionName).append("\n");
        for (int i = 1; i < node.getChildrenAmount() - 1; i++) {
            output.append("push \"__args__\"\nload\n");
            output.append("push N").append(i - 1).append("\naload\n");
            output.append("push \"").append(node.getChild(i).getName()).append("\"\nset\n");
        }
        processNode(node.getChild(node.getChildrenAmount() - 1));
    }

    private void processObjectLiteral(ObjectLiteralNode node) {
        output.append("newobject\n");
        for (AstNode child : node.children) {
            processNode(child);
        }
    }

    private void processArrayLiteral(ArrayLiteralNode node) {
        output.append("newarray\n");
        for (int i = 0; i < node.getChildrenAmount(); i++) {
            output.append("dup\n");
            processNode(node.getChild(i));
            output.append("push" + " N" + i + "\n");
            output.append("aset\n");
        }
    }

    private void processField(FieldNode node) {
        processNode(node.getChild(1));
        processNode(node.getChild(0));
        output.append("load\n").append("setfield").append(node.getChild(0).getName()).append("\n");
    }

    private void processReturn(ReturnNode node) {
        processNode(node.getChild(0));
        output.append("return\n");
    }

    private void processAssign(AssignNode node) {
        if (node.getChild(0) instanceof ObjectCallNode) {
            processNode(node.getChild(1));
            output.append("push \"").append(node.getChild(0).getChild(1).getName()).append("\"\n");
            output.append("push \"").append(node.getChild(0).getChild(0).getName()).append("\"\n").append("load\n")
                    .append("setfield\n");
        } else if (node.getChild(0) instanceof ArrayCallNode) {
            output.append("push \"").append(node.getChild(0).getChild(0).getName()).append("\"\n").append("load\n")
                    .append("push \"").append(node.getChild(0).getChild(1).getName()).append("\"\n");
            processNode(node.getChild(1));
            output.append("aset\n");
        }
        processNode(node.getChild(1));
        output.append("push \"").append(node.getChild(0).getName()).append("\"\n").append("set\n");
    }

    private void processWhile(WhileNode node) {
        processNode(node.getChild(0));
        output.append("jmf end_while").append(counterForWhile).append("\n");
        processNode(node.getChild(1));
        counterForWhile++;
    }

    private void processElse(ElseNode node) {
        processNode(node.getChild(0));
    }

    private void processElif(ElifNode node) {
        int elif = counterForElif;
        counterForElif++;
        processNode(node.getChild(0));
        output.append("jmf elif_end").append(elif).append("\n");
        processNode(node.getChild(1));
        output.append("#elif_end").append(elif).append("\n");
    }

    private void processIf(IfNode node) {
        int endIf = counterForIf;
        counterForIf++;
        processNode(node.getChild(0));
        output.append("jmf end_if").append(endIf).append("\n");
        processNode(node.getChild(1));
        output.append("#end_if").append(endIf).append("\n");
        for (int i = 2; i < node.getChildrenAmount() - 1; i++) {
            processNode(node.getChild(i));
        }
        processNode(node.getChild(node.getChildrenAmount() - 1));
    }

    private void processFor(ForNode node) {
        processNode(node.getChild(0));
        output.append("#for").append(counterForFor).append("\n");
        processNode(node.getChild(1));
        output.append("jmf end_for").append(counterForFor).append("\n");
        processNode(node.getChild(3));
        processNode(node.getChild(2));
        output.append("jmp for").append(counterForFor).append("\n");
        output.append("#end_for").append(counterForFor).append("\n");
        counterForFor++;
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

    private boolean isStringLiteral(String name) {
        return name.startsWith("\"") && name.endsWith("\"");
    }

    public void writeToFile(String filename, AstNode node) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(generate(node));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}