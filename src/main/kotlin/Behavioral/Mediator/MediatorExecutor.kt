package org.example.Behavioral.Mediator

import org.example.PatternExecutor
import javax.swing.SwingUtilities

class MediatorExecutor : PatternExecutor {
    override fun main() {
        SwingUtilities.invokeLater {
            AuthDialog()
        }
    }
}