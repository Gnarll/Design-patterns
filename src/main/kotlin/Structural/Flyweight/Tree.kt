package org.example.Structural.Flyweight

import java.awt.Graphics


class Tree(private val x: Int, private val y: Int, private val treeFlyweight: TreeFlyweight) {


    fun draw(g: Graphics) {
        treeFlyweight.draw(g, x, y)
    }
}