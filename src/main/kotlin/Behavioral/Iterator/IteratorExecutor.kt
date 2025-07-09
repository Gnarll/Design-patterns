package org.example.Behavioral.Iterator

import org.example.PatternExecutor

class IteratorExecutor : PatternExecutor {
    override fun main() {
        val facebook = Facebook()

        val alice = Profile(1, "Alice", "alice@mail.com")
        val bob = Profile(2, "Bob", "bob@mail.com")
        val charlie = Profile(3, "Charlie", "charlie@mail.com")
        val dave = Profile(4, "Dave", "dave@mail.com")

        listOf(alice, bob, charlie, dave).forEach { facebook.addProfile(it) }

        facebook.setFriendConnection(1, 2)
        facebook.setColleagueConnection(1, 3)

        facebook.setColleagueConnection(1, 4)

        val spammer = Spammer()

        spammer.send(facebook.createFriendsIterator(1), "Hi friend!")

        spammer.send(facebook.createColleaguesIterator(1), "Hi colleague!")
    }
}