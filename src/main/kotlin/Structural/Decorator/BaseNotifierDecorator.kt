package org.example.Structural.Decorator

// the main idea of pattern is the same interface implementation
// by Decorator as the origin wrapped object
abstract class BaseNotifierDecorator(protected val wrapped: Notifier) : Notifier {
    override fun sendMessage(message: String) {
        wrapped.sendMessage(message)
    }
}

class SMSNotifierDecorator(wrapped: Notifier) : BaseNotifierDecorator(wrapped = wrapped) {
    override fun sendMessage(message: String) {
        super.sendMessage(message)
        println("`$message` was sent as SMS")
    }
}

class SlackNotifierDecorator(wrapped: Notifier) : BaseNotifierDecorator(wrapped = wrapped) {
    override fun sendMessage(message: String) {
        super.sendMessage(message)
        println("`$message` was sent by Slack")
    }
}