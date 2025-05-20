package org.example

import org.example.Behavioral.ThreadSafeObserver.ThreadSafeObserverExecutor


fun main() {
    val threadSafeObserverExecutor: PatternExecutor = ThreadSafeObserverExecutor()
    threadSafeObserverExecutor.main()
}