package org.example.Structural.Flyweight

import java.awt.Color
import java.awt.Graphics
import javax.swing.JPanel


class GameMaster : JPanel() {
    private var trees: MutableList<Tree> = mutableListOf()

    fun createTree(x: Int, y: Int, texture: String, color: Color) {
        val flyweight = TreeFlyweightFactoryImpl.getTreeFlyweight(color, texture)
        trees.add(Tree(x, y, flyweight))
        repaint()
    }

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        trees.forEach {
            it.draw(g)
        }
    }


}