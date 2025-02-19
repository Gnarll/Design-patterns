package org.example.Behavioral.Observer.Publishers

import org.example.Behavioral.Observer.Post


class PostPublisher(val eventManager: PostEventManager = PostEventManager()) {

    private var posts: MutableList<Post> = mutableListOf()

    fun createPost(post: Post) {
        posts.add(post)
        eventManager.notify(EventType.CREATE, post)
    }

    fun deletePost(post: Post) {
        posts.remove(post)
        eventManager.notify(EventType.DELETE, post)
    }
}