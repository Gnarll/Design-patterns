package org.example.Structural.Decorator

interface Notifier {
    fun sendMessage(message: String)
}

// old class that we want to use as a wrapped source actor
class EmailNotifier() : Notifier {
    override fun sendMessage(message: String) {
        println("`$message` was sent to email")
    }
}