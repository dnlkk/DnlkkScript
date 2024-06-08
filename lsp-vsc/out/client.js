"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.deactivate = exports.activate = void 0;
const DnlkkScript_1 = require("./DnlkkScript");
function activate(context) {
    DnlkkScript_1.extensionInstance.setContext(context);
    DnlkkScript_1.extensionInstance.init().catch((error) => {
        console.log("Failed to activate Ballerina extension. " + (error));
    });
}
exports.activate = activate;
function deactivate() { }
exports.deactivate = deactivate;
//# sourceMappingURL=client.js.map