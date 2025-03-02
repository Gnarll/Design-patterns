package org.example.Structural.Bridge.Implementation.Channel

class RadioChannel(name: String, private val frequency: Double) : Channel(name) {
    fun getFrequency(): String {
        return "$frequency Hz"
    }
}