package org.example.Creational.Factory

import org.example.PatternExecutor

class FactoryExecutor : PatternExecutor {
    override fun main() {
        val factory = CoroutineFactory()

        val job = factory.launch {
            println("Job is working")
        }

        job.cancel()

        val deferred = factory.async {
            println("deferred is working")
            val arr = listOf(1, 2, 3)

            arr
        }

        println(deferred.await())
    }
}