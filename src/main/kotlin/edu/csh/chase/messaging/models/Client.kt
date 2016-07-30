package edu.csh.chase.messaging.models

import edu.csh.chase.kjson.Json
import edu.csh.chase.kjson.JsonObject
import edu.csh.chase.messaging.Demo
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

    fun onMessage(message: String) {
        val obj = Json.parseToObject(message) ?: return

        val txt = obj.getString("message") ?: return
        val room = obj.getString("room") ?: return

        Demo.messages.postMessage(this, txt, room)
    }

    fun onPong() {

    }

    fun send(message: Message) {
        session.asyncRemote.sendText(message.jsonSerialize())
    }

}