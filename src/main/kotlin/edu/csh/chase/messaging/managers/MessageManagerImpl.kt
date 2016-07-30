package edu.csh.chase.messaging.managers

import edu.csh.chase.messaging.Demo
import edu.csh.chase.messaging.interfaces.MessageManager
import edu.csh.chase.messaging.models.Client
import edu.csh.chase.messaging.models.Message
import edu.csh.chase.messaging.models.ServerMessage
import java.util.*

class MessageManagerImpl : MessageManager {

    val messages = HashMap<String, ArrayList<Message>>()

    init {
        messages["chat"] = ArrayList()
    }

    override fun createRoom(creator: Client, name: String) {
        if (name in messages) {
            creator.send(ServerMessage("$name is already a room."))
            return
        }
        messages[name] = ArrayList()
    }

    override fun removeRoom(remover: Client, name: String) {
        if (name !in messages) {
            remover.send(ServerMessage("$name is not a room."))
            return
        }
        messages.remove(name)
    }

    override fun postMessage(sender: Client, message: String, room: String) {
        val msg = Message(sender.name, message, room)
        if (room !in messages) {
            sender.send(ServerMessage("$room is not a room."))
            return
        }
        messages[room]!!.add(msg)
        Demo.clients.notifyNewMessage(msg)
    }


}