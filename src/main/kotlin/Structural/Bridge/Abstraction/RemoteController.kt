package org.example.Structural.Bridge.Abstraction

import org.example.Structural.Bridge.Implementation.Device.Device

class RemoteController(protected val device: Device) {
    fun increaseVolume() {
        device.volume += 10
        println("Volume is ${device.volume}")
    }

    fun decreaseVolume() {
        device.volume -= 10
        println("Volume is ${device.volume}")
    }

    fun mute() {
        if (device.volume != 0) {
            device.volumeBeforeMute = device.volume
            device.volume = 0
        }
        println("Volume is ${device.volume}")
    }

    fun unmute() {
        if (device.volume == 0)
            device.volume = device.volumeBeforeMute
        println("Volume is ${device.volume}")
    }

    fun nextChannel() {
        val nextChannel = device.channels.getOrNull(device.channels.indexOf(device.channel) + 1)
        device.switchChannel(nextChannel ?: device.channels.first())
        println("Current channel is ${device.channel.name}")
    }

    fun prevChannel() {
        val prevChannel = device.channels.getOrNull(device.channels.indexOf(device.channel) - 1)
        device.switchChannel(prevChannel ?: device.channels.first())
        println("Current channel is ${device.channel.name}")
    }
}
