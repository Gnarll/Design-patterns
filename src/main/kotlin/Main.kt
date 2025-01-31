package org.example

import org.example.Behavioral.Observer.ObserverExecutor


fun main() {
    val adapterExecutor: PatternExecutor = ObserverExecutor()
    adapterExecutor.main()
}