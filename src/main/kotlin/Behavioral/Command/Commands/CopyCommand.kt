package org.example.Behavioral.Command.Commands

import org.example.Behavioral.Command.Application
import org.example.Behavioral.Command.Editor

class CopyCommand(app: Application, editor: Editor, backup: String) : Command(app, editor, backup) {
    override fun execute(): Boolean {
        app.clipboard = editor.getSelection()
        return false
    }
}