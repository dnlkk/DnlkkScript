package ru.vsu.dnlkkandco;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import ru.vsu.dnlkkandco.gen.DnlkkRulesLexer;
import ru.vsu.dnlkkandco.gen.DnlkkRulesParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DnlkkScript {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("src/main/resources/testProgram");
        String outputFilePath = "C:\\Users\\Евген\\Desktop\\DnlkkScript-dev\\src\\main\\resources\\output.txt";

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
            codeGeneration.writeToFile("C:\\Users\\Евген\\Desktop\\DnlkkScript-dev\\src\\main\\resources\\output.txt", node);
            runInterpreter(outputFilePath);
        } catch (Exception e) {
            System.err.println("Parsing error");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

    }

    private static void runInterpreter(String outputFilePath) {
        try {
            ProcessBuilder pb = new ProcessBuilder(
                    "java",
                    "-cp",
                    "C:\\Users\\Евген\\Desktop\\DnlkkScript-dev\\interpreter\\src\\main\\java\\ru\\vsu\\dnlkkandco\\Interpreter.java",
                    "C:\\Users\\Евген\\Desktop\\DnlkkScript-dev\\interpreter\\src\\main\\java\\ru\\vsu\\dnlkkandco\\Interpreter.java",
                    outputFilePath
            );
            pb.inheritIO();
            Process process = pb.start();
            process.waitFor();
        } catch (Exception e) {
            System.err.println("Error running interpreter:");
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
