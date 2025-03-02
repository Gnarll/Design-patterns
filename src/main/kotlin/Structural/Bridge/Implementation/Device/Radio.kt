package org.example.Structural.Bridge.Implementation.Device


import org.example.Structural.Bridge.Implementation.Channel.RadioChannel


private val MOCKED_RADIO_CHANNELS: List<RadioChannel> =
    listOf(RadioChannel("Mad FM", 88.0), RadioChannel("Travel FM", 96.4), RadioChannel("Rock FM", 122.2))


class Radio() : Device(MOCKED_RADIO_CHANNELS)