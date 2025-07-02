package org.example.Behavioral.Command.Commands

class CommandHistory(private val history: MutableList<Command> = mutableListOf()) {
    fun push(command: Command) {
        history.add(command)
    }

    fun pop(): Command? {
        if (history.isEmpty()) {
            return null
        }
        return history.removeAt(history.lastIndex)
    }

    fun clear() {
        history.clear()
    }
}