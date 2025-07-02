package org.example.Behavioral.Command.Commands

import org.example.Behavioral.Command.Application
import org.example.Behavioral.Command.Editor

// aka Action
abstract class Command(
    protected val app: Application,
    protected val editor: Editor,
    private var backup: String? = null
) {


    fun saveBackup() {
        backup = editor.text
    }

    fun undo() {
        backup?.let {
            editor.text = it
        }
    }

    abstract fun execute(): Boolean
}