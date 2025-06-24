package org.example

import org.example.Behavioral.Strategy.StrategyExecutor


fun main() {
    val strategyExecutor: PatternExecutor = StrategyExecutor()
    strategyExecutor.main()
}