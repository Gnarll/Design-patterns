package org.example.Behavioral.Command.Commands

import org.example.Behavioral.Command.Application
import org.example.Behavioral.Command.Editor

class UndoCommand(app: Application, editor: Editor, backup: String) : Command(app, editor, backup) {
    override fun execute(): Boolean {
        app.undo()
        return false
    }
}