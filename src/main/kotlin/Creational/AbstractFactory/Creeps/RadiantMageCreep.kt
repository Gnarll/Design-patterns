package org.example.Creational.AbstractFactory.Creeps

class RadiantMageCreep : MageCreep {
    override val manaPoints: Int = 101
    override val skin: String = "Green mage creep skin"

    override fun attack() {
        println("[LOG] Radiant mage creep attacks from a distance")
    }
}