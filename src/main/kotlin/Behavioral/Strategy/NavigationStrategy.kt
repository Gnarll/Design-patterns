package org.example.Behavioral.Strategy

interface NavigationStrategy {
    fun buildRoute(locationA: Location, locationB: Location): List<Location>
}

//
object WalkingNavStrategy : NavigationStrategy {
    override fun buildRoute(locationA: Location, locationB: Location): List<Location> {
        // finding the path by low-level modules for walking
        return listOf(
            Location(55.751244, 37.618423),
            Location(55.752831, 37.621745),
            Location(55.754492, 37.625678),
            Location(55.755983, 37.633214),
            Location(55.757241, 37.641587),
            Location(55.758163, 37.649529),
        )
    }
}

object BusNavStrategy : NavigationStrategy {
    override fun buildRoute(locationA: Location, locationB: Location): List<Location> {
        // finding the path by low-level modules for the bus
        return listOf(
            Location(55.751244, 37.618423),
            Location(55.752512, 37.622314),
            Location(55.754123, 37.630456),
            Location(55.756782, 37.642345),
            Location(55.758163, 37.649529)
        )
    }
}

object CarNavStrategy : NavigationStrategy {
    override fun buildRoute(locationA: Location, locationB: Location): List<Location> {
        // finding the path by low-level modules for the car
        return listOf(
            Location(55.751244, 37.618423),
            Location(55.751876, 37.620145),
            Location(55.753421, 37.627834),
            Location(55.756124, 37.639872),
            Location(55.758163, 37.649529)
        )
    }
}