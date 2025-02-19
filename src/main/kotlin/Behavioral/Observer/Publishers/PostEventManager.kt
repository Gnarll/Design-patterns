package org.example.Behavioral.Observer.Publishers

import org.example.Behavioral.Observer.Post
import org.example.Behavioral.Observer.Subscribers.PostObserver

enum class EventType {
    CREATE, DELETE
}


// Event manager is a class that stores it's
// subscribers (Observers), adds or deletes them,
// and notifying as well

class PostEventManager() {

    private var subscribers: HashMap<EventType, MutableList<PostObserver>> = HashMap()

    fun subscribe(event: EventType, subscriber: PostObserver) {

        val currentEventSubs = subscribers.get(event)

        if (currentEventSubs.isNullOrEmpty()) {
            val observers = mutableListOf(subscriber)
            subscribers.put(event, observers)
        } else {
            currentEventSubs.add(subscriber)
        }

    }

    fun unsubscribe(event: EventType, subscriber: PostObserver) {
        val currentEventSubs = subscribers.get(event)
        currentEventSubs?.remove(subscriber)
    }

    fun notify(event: EventType, post: Post) {
        val currentEventSubs = subscribers.get(event)
        currentEventSubs?.forEach { it ->
            it.update(event, post)
        }
    }


}

