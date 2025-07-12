package org.example.Creational.AbstractFactory

import org.example.Creational.AbstractFactory.Creeps.Creep
import org.example.Creational.AbstractFactory.Creeps.MeleeCreep
import org.example.Creational.AbstractFactory.Factories.AbstractCreepFactory
import org.example.Creational.AbstractFactory.Factories.DireCreepFactory
import org.example.PatternExecutor
import kotlin.random.Random

class AbstractFactoryExecutor : PatternExecutor {

    private fun spawnCreepGang(creepFactory: AbstractCreepFactory): List<Creep> = listOf(
        creepFactory.spawnMeleeCreep(),
        creepFactory.spawnMeleeCreep(),
        creepFactory.spawnMeleeCreep(),
        creepFactory.spawnMeleeCreep(),
        creepFactory.spawnMageCreep()
    )

    private fun attack(creeps: List<Creep>) {
        creeps.forEach {
            it.attack()
            if (it is MeleeCreep && Random.nextInt(10) > 7) {
                println("HOTYAAA NET EPTAAA")
                it.attackPudge()
            }
        }
    }


    override fun main() {
        val direCreeps = spawnCreepGang(DireCreepFactory())

        attack(direCreeps)
    }
}