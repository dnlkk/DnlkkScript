// import * as vscode from 'vscode';

// import {
//   LanguageClient,
//   LanguageClientOptions,
//   ServerOptions
// } from 'vscode-languageclient/node';

// let client: LanguageClient;

// export function activate(context: vscode.ExtensionContext) {
// 	console.log('Congratulations, your extension "dnlkkscript" is now active!');

// 	let disposable = vscode.commands.registerCommand('dnlkkscript.helloWorld', () => {
// 		vscode.window.showInformationMessage('Hello World from DnlkkScript!');
// 	});

// 	context.subscriptions.push(disposable);

//     let serverOptions: ServerOptions = {
//         command: 'c:\\users\\user\\.jdks\\openjdk-22.0.1\\bin\\java.exe',
//         args: ['-cp', 'C:\\Users\\user\\DnlkkProjects\\DnlkkScript\\lsp\\language_server_lib\\*', 'DnlkkScriptLanguageServer'],
//         options: {}
//     };

//     let clientOptions: LanguageClientOptions = {
//         documentSelector: [{ scheme: 'file', language: 'dnlkkscript' }],
//     };

//     client = new LanguageClient(
//         'languageServerExample',
//         'Language Server Example',
//         serverOptions,
//         clientOptions
//     );

//     client.start();
// }

// export function deactivate() {}


import * as vscode from 'vscode';
import { extensionInstance } from './DnlkkScript';

export function activate(context: vscode.ExtensionContext) {
	extensionInstance.setContext(context);
	extensionInstance.init().catch((error)=> {
		console.log("Failed to activate Ballerina extension. " + (error));
	})
}

export function deactivate() {}