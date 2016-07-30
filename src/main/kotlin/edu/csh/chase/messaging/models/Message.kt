package edu.csh.chase.messaging.models

import edu.csh.chase.kjson.Json
import edu.csh.chase.kjson.JsonSerializable
import edu.csh.chase.messaging.Demo
import edu.csh.chase.messaging.utils.timestamp
import java.util.*

open class Message(val sender: String, val message: String, val room: String, val time: Date = Date()) : JsonSerializable {

    val id = Demo.ids.next()

    override fun jsonSerialize(): String {
        return Json(
                "id" to id,
                "name" to sender,
                "message" to message,
                "room" to room,
                "time" to time.timestamp
        ).toString()
    }
}