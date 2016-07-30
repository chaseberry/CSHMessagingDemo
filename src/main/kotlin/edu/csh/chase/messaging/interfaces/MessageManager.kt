package edu.csh.chase.messaging.interfaces

import edu.csh.chase.messaging.models.Client

interface MessageManager {

    fun createRoom(creator: Client, name: String)

    fun removeRoom(remover: Client, name: String)

    fun postMessage(sender: Client, message: String, room:String)

}