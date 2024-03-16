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
        treeView(tree, 0);
//        Node treeNode = parseTree(tree.toStringTree(parser));
//        printTree(treeNode, 0, true);
    }

    static void treeView(ParseTree tree, int level) {
//        "└── " : "├── "
        String out = "\t".repeat(level);
        if (tree.getChildCount() == 0) {
            out += tree.getText();
        } else {
            String className = tree.getClass().toString();
            int nodeIndexBegin = className.indexOf('$') + 1;
            int nodeIndexEnd = className.indexOf("Context");
            String nodeName = className.substring(nodeIndexBegin, nodeIndexEnd);
            out += nodeName;
        }
        System.out.println(out);
        for (int i = 0; i < tree.getChildCount(); i++) {
            treeView(tree.getChild(i), level + 1);
        }
    }
}
