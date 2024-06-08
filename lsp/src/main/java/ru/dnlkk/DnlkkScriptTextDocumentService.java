package ru.dnlkk;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.eclipse.lsp4j.*;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.lsp4j.services.TextDocumentService;
import ru.dnlkk.ast.AstBuilderVisitor;
import ru.dnlkk.ast.AstNode;
import ru.dnlkk.gen.DnlkkRulesLexer;
import ru.dnlkk.gen.DnlkkRulesParser;
import ru.dnlkk.gen.DnlkkRulesBaseListener;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.CompletableFuture;

public class DnlkkScriptTextDocumentService implements TextDocumentService {
    private DnlkkScriptLanguageServer languageServer;
    private final AstBuilderVisitor astBuilderVisitor;

    public DnlkkScriptTextDocumentService(DnlkkScriptLanguageServer languageServer) {
        this.languageServer = languageServer;
        astBuilderVisitor = new AstBuilderVisitor(languageServer);
    }

    @Override
    public void didOpen(DidOpenTextDocumentParams didOpenTextDocumentParams) {
        languageServer.getLanguageClient().logMessage(
                new MessageParams(MessageType.Info, String.format("Operation 'text/didOpen' {fileUri: '%s'} opened", didOpenTextDocumentParams.getTextDocument().getUri())
                ));
        parseDocument(didOpenTextDocumentParams.getTextDocument().getText());
    }

    @Override
    public void didChange(DidChangeTextDocumentParams didChangeTextDocumentParams) {
        languageServer.getLanguageClient().logMessage(
                new MessageParams(MessageType.Info, String.format("Operation 'text/didChange' {fileUri: '%s'} Changed", didChangeTextDocumentParams.getTextDocument().getUri())
                ));
        for (TextDocumentContentChangeEvent changeEvent : didChangeTextDocumentParams.getContentChanges()) {
            parseDocument(changeEvent.getText());
        }
    }

    private DnlkkRulesParser parseDocument(String text) {
        DnlkkRulesLexer lexer = new DnlkkRulesLexer(CharStreams.fromString(text));
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        return new DnlkkRulesParser(tokens);
    }

    @Override
    public void didClose(DidCloseTextDocumentParams didCloseTextDocumentParams) {
        languageServer.getLanguageClient().logMessage(
                new MessageParams(MessageType.Info, String.format(
                        "Operation 'text/didClose' {fileUri: '%s'} Closed", didCloseTextDocumentParams.getTextDocument().getUri()
                )
                ));
    }

    @Override
    public void didSave(DidSaveTextDocumentParams didSaveTextDocumentParams) {
        languageServer.getLanguageClient().logMessage(
                new MessageParams(MessageType.Info, String.format(
                        "Operation 'text/didSave' {fileUri: '%s'} Saved", didSaveTextDocumentParams.getTextDocument().getUri()
                )
                ));
    }

    @Override
    public CompletableFuture<Either<List<CompletionItem>, CompletionList>> completion(CompletionParams position) {
        languageServer.getLanguageClient().logMessage(
                new MessageParams(MessageType.Info, String.format(
                        "Position: {line: %s, character: %s} context: '%s'", position.getPosition().getLine(), position.getPosition().getCharacter(), position.getContext().toString()
                )
                ));
        return CompletableFuture.supplyAsync(() -> {
            String text = getTextFromFile(position.getTextDocument().getUri());
            astBuilderVisitor.visit(parseDocument(text).program());

            String textBeforePosition = getTextBeforePosition(position.getTextDocument().getUri(), position.getPosition());
            languageServer.getLanguageClient().logMessage(
                    new MessageParams(MessageType.Info, "textBeforePosition: " + textBeforePosition)
            );

            Map<String, Set<String>> objectFields = astBuilderVisitor.getObjectFields();
            Set<String> allIdents = astBuilderVisitor.getAllIdents();

            languageServer.getLanguageClient().logMessage(
                    new MessageParams(MessageType.Info, String.join(", ", new ArrayList<>(allIdents)))
            );

            languageServer.getLanguageClient().logMessage(
                    new MessageParams(MessageType.Info, String.join(", ", new ArrayList<>(objectFields.keySet())))
            );

            languageServer.getLanguageClient().logMessage(
                    new MessageParams(MessageType.Info, String.join(", ", objectFields.values().stream().map(a -> '<' + String.join(", ", a.stream().toList()) + '>').toList()))
            );

            CompletionProvider completionProvider = new CompletionProvider(languageServer, objectFields, allIdents);

            return Either.forLeft(completionProvider.getCompletions(textBeforePosition));
        });
    }

