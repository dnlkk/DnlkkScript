package ru.dnlkk;

import java.util.*;
import org.eclipse.lsp4j.*;

public class CompletionProvider {
    private final Map<String, Set<String>> objectFields;
    private final Set<String> allIdents;
    private final DnlkkScriptLanguageServer languageServer;

    public CompletionProvider(DnlkkScriptLanguageServer languageServer, Map<String, Set<String>> objectFields, Set<String> allIdents) {
        this.languageServer = languageServer;
        this.objectFields = objectFields;
        this.allIdents = allIdents;
    }

    public List<CompletionItem> getCompletions(String textBeforePosition) {
        List<CompletionItem> completionItems = new ArrayList<>();
        languageServer.getLanguageClient().logMessage(
                new MessageParams(MessageType.Info, "textBeforePosition: " + textBeforePosition)
        );

        if (textBeforePosition.contains(".")) {
            String[] parts = textBeforePosition.trim().split("\\.");
            languageServer.getLanguageClient().logMessage(
                    new MessageParams(MessageType.Info, "parts: " + Arrays.toString(parts))
            );

            if (parts.length > 0) {
                String parentObject = parts[parts.length - 1].trim();
                languageServer.getLanguageClient().logMessage(
                        new MessageParams(MessageType.Info, "parentObject: " + parentObject)
                );
                Set<String> fields = objectFields.get(parentObject);
                languageServer.getLanguageClient().logMessage(
                        new MessageParams(MessageType.Info, "fields: " + fields)
                );
                if (fields != null) {
                    for (String field : fields) {
                        CompletionItem fieldItem = new CompletionItem();
                        fieldItem.setLabel(field);
                        fieldItem.setKind(CompletionItemKind.Field);
                        completionItems.add(fieldItem);
                    }
                }
            }
        } else {
            for (String ident : allIdents) {
                CompletionItem item = new CompletionItem();
                item.setLabel(ident);
                item.setKind(CompletionItemKind.Variable);
                completionItems.add(item);
            }
        }

        return completionItems;
    }
}
