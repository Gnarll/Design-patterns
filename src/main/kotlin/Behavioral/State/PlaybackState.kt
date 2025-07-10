package org.example.Behavioral.State

abstract class PlaybackState(protected val context: Player) {
    internal abstract fun pause()
    internal abstract fun resume()
    internal abstract fun nextSong()
    internal abstract fun prevSong()
}

class PlayingState(context: Player) : PlaybackState(context) {
    override fun pause() {
        context.pause()
        context.changeState(PausedState(context = context))
    }

    override fun resume() {
    }

    override fun nextSong() {
        context.nextSong()
    }

    override fun prevSong() {
        context.prevSong()
    }
}

class PausedState(context: Player) : PlaybackState(context) {
    override fun pause() {
    }

    override fun resume() {
        context.resume()
        context.changeState(PlayingState(context = context))
    }

    override fun nextSong() {
        context.nextSong()
    }

    override fun prevSong() {
        context.prevSong()
    }
}