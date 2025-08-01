package org.example.Structural.Composite.Shapes

import java.awt.Color
import java.awt.Graphics

class Rectangle(x: Int, y: Int, private val width: Int, private val height: Int, color: Color) :
    BaseShape(x, y, color) {
    override fun getWidth(): Int {
        return width
    }

    override fun getHeight(): Int {
        return height
    }

    override fun paint(graphics: Graphics) {
        super.paint(graphics)
        graphics.drawRect(getX(), getY(), width - 1, height - 1)
    }
}