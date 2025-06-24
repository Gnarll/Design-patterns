package org.example.Behavioral.Strategy

import org.example.PatternExecutor

class StrategyExecutor : PatternExecutor {
    override fun main() {

        val navigator = Navigator(navigationStrategy = WalkingNavStrategy)
        navigator.renderPath(
            Location(55.751244, 37.618423),
            Location(55.758163, 37.649529)
        )

        navigator.changeNavigationStrategy(strategy = BusNavStrategy)
        navigator.renderPath(
            Location(55.751244, 37.618423),
            Location(55.758163, 37.649529)
        )


        navigator.changeNavigationStrategy(strategy = CarNavStrategy)
        navigator.renderPath(
            Location(55.751244, 37.618423),
            Location(55.758163, 37.649529)
        )


    }
}