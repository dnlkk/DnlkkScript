package ru.dnlkk.ast;

import java.util.stream.IntStream;

public class TreeViewAst {
    private final AstNode tree;

    public TreeViewAst(AstNode tree) {
        this.tree = tree;
    }

    @Override
    public String toString() {
        return treeViewAstInner(tree, new StringBuffer(), "", "", "").toString();
    }

    private StringBuffer treeViewAstInner(AstNode tree, StringBuffer out, String prevPrefix, String prefixLine, String prefixNode) {
        String line = prevPrefix + prefixNode + (tree == null ? "null" : tree.getName());

        out.append(line).append('\n');

        if (tree != null) {
            IntStream.range(0, tree.getChildrenAmount())
                    .forEach(i -> {
                        boolean last = i == tree.getChildrenAmount() - 1;
                        String nextLevelPrefix = last ? "  " : "│ ";
                        String nodePrefix = last ? "└─" : "├─";
                        treeViewAstInner(tree.getChild(i), out, prevPrefix + prefixLine, nextLevelPrefix, nodePrefix);
                    });
        }

        return out;
    }
}
