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
        System.out.println(tree.getChild(0).getPayload());
//        Node treeNode = parseTree(tree.toStringTree(parser));
//        System.out.println(tree.toStringTree(parser));
//        printTree(treeNode, 0, true);
    }
}
