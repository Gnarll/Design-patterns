package org.example.Structural.Bridge.Implementation.Device

import org.example.Structural.Bridge.Implementation.Channel.Channel


abstract class Device(val channels: List<Channel>) {
    private val MAX_VOLUME: Int = 100
    private val MIN_VOLUME: Int = 0

    var volume = MAX_VOLUME
        set(value) {
            field = when {
                value < MIN_VOLUME -> MIN_VOLUME
                value > MAX_VOLUME -> MAX_VOLUME
                else -> value
            }
        }

    var volumeBeforeMute = MAX_VOLUME

    var channel: Channel = channels.first()

    fun switchChannel(channel: Channel) {
        this.channel = channel
    }


}

