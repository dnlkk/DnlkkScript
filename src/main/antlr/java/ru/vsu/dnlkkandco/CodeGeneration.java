package ru.vsu.dnlkkandco;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CodeGeneration {

    private final StringBuilder output = new StringBuilder();

    public StringBuilder generate(AstNode node) {
        return switch (node) {
            case TerminalAstNode terminalAstNode -> generate(terminalAstNode);
            case ProgramNode programNode -> generate(programNode);
            case BlockNode blockNode -> generate(blockNode);
            case BinOpNode binOpNode -> generate(binOpNode);
            case UnaryOpNode unaryOpNode -> generate(unaryOpNode);
            case ObjectCallNode objectCallNode -> generate(objectCallNode);
            case ArrayCallNode arrayCallNode -> generate(arrayCallNode);
            case FunctionCallNode functionCallNode -> generate(functionCallNode);
            case FunctionDefinitionNode functionDefinitionNode -> generate(functionDefinitionNode);
            case ObjectLiteralNode objectLiteralNode -> generate(objectLiteralNode);
            case ArrayLiteralNode arrayLiteralNode -> generate(arrayLiteralNode);
            case FieldNode fieldNode -> generate(fieldNode);
            case ReturnNode returnNode -> generate(returnNode);
            case AssignNode assignNode -> generate(assignNode);
            case WhileNode whileNode -> generate(whileNode);
            case ElseNode elseNode -> generate(elseNode);
            case ElifNode elifNode -> generate(elifNode);
            case IfNode ifNode -> generate(ifNode);
            case ForNode forNode -> generate(forNode);
            default -> output;
        };
    }

    private StringBuilder generate(TerminalAstNode node) {
        String name = node.getName();
        if (isNumeric(name)) {
            return output.append("PUSH N").append(name);
        } else if (isDouble(name)) {
            return output.append("PUSH D").append(name);
        } else if (isBoolean(name)) {
            return output.append("PUSH B").append(name);
        } else if (isString(name)) {
            return output.append("PUSH \"").append(name).append("\"");
        } else if (isChar(name)) {
            return output.append("PUSH '").append(name).append("'");
        } else {
            return output.append("PUSH \"").append(name).append("\"");
        }
    }

    private StringBuilder generate(BlockNode node) {
        for (AstNode child : node.children) {
            output.append(generate(child)).append("\n");
        }
        return output;
    }

    private StringBuilder generate(BinOpNode node) {
        output.append(generate(node.getChild(0)))
                .append("\n")
                .append(generate(node.getChild(1)))
                .append("\n");
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
        output.append(operator);
        return output;
    }

    private StringBuilder generate(UnaryOpNode node) {
        output.append(generate(node.getChild(0)).append("\n"));
        String operator = switch (node.getName()) {
            case "-" -> "NEG";
            case "!" -> "NOT";
            default -> throw new RuntimeException("Unknown unop");
        };
        output.append(operator);
        return output;
    }

    private StringBuilder generate(ObjectCallNode node) {
        var result = generate(node.getChild(0))
                .append("\n")
                .append("PUSH ")
                .append(node.getChild(1).getName())
                .append("\nGETFIELD");
        return output.append(result);
    }

    private StringBuilder generate(ArrayCallNode node) {
        var result = generate(node.getChild(0))
                .append("\n")
                .append(generate(node.getChild(1)))
                .append("\nALOAD");
        return output;
    }

    private StringBuilder generate(FunctionCallNode node) {
        StringBuilder sb = generate(node.getChild(0)).append("\n");
        output.append(sb);
        for (int i = 1; i < node.getChildrenAmount(); i++) {
            sb.append(generate(node.getChild(i))).append("\n");
        }
        return output.append("CALLFUNC");
    }

    private StringBuilder generate(FieldNode node) {
        return output
                .append(generate(node.getChild(1)))
                .append("\n")
                .append(generate(node.getChild(0)))
                .append("\nSETFIELD ")
                .append('"').append(node.getChild(1).getName()).append('"');
    }

    private StringBuilder generate(FunctionDefinitionNode node) {
        output.append("NEWFUNC ");
        output.append(node.getName())
                .append(" ")
                .append(node.getChildrenAmount() - 2)
                .append("\n");
        for (int i = 1; i < node.getChildrenAmount() - 1; i++) {
            output.append(node.getChild(i).getName()).append(" ");
        }
        return output.append("\n")
                .append(generate(node.getChild(node.getChildrenAmount() - 1)));
    }

    private StringBuilder generate(ObjectLiteralNode node) {
        output.append("NEWOBJECT\n");
        for (AstNode child : node.children) {
            output.append(generate(child)).append("\n");
        }
        return output;
    }

    private StringBuilder generate(ArrayLiteralNode node) {
        output.append("NEWARRAY\n");
        for (AstNode child : node.children) {
            output.append(generate(child)).append("\n");
        }
        return output;
    }

// private StringBuilder generate(FieldNode node) {
// return generate(node.getChild(0))
// .append("\n")
// .append(generate(node.getChild(1)))
// .append("\nSETFIELD");
// }

    private StringBuilder generate(ReturnNode node) {
        return generate(node.getChild(0)).append("\nRETURN");
    }

    private StringBuilder generate(AssignNode node) {
        return generate(node.getChild(1))
                .append("\nSET ");
    }

    private StringBuilder generate(WhileNode node) {
        output.append("start_while:\n");
        output.append(generate(node.getChild(0)))
                .append("\nJMF end_while\n")
                .append(generate(node.getChild(1)))
                .append("\nJMP start_while\nend_while:");
        return output;
    }

    private StringBuilder generate(ElseNode node) {
        return generate(node.getChild(0));
    }

    private StringBuilder generate(ElifNode node) {
        return output.append("elif\n")
                .append(generate(node.getChild(0)))
                .append("\nJMT elif_body\n")
                .append(generate(node.getChild(1)))
                .append("\nelif_body:");
    }

    private StringBuilder generate(IfNode node) {
        output.append("if\n");
        output.append(generate(node.getChild(0)))
                .append("\nJMF else_block\n")
                .append(generate(node.getChild(1)))
                .append("\nJMP end_if\nelse_block:");
        for (int i = 2; i < node.getChildrenAmount() - 1; i++) {
            output.append(generate(node.getChild(i))).append("\n");
        }
        output.append(generate(node.getChild(node.getChildrenAmount() - 1)))
                .append("\nend_if:");
        return output;
    }

    private StringBuilder generate(ProgramNode node) {
        StringBuilder sb = new StringBuilder();
        for (AstNode child : node.children) {
            sb.append(generate(child)).append("\n");
        }
        return sb;
    }

    private StringBuilder generate(ForNode node) {
        return output.append("for\n")
                .append(generate(node.getChild(1)))
                .append("\nstart_for:\n")
                .append(generate(node.getChild(0)))
                .append("\n")
                .append(generate(node.getChild(2)))
                .append("\n")
                .append(generate(node.getChild(3)))
                .append("\nJMP start_for\nend_for:");
    }

    private boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
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

    private boolean isString(String str) {
        return str.startsWith("\"") && str.endsWith("\"");
    }

    private boolean isChar(String str) {
        return str.startsWith("'") && str.endsWith("'");
    }

    public void writeToFile(String filename, AstNode node) {
        output.append("#main\n");
        output.append(generate(node));
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(output.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}