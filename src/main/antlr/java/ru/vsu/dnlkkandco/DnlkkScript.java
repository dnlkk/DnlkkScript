package ru.vsu.dnlkkandco;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vsu.dnlkkandco.gen.DnlkkRulesLexer;
import ru.vsu.dnlkkandco.gen.DnlkkRulesParser;

import java.io.FileInputStream;
import java.io.IOException;

public class DnlkkScript {
    private static final Logger log = LoggerFactory.getLogger(DnlkkScript.class);

    public static void main(String[] args) throws IOException {
        log.info("Starting DnlkkScript...");
        FileInputStream inputStream = new FileInputStream("src/main/resources/testProgram");

        CharStream input = CharStreams.fromStream(inputStream);

        DnlkkRulesLexer lexer = new DnlkkRulesLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        DnlkkRulesParser parser = new DnlkkRulesParser(tokens);

        CodeGeneration codeGeneration = new CodeGeneration();

        ParseTree tree = parser.program();
        try {
            AstNode node = tree.accept(new AstBuilderVisitor());
            System.out.println(node.toString());
            String result = treeViewAst(node);
            System.out.println(result);
            codeGeneration.writeToFile("D:\\DnlkkScriptе\\src\\main\\resources\\output.txt", node);
        } catch (Exception e) {
            System.err.println("Parsing error");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
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
