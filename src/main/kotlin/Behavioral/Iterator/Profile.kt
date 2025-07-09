package org.example.Behavioral.Iterator


data class Profile(val id: Int, val name: String, val email: String) {
    val messages: MutableList<String> = mutableListOf()
}
