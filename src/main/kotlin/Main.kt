package org.example

import org.example.Behavioral.State.StateExecutor

fun main() {
    val stateExecutor: PatternExecutor = StateExecutor()
    stateExecutor.main()
}