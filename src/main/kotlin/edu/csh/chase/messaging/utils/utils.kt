package edu.csh.chase.messaging.utils

import java.util.*

val Date.timestamp: Int
    get() = (this.time / 1000L).toInt()