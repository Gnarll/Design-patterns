package org.example.Creational.Factory

import kotlin.coroutines.cancellation.CancellationException

enum class CoroutineState {
    Created,
    Active,
    Cancelled,
    Completed
}

// over simplified classic coroutine analogy
// doesn't support asynchronous behavior
// made just for factory pattern understanding
abstract class Coroutine() {

    private var state: CoroutineState = CoroutineState.Created


    fun cancel() {
        state = CoroutineState.Cancelled
    }

    fun start() {
        state = CoroutineState.Active
    }

    fun finish() {
        state = CoroutineState.Completed
    }

    init {
        start()
    }
}

class Job() : Coroutine() {

}

class Deferred<T> : Coroutine() {

    var result: T? = null // should be private

    fun await(): T? {
        return when {
            result == null -> {
                cancel()
                throw CancellationException()
            }

            else -> {
                finish()
                result
            }
        }
    }
}

