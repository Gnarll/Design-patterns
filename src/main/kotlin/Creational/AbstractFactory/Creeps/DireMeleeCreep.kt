package org.example.Creational.AbstractFactory.Creeps

class DireMeleeCreep : MeleeCreep {
    override val skin: String = "Red melee creep skin"

    override fun attack() {
        println("[LOG] Dire melee creep attacks")
    }

    override fun attackPudge() {
        println("[LOG] Dire melee creep attacks pudge!!!!!!")

    }
}