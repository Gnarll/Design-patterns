package org.example.Behavioral.Strategy

// Navigator uses different strategies without knowing their details
class Navigator(private var navigationStrategy: NavigationStrategy) {
    fun changeNavigationStrategy(strategy: NavigationStrategy) {
        navigationStrategy = strategy
    }

    // just a simple print
    fun renderPath(locationA: Location, locationB: Location) {
        val path: List<Location> = navigationStrategy.buildRoute(
            locationA,
            locationB
        )
        path.forEach {
            print("$it -> ")
        }
        print("end.")
        println()
    }
}