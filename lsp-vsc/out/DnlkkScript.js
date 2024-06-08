"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.extensionInstance = exports.DnlkkScriptExtension = void 0;
const path = require("path");
const vscode = require("vscode");
const vscode_languageclient_1 = require("vscode-languageclient");
const node_1 = require("vscode-languageclient/node");
const outputChannel = vscode.window.createOutputChannel("DnlkkScript");
const LS_LAUNCHER_MAIN = "ru.dnlkk.DnlkkScriptLanguageServerLauncher";
class DnlkkScriptExtension {
    setContext(context) {
        this.context = context;
    }
    async init() {
        try {
            //Server options. LS client will use these options to start the LS.
            let serverOptions = getServerOptions();
            //creating the language client.
            let clientId = "dnlkkscript-vscode-lsclient";
            let clientName = "DnlkkScript LS Client";
            let clientOptions = {
                documentSelector: [{ scheme: "file", language: "dnlkkscript" }],
                outputChannel: outputChannel,
                revealOutputChannelOn: vscode_languageclient_1.RevealOutputChannelOn.Never,
            };
            this.languageClient = new node_1.LanguageClient(clientId, clientName, serverOptions, clientOptions);
            const disposeDidChange = this.languageClient.onDidChangeState((stateChangeEvent) => {
                if (stateChangeEvent.newState === node_1.State.Stopped) {
                    vscode.window.showErrorMessage("Failed to initialize the extension");
                }
                else if (stateChangeEvent.newState === node_1.State.Running) {
                    vscode.window.showInformationMessage("Extension initialized successfully!");
                }
            });
            let disposable = this.languageClient.start();
            // @ts-ignore
            await this.languageClient.onReady();
            disposeDidChange.dispose();
            // @ts-ignore
            this.context.subscriptions.push(disposable);
        }
        catch (exception) {
            return Promise.reject("Extension error!");
        }
    }
}
exports.DnlkkScriptExtension = DnlkkScriptExtension;
//Create a command to be run to start the LS java process.
function getServerOptions() {
    //Change the project home accordingly.
    const PROJECT_HOME = "c:\\users\\user\\.jdks\\openjdk-22.0.1";
    const LS_LIB = "C:\\Users\\user\\DnlkkProjects\\DnlkkScript\\lsp\\language_server_lib\\lsp-1.0-jar-with-dependencies.jar";
    const JAVA_HOME = process.env.JAVA_HOME;
    let executable = path.join(String(JAVA_HOME), "bin", "java.exe");
    let args = ["-jar", LS_LIB];
    let serverOptions = {
        command: executable,
        args: [...args],
        options: {},
    };
    return serverOptions;
}
exports.extensionInstance = new DnlkkScriptExtension();
//# sourceMappingURL=DnlkkScript.js.map