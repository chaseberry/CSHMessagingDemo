package edu.csh.chase.messaging.utils

class IdGenerator {

    private var count = 0

    fun next(): Int {
        return count++
    }

}