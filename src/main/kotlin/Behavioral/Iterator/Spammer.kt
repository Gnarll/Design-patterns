package org.example.Behavioral.Iterator

import org.example.Behavioral.Iterator.Iterators.ProfileIterator

class Spammer {
    fun send(iterator: ProfileIterator, message: String) {
        while (iterator.hasNext()) {
            iterator.next().apply {
                messages.add(message)
                println("$name got message: $message")
            }
        }
    }
}