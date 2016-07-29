package edu.csh.chase.messaging.models

import javax.websocket.Session

class Client(val session: Session,
             name: String,
             private val count: Int = 0) {

    val name = name
        get() {
            return if (count == 0) {
                field
            } else {
                "$field($count)"
            }
        }

}