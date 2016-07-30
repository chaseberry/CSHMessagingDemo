package edu.csh.chase.messaging.managers

import edu.csh.chase.messaging.models.Client
import edu.csh.chase.messaging.models.Message
import java.util.*
import javax.websocket.CloseReason
import javax.websocket.Session

class ClientManager {

    val clients = ArrayList<Client>()

    fun addClient(session: Session) {
        val name = session.requestParameterMap["name"]?.first()

        if (name == null) {
            session.close(CloseReason(CloseReason.CloseCodes.VIOLATED_POLICY, "no name provided."))
            return
        }

        val count = clients.filter { it.name == name }.size
        val client = Client(session, name, count)
        clients.add(client)
    }

    fun removeClient(session: Session) {
        clients.removeIf { it.session == session }
    }

    fun onMessage(message: String, session: Session) {
        clients.find { it.session == session }?.onMessage(message)
    }

    fun onPong(session: Session) {
        clients.find { it.session == session }?.onPong()
    }

    fun notifyNewMessage(msg: Message) {
        clients.forEach { it.send(msg) }
    }

}