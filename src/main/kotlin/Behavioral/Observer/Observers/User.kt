package org.example.Behavioral.Observer.Subscribers

import org.example.Behavioral.Observer.Publishers.EventType
import org.example.Behavioral.Observer.Post

data class User(var nickname: String) : PostObserver {
    override fun update(event: EventType, post: Post) {
        println("$this got event $event about the post $post")
    }
}