package org.example.Creational.AbstractFactory.Creeps

class RadiantMeleeCreep : MeleeCreep {
    override val skin: String = "Green melee creep skin"

    override fun attackPudge() {
        println("[LOG] Radiant melee creep attacks pudge!!!!!!")
    }

    override fun attack() {
        println("[LOG] Radiant melee creep attacks")
    }
}