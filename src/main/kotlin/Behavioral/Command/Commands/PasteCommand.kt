package org.example.Behavioral.Command.Commands

import org.example.Behavioral.Command.Application
import org.example.Behavioral.Command.Editor

class PasteCommand(app: Application, editor: Editor, backup: String) : Command(app, editor, backup) {
    override fun execute(): Boolean {
        saveBackup()
        editor.replaceSelection(app.clipboard)
        return true
    }
}