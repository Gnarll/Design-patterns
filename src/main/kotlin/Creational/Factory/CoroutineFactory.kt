package org.example.Creational.Factory


interface CoroutineAbstractFactory {
    fun launch(callback: () -> Unit): Coroutine
    fun <T> async(callback: () -> T): Deferred<T>
}


class CoroutineFactory : CoroutineAbstractFactory {
    override fun launch(callback: () -> Unit): Coroutine {

        val coroutine = Job()
        try {
            callback()
            coroutine.finish()
        } catch (e: Throwable) {
            coroutine.cancel()
            println("launch fun error $e")
        }

        return coroutine
    }

    override fun <T> async(callback: () -> T): Deferred<T> {
        val deferred = Deferred<T>()
        try {
            deferred.result = callback()
        } catch (e: Throwable) {
            deferred.cancel()
            println("async fun error $e")
        }
        return deferred
    }
}