package org.example.Behavioral.State


internal fun <E> List<E>.nextOrFirst(element: E): E? {
    if (this.isEmpty()) {
        return null
    }

    val elementIndex = this.indexOf(element).apply {
        if (this == -1)
            return null
    }

    if (this.size > elementIndex + 1) {
        return this[elementIndex + 1]
    }

    return this[0]
}

internal fun <E> List<E>.prevOrLast(element: E): E? {
    if (this.isEmpty()) {
        return null
    }

    val elementIndex = this.indexOf(element).apply {
        if (this == -1)
            return null
    }

    if (elementIndex == 0) {
        return this.last()
    }

    return this[elementIndex - 1]
}

