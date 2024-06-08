package ru.dnlkk;

import org.eclipse.lsp4j.*;
import org.eclipse.lsp4j.services.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;


public final class DnlkkScriptLanguageServer implements LanguageServer, LanguageClientAware{
    private LanguageClient languageClient;

    public LanguageClient getLanguageClient() {
        return languageClient;
    }

    private DnlkkScriptTextDocumentService textDocumentService;
    private WorkspaceService workspaceService;
    private ClientCapabilities clientCapabilities;
    private int shutdown = 1;

    public DnlkkScriptLanguageServer() {
        this.textDocumentService = new DnlkkScriptTextDocumentService(this);
    }


    @Override
    public CompletableFuture<InitializeResult> initialize(InitializeParams initializeParams) {
        ServerCapabilities serverCapabilities = new ServerCapabilities();
        serverCapabilities.setDocumentHighlightProvider(true);

        CompletionOptions completionOptions = new CompletionOptions();
        completionOptions.setTriggerCharacters(Arrays.asList(".", "(", "["));
        completionOptions.setAllCommitCharacters(Arrays.asList(".", "(", "["));
        serverCapabilities.setCompletionProvider(completionOptions);

        InitializeResult initializeResult = new InitializeResult(serverCapabilities);

        initializeResult.getCapabilities().setTextDocumentSync(TextDocumentSyncKind.Full);
        this.clientCapabilities = initializeParams.getCapabilities();

        if (!isDynamicCompletionRegistration()) {
            initializeResult.getCapabilities().setCompletionProvider(new CompletionOptions());
            initializeResult.getCapabilities().setDocumentHighlightProvider(new DocumentHighlightOptions());
        }
        return CompletableFuture.completedFuture(initializeResult);
    }

    @Override
    public void initialized(InitializedParams params) {
        //Check if dynamic completion support is allowed, if so register.
        if (isDynamicCompletionRegistration()) {
            CompletionRegistrationOptions completionRegistrationOptions = new CompletionRegistrationOptions();
            Registration completionRegistration = new Registration(UUID.randomUUID().toString(),
                    "textDocument/completion", completionRegistrationOptions);
            languageClient.registerCapability(new RegistrationParams(List.of(completionRegistration)));
        }
    }

    @Override
    public CompletableFuture<Object> shutdown() {
        shutdown = 0;
        return CompletableFuture.supplyAsync(Object::new);
    }

    @Override
    public void exit() {
        System.exit(shutdown);
    }

    @Override
    public TextDocumentService getTextDocumentService() {
        return textDocumentService;
    }

    @Override
    public WorkspaceService getWorkspaceService() {
        return this.workspaceService;
    }

    @Override
    public void connect(LanguageClient languageClient) {
        this.languageClient = languageClient;
        languageClient.logMessage(new MessageParams(MessageType.Info, "Dnlkk Script Language Server Started"));
    }

    private boolean isDynamicCompletionRegistration() {
        TextDocumentClientCapabilities textDocumentCapabilities =
                clientCapabilities.getTextDocument();
        return textDocumentCapabilities != null && textDocumentCapabilities.getCompletion() != null
                && Boolean.FALSE.equals(textDocumentCapabilities.getCompletion().getDynamicRegistration());
    }
}
