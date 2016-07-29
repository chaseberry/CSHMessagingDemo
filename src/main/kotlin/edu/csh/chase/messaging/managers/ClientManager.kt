package edu.csh.chase.messaging.managers

import edu.csh.chase.messaging.models.Client
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

}