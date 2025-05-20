package org.example.Behavioral.ThreadSafeObserver


interface Observer {
    fun onChanged(video: Video)
}

interface Observable {
    fun subscribe(observer: Observer)
    fun unsubscribe(observer: Observer)
    fun notifyAll(video: Video)
}

data class Video(val name: String)

class Blogger() : Observable {
    private val videos: MutableList<Video> = mutableListOf()
    val subscribers: MutableSet<Observer> = mutableSetOf()

    override fun subscribe(observer: Observer) {
        synchronized(subscribers) {
            subscribers.add(observer)
        }

    }

    override fun unsubscribe(observer: Observer) {
        synchronized(subscribers) {
            subscribers.remove(observer)
        }

    }

    override fun notifyAll(video: Video) {
        val subscribersCopy = synchronized(subscribers) {
            subscribers.toList()
        }

        subscribersCopy.forEach {
            it.onChanged(video)
        }

    }

    fun createVideo(video: Video) {
        videos.add(video)
        notifyAll(video)
    }
}