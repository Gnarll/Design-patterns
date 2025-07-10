package org.example.Behavioral.State


class Player(private val playlist: List<Song>) {

    private var state: PlaybackState = PausedState(this)

    private var isPaused: Boolean = true

    private var currentSong: Song = playlist[0]


    fun changeState(state: PlaybackState) {
        this.state = state
    }

    fun clickPause() {
        state.pause()
    }

    fun clickResume() {
        state.resume()
    }

    fun clickNextSong() {
        state.nextSong()
    }

    fun clickPrevSong() {
        state.prevSong()
    }

    internal fun pause() {
        isPaused = true
        println("${currentSong.name} is paused")
    }

    internal fun resume() {
        isPaused = false
        println("${currentSong.name} is resumed")
    }

    internal fun nextSong() {
        playlist.nextOrFirst(currentSong)?.let {
            currentSong = it
        }
        println("turned on next song ${currentSong.name} by ${currentSong.artist}")
    }

    internal fun prevSong() {
        playlist.prevOrLast(currentSong)?.let {
            currentSong = it
        }
        println("turned on next song ${currentSong.name} by ${currentSong.artist}")
    }
}