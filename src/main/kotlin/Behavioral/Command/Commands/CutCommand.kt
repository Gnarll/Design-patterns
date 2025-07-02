package org.example.Behavioral.Command.Commands

import org.example.Behavioral.Command.Application
import org.example.Behavioral.Command.Editor

class CutCommand(app: Application, editor: Editor, backup: String) : Command(app, editor, backup) {
    override fun execute(): Boolean {
        saveBackup()
        app.clipboard = editor.getSelection()
        editor.deleteSelection()
        return true
    }
}