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

    public static void main(String[] args) {
        log.info("Starting DnlkkScript...");

        try {
            var sourceFile = "src/main/resources/testProgram";
            log.debug("Read file {}", sourceFile);
            var inputStream = new FileInputStream(sourceFile);
            var input = CharStreams.fromStream(inputStream);

            log.debug("Lexing analyze with {}", DnlkkRulesLexer.class.getName());
            var lexer = new DnlkkRulesLexer(input);
            var tokens = new CommonTokenStream(lexer);
            var parser = new DnlkkRulesParser(tokens);

            var tree = parser.program();
            var node = tree.accept(new AstBuilderVisitor());

            var byteCodeFile = "D:\\DnlkkScriptе\\src\\main\\resources\\output.txt";
            log.debug("Write codegeneration result to {}", byteCodeFile);
            var codeGeneration = new CodeGeneration();
            codeGeneration.writeToFile(byteCodeFile, node);

            var result = treeViewAst(node);
            log.debug("Ast tree view:\n{}", result);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
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
