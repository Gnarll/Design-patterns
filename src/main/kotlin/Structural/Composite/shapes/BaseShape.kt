package org.example.Structural.Composite.Shapes

import java.awt.BasicStroke
import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D


abstract class BaseShape(private var x: Int, private var y: Int, var color: Color) {

    open val getX: () -> Int = { x }
    open val getY: () -> Int = { y }

    open fun move(x: Int, y: Int) {
        this.x += x
        this.y += y
    }

    var isSelected: Boolean = false

    fun select() {
        isSelected = true
    }

    open fun unselect() {
        isSelected = false
    }

    open fun getWidth(): Int {
        return 0
    }

    open fun getHeight(): Int {
        return 0
    }

    open fun isInsideBounds(x: Int, y: Int): Boolean {
        return when {
            x > this.x && x < this.x + getWidth() && y > this.y && y < this.y + getHeight() -> true
            else -> false
        }
    }


    open fun paint(graphics: Graphics) {
        when {
            isSelected -> enableSelectionStyle(graphics)
            else -> disableSelectionStyle(graphics)
        }
    }

    protected fun enableSelectionStyle(graphics: Graphics) {
        graphics.color = Color.LIGHT_GRAY

        val g2 = graphics as Graphics2D
        val dash1 = floatArrayOf(2.0f)
        g2.stroke = BasicStroke(
            1.0f,
            BasicStroke.CAP_BUTT,
            BasicStroke.JOIN_MITER,
            2.0f, dash1, 0.0f
        )
    }

    protected fun disableSelectionStyle(graphics: Graphics) {
        graphics.color = color
        val g2 = graphics as Graphics2D
        g2.stroke = BasicStroke()
    }
}