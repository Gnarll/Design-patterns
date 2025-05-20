package org.example.Behavioral.ThreadSafeObserver

class Subscriber(val name: String) : Observer {
    override fun onChanged(video: Video) {
        println("$name is watching video: '${video.name}'")
    }
}