package org.example.Behavioral.Memento

import DotController
import org.example.PatternExecutor
import javax.swing.SwingUtilities

class MementoExecutor : PatternExecutor {
    override fun main() {
        SwingUtilities.invokeLater {
            DotController()
        }
    }
}