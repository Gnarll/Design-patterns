package org.example.Behavioral.Observer

import org.example.Behavioral.Observer.Publishers.EventType
import org.example.Behavioral.Observer.Publishers.PostPublisher
import org.example.Behavioral.Observer.Subscribers.User
import org.example.PatternExecutor

class ObserverExecutor : PatternExecutor {
    override fun main() {

        val public = PostPublisher()

        val user1 = User("Stalker_killeRR")
        val user2 = User("OgromniiMUZHIK_2012")

        public.eventManager.subscribe(EventType.CREATE, user1)
        public.eventManager.subscribe(EventType.CREATE, user2)

        val post1 = Post("Guys, let's go fortnite", "ALOOOOOO let's go ept")
        public.createPost(post1)

        public.eventManager.unsubscribe(EventType.CREATE, user2)

        val post2 = Post("Guys, let's go BRAWL", "Hotya ne, ZABEITE")
        public.createPost(post2)

    }
}