import java.util.ArrayList;
import java.util.List;

class Node {
    String label;
    List<Node> children;

    Node(String label, List<Node> children) {
        this.label = label;
        this.children = children;
    }

    Node(String label) {
        this.label = label;
        this.children = new ArrayList<>();
    }

    @Override
    public String toString() {
        if (children.isEmpty()) {
            return label;
        } else {
            StringBuilder builder = new StringBuilder();
            builder.append(label).append("(");
            for (Node child : children) {
                builder.append(child.toString()).append(", ");
            }
            builder.setLength(builder.length() - 2); // Remove trailing comma and space
            builder.append(")");
            return builder.toString();
        }
    }
}

public class Parser {
    public static Node parseTree(String string) {
        String[] tokens = string.replace("(", " ( ").replace(")", " ) ").split("\\s+");
        return parseTokens(tokens);
    }

    private static Node parseTokens(String[] tokens) {
        List<String> tokenList = new ArrayList<>();
        for (String token : tokens) {
            if (!token.equals("")) {
                tokenList.add(token);
            }
        }
        return parse(tokenList);
    }

    private static Node parse(List<String> tokens) {
        if (tokens.isEmpty()) {
            return null;
        }

        String token = tokens.remove(0);

        if (token.equals("(")) {
            String nodeLabel = tokens.remove(0);
            List<Node> children = new ArrayList<>();
            while (!tokens.get(0).equals(")")) {
                children.add(parse(tokens));
            }
            tokens.remove(0); // Pop the closing ')'
            return new Node(nodeLabel, children);
        } else {
            return new Node(token);
        }
    }

    public static void printTree(Node node, int depth, boolean isLast) {
        if (node != null) {
            for (int i = 0; i < depth; i++) {
                System.out.print(i == depth - 1 ? (isLast ? "└── " : "├── ") : "   ");
            }
            System.out.println(node.label);
            for (int i = 0; i < node.children.size(); i++) {
                printTree(node.children.get(i), depth + 1, i == node.children.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String string = "(program (stmt_list (stmt (assign (ident hello) = (expr (add (mult (group 2))))))))";
        Node tree = parseTree(string);
        printTree(tree, 0, true);
    }
}
