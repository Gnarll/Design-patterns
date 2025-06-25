package org.example.Structural.Decorator

import org.example.PatternExecutor

class DecoratorExecutor : PatternExecutor {
    override fun main() {
        var source: Notifier = EmailNotifier()
        source = SMSNotifierDecorator(source)
        source = SlackNotifierDecorator(source)

        source.sendMessage("Hooray I'm keen on Gondolas")
    }
}