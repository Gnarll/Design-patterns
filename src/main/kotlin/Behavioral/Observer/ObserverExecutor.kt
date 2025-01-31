package org.example.Behavioral.Observer

import org.example.Behavioral.Observer.Publishers.Post
import org.example.Behavioral.Observer.Publishers.PostPublisher
import org.example.Behavioral.Observer.Subscribers.User
import org.example.PatternExecutor

class ObserverExecutor : PatternExecutor {
    override fun main() {
        val public = PostPublisher()

        val user1 = User("Stalker_killeRR")
        val user2 = User("OgromniiMUZHIK_2012")

        public.subscribe(user1)
        public.subscribe(user2)

        val post1 = Post("Guys, let's go fortnite", "ALOOOOOO let's go ept")
        public.createPost(post1)

        public.unsubscribe(user2)

        val post2 = Post("Guys, let's go BRAWL", "Hotya ne, ZABEITE")
        public.createPost(post2)

    }
}