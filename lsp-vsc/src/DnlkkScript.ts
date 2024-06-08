import path = require("path");
import * as vscode from "vscode";
import {
  LanguageClientOptions,
  RevealOutputChannelOn,
} from "vscode-languageclient";

import {
  LanguageClient,
  ServerOptions,
  State,
} from "vscode-languageclient/node";

const outputChannel = vscode.window.createOutputChannel("DnlkkScript");
const LS_LAUNCHER_MAIN: string = "ru.dnlkk.DnlkkScriptLanguageServerLauncher";

export class DnlkkScriptExtension {
  private languageClient?: LanguageClient;
  private context?: vscode.ExtensionContext;

  setContext(context: vscode.ExtensionContext) {
    this.context = context;
  }

  async init(): Promise<void> {
    try {
      //Server options. LS client will use these options to start the LS.
      let serverOptions: ServerOptions = getServerOptions();

      //creating the language client.
      let clientId = "dnlkkscript-vscode-lsclient";
      let clientName = "DnlkkScript LS Client";
      let clientOptions: LanguageClientOptions = {
        documentSelector: [{ scheme: "file", language: "dnlkkscript" }],
        outputChannel: outputChannel,
        revealOutputChannelOn: RevealOutputChannelOn.Never,
      };
      this.languageClient = new LanguageClient(
        clientId,
        clientName,
        serverOptions,
        clientOptions
      );

      const disposeDidChange = this.languageClient.onDidChangeState(
        (stateChangeEvent) => {
          if (stateChangeEvent.newState === State.Stopped) {
            vscode.window.showErrorMessage(
              "Failed to initialize the extension"
            );
          } else if (stateChangeEvent.newState === State.Running) {
            vscode.window.showInformationMessage(
              "Extension initialized successfully!"
            );
          }
        }
      );

      let disposable = this.languageClient.start();
      // @ts-ignore
      await this.languageClient.onReady();
        disposeDidChange.dispose();
        // @ts-ignore
        this.context!.subscriptions.push(disposable);
    } catch (exception) {
      return Promise.reject("Extension error!");
    }
  }
}

//Create a command to be run to start the LS java process.
function getServerOptions() {
  //Change the project home accordingly.
  const PROJECT_HOME = "c:\\users\\user\\.jdks\\openjdk-22.0.1";
  const LS_LIB = "C:\\Users\\user\\DnlkkProjects\\DnlkkScript\\lsp\\language_server_lib\\lsp-1.0-jar-with-dependencies.jar";
  const JAVA_HOME = process.env.JAVA_HOME;

  let executable: string = path.join(String(JAVA_HOME), "bin", "java.exe");
  let args: string[] = ["-jar", LS_LIB];

  let serverOptions: ServerOptions = {
    command: executable,
    args: [...args],
    options: {},
  };
  return serverOptions;
}

export const extensionInstance = new DnlkkScriptExtension();