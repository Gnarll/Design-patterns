package org.example.Structural.Flyweight

import org.example.PatternExecutor
import java.awt.BorderLayout
import java.awt.Color
import java.awt.Dimension
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.SwingConstants
import javax.swing.SwingUtilities

class FlyweightExecutor : PatternExecutor {
    override fun main() {
        val gameMaster = GameMaster().apply {
            preferredSize = Dimension(600, 400)
            background = Color.WHITE

            addMouseListener(object : MouseAdapter() {
                override fun mouseClicked(e: MouseEvent) {
                    super.mouseClicked(e)
                    when {
                        SwingUtilities.isLeftMouseButton(e) ->
                            createTree(e.x, e.y, "Birch", Color(34, 139, 34))

                        SwingUtilities.isRightMouseButton(e) ->
                            createTree(e.x, e.y, "Pine", Color(34, 139, 34))

                        SwingUtilities.isMiddleMouseButton(e) ->
                            createTree(e.x, e.y, "Willow", Color(144, 238, 144))
                    }
                }
            })


        }

        // Инструкция для пользователя
        val instruction = JLabel(
            "<html>Click:<br>" +
                    "• Left mouse button — Birch <br>" +
                    "• Right mouse button — Pine<br>" +
                    "• Mid mouse button — Willow</html>",
            SwingConstants.CENTER
        )

        JFrame("Flyweight Forest").apply {
            defaultCloseOperation = JFrame.EXIT_ON_CLOSE
            layout = BorderLayout()
            add(instruction, BorderLayout.NORTH)
            add(gameMaster, BorderLayout.CENTER)
            pack()
            isVisible = true
        }
    }
}