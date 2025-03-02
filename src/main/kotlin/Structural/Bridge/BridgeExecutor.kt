package org.example.Structural.Bridge

import org.example.PatternExecutor
import org.example.Structural.Bridge.Abstraction.RemoteController
import org.example.Structural.Bridge.Implementation.Device.TV

class BridgeExecutor : PatternExecutor {
    override fun main() {
        val myTV = TV()
        val controller = RemoteController(myTV)

        controller.decreaseVolume()
        controller.decreaseVolume()
        controller.decreaseVolume()
        controller.decreaseVolume()
        controller.decreaseVolume()
        controller.decreaseVolume()
        controller.decreaseVolume()
        controller.decreaseVolume()
        controller.decreaseVolume()
        controller.decreaseVolume()
        controller.decreaseVolume()
        controller.decreaseVolume()
        controller.decreaseVolume()
        controller.decreaseVolume()

        controller.mute()
        controller.unmute()
        controller.increaseVolume()
        controller.increaseVolume()
        controller.increaseVolume()
        controller.unmute()

        controller.nextChannel()
        controller.nextChannel()
        controller.nextChannel()

        controller.prevChannel()
    }
}