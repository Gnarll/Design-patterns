package org.example.Behavioral.Observer.Subscribers

import org.example.Behavioral.Observer.Publishers.EventType
import org.example.Behavioral.Observer.Post

interface PostObserver {
    fun update(event: EventType, post: Post)
}