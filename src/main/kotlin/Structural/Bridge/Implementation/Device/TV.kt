package org.example.Structural.Bridge.Implementation.Device

import org.example.Structural.Bridge.Implementation.Channel.TVChannel


private val MOCKED_TV_CHANNELS: List<TVChannel> = listOf(TVChannel("Discovery", 1), TVChannel("National Geographic", 2))

class TV : Device(MOCKED_TV_CHANNELS)