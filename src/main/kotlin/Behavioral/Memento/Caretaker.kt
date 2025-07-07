package org.example.Behavioral.Memento


class Caretaker {
    private val history = ArrayDeque<Memento>()

    fun save(memento: Memento) {
        history.addFirst(memento)
    }

    fun undo(): Memento? = if (history.isNotEmpty()) history.removeFirst() else null
}