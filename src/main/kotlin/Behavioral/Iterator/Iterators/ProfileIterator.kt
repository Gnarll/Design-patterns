package org.example.Behavioral.Iterator.Iterators

import org.example.Behavioral.Iterator.Profile


// the main aim of iterator in our exact case is to
// restrict the access to profiles for client code
interface ProfileIterator : Iterator<Profile>

