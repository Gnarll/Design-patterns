package org.example.Behavioral.State

import org.example.PatternExecutor


class StateExecutor : PatternExecutor {
    override fun main() {
        val playlist = listOf(
            Song("Nu gde moya noga", "Perega Sirat"),
            Song("Mitino-Mitino", "Honey mad"),
            Song("Zdravstvui Marianna Kiss", "Honey mad")
        )

        val player = Player(playlist = playlist)

        player.clickResume()
        player.clickNextSong()
        player.clickNextSong()
        player.clickNextSong()
        player.clickPause()
        player.clickResume()
        player.clickPrevSong()
        player.clickPause()

    }
}