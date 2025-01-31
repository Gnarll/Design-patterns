package org.example.Behavioral.Observer.Publishers

import org.example.Behavioral.Observer.Subscribers.PostObserver


// This class should be abstract in case of
// possibility of many kinds of published data
// but here it's not so important for pattern understanding

data class Post(var title: String, var content: String) {

}


// Publisher is a class that stores it's
// subscribers (Observers), adds or deletes them,
// and notifying about his updates as well

class PostPublisher() {

    private var posts: MutableList<Post> = mutableListOf()

    private var subscribers: MutableList<PostObserver> = mutableListOf()

    fun subscribe(subscriber: PostObserver) {
        subscribers.add(subscriber)
    }

    fun unsubscribe(subscriber: PostObserver) {
        subscribers.remove(subscriber)
    }

    fun notifyAllSubs(post: Post) { // can accept event instead of Post
        subscribers.forEach { it ->
            it.update(post)
        }
    }

    fun createPost(post: Post) {
        posts.add(post)
        notifyAllSubs(post)
    }

}

