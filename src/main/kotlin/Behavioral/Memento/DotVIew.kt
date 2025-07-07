package org.example.Behavioral.Memento

import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics
import javax.swing.JPanel

class DotView(private val model: DotModel) : JPanel() {
    init {
        preferredSize = Dimension(400, 400)
        background = Color.WHITE
    }

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        val s = model.state
        g.color = Color.RED
        g.fillOval(s.x - s.width / 2, s.y - s.height / 2, s.width, s.height)
    }
}