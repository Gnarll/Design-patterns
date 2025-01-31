package org.example.Behavioral.Observer.Subscribers

import org.example.Behavioral.Observer.Publishers.Post

class User(var nickname: String) : PostObserver {

    override fun update(post: Post) {
        println("${nickname} was notified about ${post}")
    }
}