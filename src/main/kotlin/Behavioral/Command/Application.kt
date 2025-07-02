package org.example.Behavioral.Command

import org.example.Behavioral.Command.Commands.*

class Application() {
    var clipboard: String = ""
    val history: CommandHistory = CommandHistory()

    private lateinit var editor: Editor

    fun createUi() {
        val copy: () -> Unit = {
            executeCommand(CopyCommand(this, editor, backup = ""))
        }
        val cut: () -> Unit = {
            executeCommand(CutCommand(this, editor, backup = ""))
        }
        val paste: () -> Unit = {
            executeCommand(PasteCommand(this, editor, backup = ""))
        }
        val undo: () -> Unit = {
            executeCommand(UndoCommand(this, editor, backup = ""))
        }

        editor = Editor(
            onCopyButtonClick = copy,
            onCutButtonClick = cut,
            onPasteButtonClick = paste,
            onUndoButtonClick = undo,
            onCopyShortcutExecute = copy,
            onCutShortcutExecute = cut,
            onPasteShortcutExecute = paste,
            onUndoShortcutExecute = undo,
            onChangeText = ::clearHistory
        )
    }


    fun executeCommand(command: Command) {
        if (command.execute()) {
            history.push(command)
        }
    }

    fun undo() {
        val lastCommand = history.pop()
        if (lastCommand != null) {
            lastCommand.undo()
        }
    }

    fun clearHistory() {
        history.clear()
    }
}