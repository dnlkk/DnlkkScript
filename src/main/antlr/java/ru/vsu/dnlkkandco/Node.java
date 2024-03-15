package ru.vsu.dnlkkandco;

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
