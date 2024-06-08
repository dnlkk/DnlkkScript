import * as vscode from 'vscode';
import { extensionInstance } from './DnlkkScript';

export function activate(context: vscode.ExtensionContext) {
	extensionInstance.setContext(context);
	extensionInstance.init().catch((error)=> {
		console.log("Failed to activate Ballerina extension. " + (error));
	})
}

export function deactivate() {}