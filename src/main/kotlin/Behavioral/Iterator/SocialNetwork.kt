package org.example.Behavioral.Iterator

import org.example.Behavioral.Iterator.Iterators.ColleaguesProfileIterator
import org.example.Behavioral.Iterator.Iterators.FriendsProfileIterator
import org.example.Behavioral.Iterator.Iterators.ProfileIterator


// this is the analogy of Kotlin Iterable interface
// (the difference is hard coded type and two different iterators instead of one)
// this approach says that SocialNetwork is a collection
// manipulating profiles
interface SocialNetwork {
    fun createFriendsIterator(forId: Int): ProfileIterator
    fun createColleaguesIterator(forId: Int): ProfileIterator

    fun getProfilesGraph(forId: Int, type: ProfileType): List<Profile>
}


enum class ProfileType {
    COLLEAGUES,
    FRIENDS
}


class Facebook : SocialNetwork {
    private val profiles: MutableMap<Int, Profile> = mutableMapOf()
    private val friendsOfProfile: MutableMap<Int, List<Int>> = mutableMapOf()
    private val colleaguesOfProfile: MutableMap<Int, List<Int>> = mutableMapOf()

    override fun createFriendsIterator(forId: Int): ProfileIterator {
        return FriendsProfileIterator(network = this, forId = forId)
    }

    override fun createColleaguesIterator(forId: Int): ProfileIterator {
        return ColleaguesProfileIterator(network = this, forId = forId)
    }

    fun addProfile(profile: Profile): Boolean {
        profiles[profile.id]?.let {
            return false
        }
        profiles[profile.id] = profile
        return true
    }

    fun setFriendConnection(forId: Int, id: Int) {
        friendsOfProfile[forId] = (friendsOfProfile.getOrDefault(forId, emptyList()) + id)
    }

    fun setColleagueConnection(forId: Int, id: Int) {
        colleaguesOfProfile[forId] = (colleaguesOfProfile.getOrDefault(forId, emptyList()) + id)
    }

    override fun getProfilesGraph(forId: Int, type: ProfileType): List<Profile> {
        val profileIds = when (type) {
            ProfileType.FRIENDS -> {
                friendsOfProfile[forId]
            }

            ProfileType.COLLEAGUES -> {
                colleaguesOfProfile[forId]
            }
        } ?: return emptyList()
        return profileIds.mapNotNull {
            profiles[it]
        }
    }
}