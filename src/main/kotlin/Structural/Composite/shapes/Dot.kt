package org.example.Structural.Composite.Shapes

import java.awt.Color
import java.awt.Graphics

class Dot(x: Int, y: Int, color: Color) : BaseShape(x, y, color) {
    companion object {
        const val SIZE = 3
    }

    override fun getWidth(): Int {
        return SIZE
    }

    override fun getHeight(): Int {
        return SIZE
    }

    override fun paint(graphics: Graphics) {
        super.paint(graphics)
        graphics.fillRect(getX() - 1, getY() - 1, getWidth(), getHeight())
    }
}