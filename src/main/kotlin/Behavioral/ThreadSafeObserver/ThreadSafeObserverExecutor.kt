package org.example.Behavioral.ThreadSafeObserver

import org.example.PatternExecutor
import kotlin.concurrent.thread

class ThreadSafeObserverExecutor : PatternExecutor {
    override fun main() {

        val blogger = Blogger()

        val threads = List(1000) { i ->
            thread {
                blogger.subscribe(Subscriber("Subscriber-$i"))
            }
        }

        threads.forEach { it.join() }

        println("Total subscribers: ${blogger.subscribers.size}")


    }
}