    private String getTextBeforePosition(String uri, Position position) {
        languageServer.getLanguageClient().logMessage(
                new MessageParams(MessageType.Info, "position.getLine(): " + position.getLine())
        );
        try {
            URI fileUri = new URI(uri);
            Path path = Paths.get(fileUri);
            List<String> lines = Files.readAllLines(path);
            languageServer.getLanguageClient().logMessage(
                    new MessageParams(MessageType.Info, "position.getLine(): " + position.getLine())
            );
            String line = lines.get(position.getLine());
            languageServer.getLanguageClient().logMessage(
                    new MessageParams(MessageType.Info, "line: " + line)
            );
            return line;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public CompletableFuture<List<? extends DocumentHighlight>> documentHighlight(DocumentHighlightParams params) {
        return CompletableFuture.supplyAsync(() -> {
            String text = getTextFromFile(params.getTextDocument().getUri());

            DnlkkRulesLexer lexer = new DnlkkRulesLexer(CharStreams.fromString(text));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            DnlkkRulesParser parser = new DnlkkRulesParser(tokens);

            ParseTree tree = parser.program();

            List<DocumentHighlight> highlights = getHighlightsFromTree(tree, params.getPosition());

            return highlights;
        });
    }

    private String getTextFromFile(String uri) {
        try {
            URI fileUri = new URI(uri);
            Path path = Paths.get(fileUri);
            File file = path.toFile();
            return String.join("\n", Files.readAllLines(file.toPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private List<DocumentHighlight> getHighlightsFromTree(ParseTree tree, Position position) {
        List<DocumentHighlight> highlights = new ArrayList<>();

        Token identTokenUnderCursor = getIdentTokenUnderCursor(tree, position);
        if (identTokenUnderCursor == null) {
            return highlights;
        }
        String identText = identTokenUnderCursor.getText();

        List<ParseTree> identNodes = new ArrayList<>();
        collectNodes(tree, DnlkkRulesParser.IDENT, identNodes);

        for (ParseTree identNode : identNodes) {
            Token token = (Token) identNode.getPayload();
            if (token.getText().equals(identText)) {
                DocumentHighlight highlight = new DocumentHighlight();
                highlight.setRange(getRangeFromToken(token));
                highlight.setKind(DocumentHighlightKind.Text);
                highlights.add(highlight);
            }
        }

        return highlights;
    }

    private Token getIdentTokenUnderCursor(ParseTree tree, Position position) {
        for (int i = 0; i < tree.getChildCount(); i++) {
            ParseTree child = tree.getChild(i);
            if (child instanceof TerminalNode) {
                Token token = ((TerminalNode) child).getSymbol();
                if (token.getType() == DnlkkRulesParser.IDENT) {
                    if (isPositionInToken(token, position)) {
                        return token;
                    }
                }
            } else if (child instanceof RuleContext) {
                Token result = getIdentTokenUnderCursor(child, position);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }

    private boolean isPositionInToken(Token token, Position position) {
        int start = token.getStartIndex();
        int stop = token.getStopIndex();
        int pos = positionToOffset(position, token.getTokenSource().getInputStream().toString());
        return start <= pos && pos <= stop;
    }

    private int positionToOffset(Position position, String text) {
        int offset = 0;
        int line = 0;
        int charInLine = 0;
        for (char c : text.toCharArray()) {
            if (line == position.getLine() && charInLine == position.getCharacter()) {
                return offset;
            }
            if (c == '\n') {
                line++;
                charInLine = 0;
            } else {
                charInLine++;
            }
            offset++;
        }
        return offset;
    }


    private void collectNodes(ParseTree tree, int ruleIndex, List<ParseTree> nodes) {
        if (tree.getPayload() instanceof Token) {
            Token token = (Token) tree.getPayload();
            if (token.getType() == ruleIndex) {
                nodes.add(tree);
            }
        }
        for (int i = 0; i < tree.getChildCount(); i++) {
            collectNodes(tree.getChild(i), ruleIndex, nodes);
        }
    }

    private Range getRangeFromToken(Token token) {
        Position start = new Position(token.getLine() - 1, token.getCharPositionInLine());
        Position end = new Position(token.getLine() - 1, token.getCharPositionInLine() + token.getText().length());
        return new Range(start, end);
    }
}
