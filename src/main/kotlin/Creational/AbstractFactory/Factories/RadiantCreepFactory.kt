package org.example.Creational.AbstractFactory.Factories

import org.example.Creational.AbstractFactory.Creeps.MageCreep
import org.example.Creational.AbstractFactory.Creeps.MeleeCreep
import org.example.Creational.AbstractFactory.Creeps.RadiantMageCreep
import org.example.Creational.AbstractFactory.Creeps.RadiantMeleeCreep


class RadiantCreepFactory : AbstractCreepFactory {
    override fun spawnMeleeCreep(): MeleeCreep = RadiantMeleeCreep()

    override fun spawnMageCreep(): MageCreep = RadiantMageCreep()

}