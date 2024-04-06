package ru.vsu.dnlkkandco;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import ru.vsu.dnlkkandco.gen.DnlkkRulesLexer;
import ru.vsu.dnlkkandco.gen.DnlkkRulesParser;

import java.io.FileInputStream;
import java.io.IOException;

public class DnlkkScript {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("src/main/resources/testProgram");

        CharStream input = CharStreams.fromStream(inputStream);

        DnlkkRulesLexer lexer = new DnlkkRulesLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        DnlkkRulesParser parser = new DnlkkRulesParser(tokens);

        ParseTree tree = parser.program();
        try {
            AstNode node = tree.accept(new AstBuilderVisitor());
            System.out.println(new TreeViewAst(node));
        } catch (Exception e) {
            System.err.println("Parsing error");
            System.err.println(e.getMessage());
        }
    }
}
