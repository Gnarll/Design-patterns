package org.example.Behavioral.Memento


interface Memento

data class UiState(val x: Int, val y: Int, val width: Int, val height: Int)

class DotModel(initialState: UiState) {
    var state: UiState = initialState
        private set

    fun moveTo(x: Int, y: Int) {
        state = state.copy(x = x, y = y)
    }

    fun resize(delta: Int) {
        val newWidth = (state.width + delta).coerceAtLeast(1)
        val newHeight = (state.height + delta).coerceAtLeast(1)
        state = state.copy(width = newWidth, height = newHeight)
    }

    fun createSnapshot(): Memento = MementoImpl(state)

    fun restore(memento: Memento) {
        if (memento is MementoImpl) {
            state = memento.state
        }
    }

    private data class MementoImpl(val state: UiState) : Memento
}