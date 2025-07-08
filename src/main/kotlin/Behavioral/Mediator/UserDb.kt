package org.example.Behavioral.Mediator

interface UserDatabase {
    fun insertUser(user: User): Boolean
    fun checkForUser(user: User): Boolean
}

class UserDatabaseImpl(
    private val users: MutableList<User> = mutableListOf(
        User(login = "Eugene Blanov", password = "e.blanov1977"),
        User(login = "Pierre Dunn", password = "pierre!1000"),
        User(login = "Isaac Mycock", password = "12345")
    )
) : UserDatabase {
    override fun insertUser(user: User): Boolean {
        if (!users.contains(user)) {
            users.add(user)
            return true
        }
        return false
    }

    override fun checkForUser(user: User): Boolean {
        return users.contains(user)
    }
}