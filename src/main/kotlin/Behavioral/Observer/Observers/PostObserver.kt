package org.example.Behavioral.Observer.Subscribers

import org.example.Behavioral.Observer.Publishers.Post

interface PostObserver {
    fun update(post: Post) // type of post doesn't have to be the entire Post, usually it's an event
    // that consists of necessary information for Observer, that he works with
}