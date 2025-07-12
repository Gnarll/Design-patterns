package org.example.Creational.AbstractFactory.Creeps

class DireMageCreep : MageCreep {
    override val manaPoints: Int = 100
    override val skin: String = "Red mage creep skin"

    override fun attack() {
        println("[LOG] Dire mage creep attacks from a distance")
    }
}