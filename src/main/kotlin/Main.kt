package org.example

import org.example.Behavioral.Command.CommandExecutor
 
fun main() {
    val commandExecutor: PatternExecutor = CommandExecutor()
    commandExecutor.main()
}