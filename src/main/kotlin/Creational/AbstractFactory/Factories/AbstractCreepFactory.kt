package org.example.Creational.AbstractFactory.Factories

import org.example.Creational.AbstractFactory.Creeps.MageCreep
import org.example.Creational.AbstractFactory.Creeps.MeleeCreep

interface AbstractCreepFactory {
    fun spawnMeleeCreep(): MeleeCreep
    fun spawnMageCreep(): MageCreep
}

