package org.example.Creational.AbstractFactory.Factories

import org.example.Creational.AbstractFactory.Creeps.DireMageCreep
import org.example.Creational.AbstractFactory.Creeps.DireMeleeCreep
import org.example.Creational.AbstractFactory.Creeps.MageCreep
import org.example.Creational.AbstractFactory.Creeps.MeleeCreep

class DireCreepFactory : AbstractCreepFactory {
    override fun spawnMeleeCreep(): MeleeCreep = DireMeleeCreep()

    override fun spawnMageCreep(): MageCreep = DireMageCreep()

}