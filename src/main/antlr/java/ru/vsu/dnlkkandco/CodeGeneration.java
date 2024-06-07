package ru.vsu.dnlkkandco;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CodeGeneration {

    public StringBuilder generate(AstNode node) {
        if (node instanceof TerminalAstNode) {
            return generate((TerminalAstNode) node);
        } else if (node instanceof ProgramNode) {
            return generate((ProgramNode) node);
        } else if (node instanceof BlockNode) {
            return generate((BlockNode) node);
        } else if (node instanceof BinOpNode) {
            return generate((BinOpNode) node);
        } else if (node instanceof UnaryOpNode) {
            return generate((UnaryOpNode) node);
        } else if (node instanceof ObjectCallNode) {
            return generate((ObjectCallNode) node);
        } else if (node instanceof ArrayCallNode) {
            return generate((ArrayCallNode) node);
        } else if (node instanceof FunctionCallNode) {
            return generate((FunctionCallNode) node);
        } else if (node instanceof FunctionDefinitionNode) {
            return generate((FunctionDefinitionNode) node);
        } else if (node instanceof ObjectLiteralNode) {
            return generate((ObjectLiteralNode) node);
        } else if (node instanceof ArrayLiteralNode) {
            return generate((ArrayLiteralNode) node);
        } else if (node instanceof FieldNode) {
            return generate((FieldNode) node);
        } else if (node instanceof ReturnNode) {
            return generate((ReturnNode) node);
        } else if (node instanceof AssignNode) {
            return generate((AssignNode) node);
        } else if (node instanceof WhileNode) {
            return generate((WhileNode) node);
        } else if (node instanceof ElseNode) {
            return generate((ElseNode) node);
        } else if (node instanceof ElifNode) {
            return generate((ElifNode) node);
        } else if (node instanceof IfNode) {
            return generate((IfNode) node);
        } else if (node instanceof ForNode) {
            return generate((ForNode) node);
        }
        return new StringBuilder();
    }

    private StringBuilder generate(TerminalAstNode node) {
        String name = node.getName();
        if (isNumeric(name)) {
            return new StringBuilder("PUSH N").append(name);
        } else if (isDouble(name)) {
            return new StringBuilder("PUSH D").append(name);
        } else if (isBoolean(name)) {
            return new StringBuilder("PUSH B").append(name);
        } else if (isString(name)) {
            return new StringBuilder("PUSH \"").append(name).append("\"");
        } else if (isChar(name)) {
            return new StringBuilder("PUSH '").append(name).append("'");
        } else {
            return new StringBuilder("PUSH \"").append(name).append("\"");
        }
    }

    private StringBuilder generate(BlockNode node) {
        StringBuilder sb = new StringBuilder();
        for (AstNode child : node.children) {
            sb.append(generate(child)).append("\n");
        }
        return sb;
    }

    private StringBuilder generate(BinOpNode node) {
        StringBuilder sb = generate(node.getChild(0))
                .append("\n")
                .append(generate(node.getChild(1)))
                .append("\n");
        switch (node.getName()) {
            case "+":
                sb.append("ADD");
                break;
            case "-":
                sb.append("SUB");
                break;
            case "*":
                sb.append("MUL");
                break;
            case "/":
                sb.append("DIV");
                break;
            case "%":
                sb.append("MOD");
                break;
            case "==":
                sb.append("EQ");
                break;
            case "!=":
                sb.append("NEQ");
                break;
            case ">":
                sb.append("GT");
                break;
            case ">=":
                sb.append("GTE");
                break;
            case "<":
                sb.append("LT");
                break;
            case "<=":
                sb.append("LTE");
                break;
        }
        return sb;
    }

    private StringBuilder generate(UnaryOpNode node) {
        StringBuilder sb = generate(node
                .getChild(0)).append("\n");
        switch (node.getName()) {
            case "-":
                sb.append("NEG");
                break;
            case "!":
                sb.append("NOT");
                break;
        }
        return sb;
    }

    private StringBuilder generate(ObjectCallNode node) {
        return generate(node.getChild(0))
                .append("\n")
                .append("PUSH ")
                .append(node.getChild(1).getName())
                .append("\nGETFIELD");
    }

    private StringBuilder generate(ArrayCallNode node) {
        return generate(node.getChild(0))
                .append("\n")
                .append(generate(node.getChild(1)))
                .append("\nALOAD");
    }

    private StringBuilder generate(FunctionCallNode node) {
        StringBuilder sb = generate(node.getChild(0)).append("\n");
        for (int i = 1; i < node.getChildrenAmount(); i++) {
            sb.append(generate(node.getChild(i))).append("\n");
        }
        return sb.append("CALLFUNC");
    }

    private StringBuilder generate(FieldNode node) {
        return new StringBuilder()
                .append(generate(node.getChild(1)))
                .append("\n")
                .append(generate(node.getChild(0)))
                .append("\nSETFIELD ")
                .append('"').append(node.getChild(1).getName()).append('"');
    }

    private StringBuilder generate(FunctionDefinitionNode node) {
        StringBuilder sb = new StringBuilder("NEWFUNC ");
        sb.append(node.getName())
                .append(" ")
                .append(node.getChildrenAmount() - 2)
                .append("\n");
        for (int i = 1; i < node.getChildrenAmount() - 1; i++) {
            sb.append(node.getChild(i).getName()).append(" ");
        }
        return sb.append("\n")
                .append(generate(node.getChild(node.getChildrenAmount() - 1)));
    }

    private StringBuilder generate(ObjectLiteralNode node) {
        StringBuilder sb = new StringBuilder("NEWOBJECT\n");
        for (AstNode child : node.children) {
            sb.append(generate(child)).append("\n");
        }
        return sb;
    }

    private StringBuilder generate(ArrayLiteralNode node) {
        StringBuilder sb = new StringBuilder("NEWARRAY\n");
        for (AstNode child : node.children) {
            sb.append(generate(child)).append("\n");
        }
        return sb;
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
        StringBuilder sb = new StringBuilder("start_while:\n");
        sb.append(generate(node.getChild(0)))
                .append("\nJMF end_while\n")
                .append(generate(node.getChild(1)))
                .append("\nJMP start_while\nend_while:");
        return sb;
    }

    private StringBuilder generate(ElseNode node) {
        return generate(node.getChild(0));
    }

    private StringBuilder generate(ElifNode node) {
        return new StringBuilder("elif\n")
                .append(generate(node.getChild(0)))
                .append("\nJMT elif_body\n")
                .append(generate(node.getChild(1)))
                .append("\nelif_body:");
    }

    private StringBuilder generate(IfNode node) {
        StringBuilder sb = new StringBuilder("if\n");
        sb.append(generate(node.getChild(0)))
                .append("\nJMF else_block\n")
                .append(generate(node.getChild(1)))
                .append("\nJMP end_if\nelse_block:");
        for (int i = 2; i < node.getChildrenAmount() - 1; i++) {
            sb.append(generate(node.getChild(i))).append("\n");
        }
        sb.append(generate(node.getChild(node.getChildrenAmount() - 1)))
                .append("\nend_if:");
        return sb;
    }

    private StringBuilder generate(ProgramNode node) {
        StringBuilder sb = new StringBuilder();
        for (AstNode child : node.children) {
            sb.append(generate(child)).append("\n");
        }
        return sb;
    }

    private StringBuilder generate(ForNode node) {
        return new StringBuilder("for\n")
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
        StringBuilder code = new StringBuilder("#main\n");
        code.append(generate(node));
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(code.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}