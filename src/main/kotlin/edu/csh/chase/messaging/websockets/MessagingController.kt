package edu.csh.chase.messaging.websockets

import edu.csh.chase.messaging.Demo
import javax.websocket.*

class MessagingController {

    @OnOpen
    fun onOpen(session: Session) {
        Demo.clients.addClient(session)
    }

    @OnMessage
    fun onMessage(session: Session, message: String) {
        Demo.clients.onMessage(message, session)
    }

    @OnMessage
    fun onPong(session: Session, message: PongMessage) {
        Demo.clients.onPong(session)
    }

    @OnClose
    fun onClose(session: Session) {
        Demo.clients.removeClient(session)
    }


}