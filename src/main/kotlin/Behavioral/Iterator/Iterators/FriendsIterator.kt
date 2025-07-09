package org.example.Behavioral.Iterator.Iterators

import org.example.Behavioral.Iterator.Profile
import org.example.Behavioral.Iterator.ProfileType
import org.example.Behavioral.Iterator.SocialNetwork

class FriendsProfileIterator(private val network: SocialNetwork, private val forId: Int) : ProfileIterator {

    private var state: List<Profile>? = null
    private var currentPosition: Int = 0

    override fun hasNext(): Boolean {
        lazyLoadState()
        return currentPosition < (state?.size ?: 0)
    }

    override fun next(): Profile {
        return if (hasNext())
            state?.get(currentPosition++) ?: throw NoSuchElementException()
        else throw NoSuchElementException()
    }

    private fun lazyLoadState() {
        state = state ?: network.getProfilesGraph(forId = forId, type = ProfileType.FRIENDS)
    }
}