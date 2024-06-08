package ru.dnlkk;

import org.eclipse.lsp4j.jsonrpc.Launcher;
import org.eclipse.lsp4j.services.LanguageClient;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class DnlkkScriptLanguageServerLauncher {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        startServer(System.in, System.out);
    }

    public static void startServer(InputStream in, OutputStream out) throws InterruptedException, ExecutionException {
        DnlkkScriptLanguageServer server = new DnlkkScriptLanguageServer();
        Launcher<LanguageClient> launcher = Launcher.createLauncher(server, LanguageClient.class, in, out);
        LanguageClient client = launcher.getRemoteProxy();
        server.connect(client);
        Future<?> startListening = launcher.startListening();
        startListening.get();
    }
}