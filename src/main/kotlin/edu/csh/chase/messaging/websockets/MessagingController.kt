package edu.csh.chase.messaging.websockets

import javax.websocket.*

class MessagingController {

    @OnOpen
    fun onOpen(session: Session) {

    }

    @OnMessage
    fun onMessage(session: Session, message: String) {

    }

    @OnMessage
    fun onPong(session: Session, message: PongMessage) {

    }

    @OnClose
    fun onClose(session: Session) {

    }


}