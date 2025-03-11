package org.example.Structural.Composite.Shapes

import java.awt.Color
import java.awt.Graphics

// this class is inherited from BaseShape,
// and it can include in its list BaseShapes and either
// other CompoundShapes making a tree structure
class CompoundShape : BaseShape {
    private val children: MutableList<BaseShape> = mutableListOf()

    constructor(shapes: List<BaseShape>) : super(0, 0, Color.BLACK) {
        add(shapes)
    }

    fun add(shape: BaseShape) {
        children.add(shape)
    }

    fun add(shapes: List<BaseShape>) {
        children.addAll(shapes)
    }

    fun remove(shape: BaseShape) {
        children.remove(shape)
    }

    fun remove(shapes: List<BaseShape>) {
        children.removeAll(shapes)
    }

    fun clear() {
        children.clear()
    }

    override val getX: () -> Int = {
        if (children.isEmpty()) 0
        else children.minOf { it.getX() }
    }

    override val getY: () -> Int = {
        if (children.isEmpty()) 0
        else children.minOf { it.getY() }
    }

    override fun getWidth(): Int {
        var maxWidth = 0

        children.forEach { child ->
            val childRelativeX = child.getX() - this.getX()
            val childWidth = childRelativeX + child.getWidth()
            if (childWidth > maxWidth) {
                maxWidth = childWidth;
            }
        }

        return maxWidth
    }

    override fun getHeight(): Int {
        var maxHeight = 0

        children.forEach { child ->
            val childRelativeY = child.getY() - this.getY()
            val childHeight = childRelativeY + child.getHeight()
            if (childHeight > maxHeight) {
                maxHeight = childHeight;
            }
        }

        return maxHeight
    }

    override fun unselect() {
        super.unselect()
        children.forEach { child ->
            child.unselect()
        }
    }


    override fun isInsideBounds(x: Int, y: Int): Boolean {
        for (child in children) {
            if (child.isInsideBounds(x, y)) {
                return true
            }
        }
        return false
    }

    fun selectChildAt(x: Int, y: Int) {
        for (child in children) {
            if (child.isInsideBounds(x, y)) {
                child.select()
            }
        }
    }

    override fun paint(graphics: Graphics) {
        if (isSelected) {
            enableSelectionStyle(graphics)
            graphics.drawRect(getX() - 1, getY() - 1, getWidth() + 1, getHeight() + 1)
            disableSelectionStyle(graphics)
        }

        for (child in children) {
            child.paint(graphics)
        }
    }

}