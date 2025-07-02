package org.example.Behavioral.Command

import org.example.PatternExecutor


// not a good example because of using
// libs, which support the desired behavior
// out of the box
class CommandExecutor : PatternExecutor {
    override fun main() {
        Application().apply {
            createUi()
        }
    }
}


