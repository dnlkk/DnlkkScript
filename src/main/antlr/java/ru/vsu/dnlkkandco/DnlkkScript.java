package ru.vsu.dnlkkandco;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import ru.vsu.dnlkkandco.gen.DnlkkRulesLexer;
import ru.vsu.dnlkkandco.gen.DnlkkRulesParser;

import java.io.FileInputStream;
import java.io.IOException;

import static ru.vsu.dnlkkandco.Parser.parseTree;
import static ru.vsu.dnlkkandco.Parser.printTree;

public class DnlkkScript {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("src/main/resources/testProgram");

        CharStream input = CharStreams.fromStream(inputStream);

        DnlkkRulesLexer lexer = new DnlkkRulesLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        DnlkkRulesParser parser = new DnlkkRulesParser(tokens);

        ParseTree tree = parser.program();
        AstNode node = tree.accept(new AstBuilderVisitor());
        String result = treeViewAst(node);
        System.out.println(result);
//        Node treeNode = parseTree(tree.toStringTree(parser));
//        printTree(treeNode, 0, true);
    }

    static String treeView(ParseTree tree) {
        return treeViewInner(tree, new StringBuffer(), "", "", "").toString();
    }

    static StringBuffer treeViewInner(ParseTree tree, StringBuffer out, String prevPrefix, String prefixLine, String prefixNode) {
        String line = prevPrefix + prefixNode;
        if (tree.getChildCount() == 0) {
            line += tree.getText();
        } else {
            String className = tree.getClass().toString();
            int nodeIndexBegin = className.indexOf('$') + 1;
            int nodeIndexEnd = className.indexOf("Context");
            String nodeName = className.substring(nodeIndexBegin, nodeIndexEnd);
            line += nodeName;
        }
        out.append(line).append('\n');
        for (int i = 0; i < tree.getChildCount(); i++) {
            boolean last = i == tree.getChildCount() - 1;
            String nextLevelPrefix = last ? "  " : "│ ";
            String nodePrefix = last ? "└─" : "├─";
            treeViewInner(tree.getChild(i), out, prevPrefix + prefixLine, nextLevelPrefix, nodePrefix);
        }
        return out;
    }

    static String treeViewAst(AstNode tree) {
        return treeViewAstInner(tree, new StringBuffer(), "", "", "").toString();
    }

    static StringBuffer treeViewAstInner(AstNode tree, StringBuffer out, String prevPrefix, String prefixLine, String prefixNode) {
        String line = prevPrefix + prefixNode + (tree == null ? "null" : tree.getName());

        out.append(line).append('\n');
        for (int i = 0; tree != null && i < tree.getChildrenAmount(); i++) {
            boolean last = i == tree.getChildrenAmount() - 1;
            String nextLevelPrefix = last ? "  " : "│ ";
            String nodePrefix = last ? "└─" : "├─";
            treeViewAstInner(tree.getChild(i), out, prevPrefix + prefixLine, nextLevelPrefix, nodePrefix);
        }
        return out;
    }
}
