package org.example.Structural.Flyweight

import java.awt.Color
import java.awt.Graphics

// we assume that color and texture are expensive resources and
// try to minimize the unique set of them
class TreeFlyweight(val color: Color, val texture: String) {
    fun draw(g: Graphics, x: Int, y: Int) {
        g.color = color
        g.fillOval(x - 5, y - 10, 10, 20)
        g.color = Color.BLACK
        g.drawString(texture, x - 10, y + 15)
    }
}


interface TreeFlyweightFactory {
    fun getTreeFlyweight(color: Color, texture: String): TreeFlyweight
}

object TreeFlyweightFactoryImpl : TreeFlyweightFactory {
    private val flyweights: MutableList<TreeFlyweight> = mutableListOf()

    override fun getTreeFlyweight(color: Color, texture: String): TreeFlyweight =
        flyweights.find { it.color == color && it.texture == texture } ?: TreeFlyweight(
            color = color,
            texture = texture
        )
}
