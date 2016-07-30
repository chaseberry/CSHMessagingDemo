package edu.csh.chase.messaging

import edu.csh.chase.messaging.config.MessagingConfig
import edu.csh.chase.messaging.interfaces.MessageManager
import edu.csh.chase.messaging.managers.ClientManager
import edu.csh.chase.messaging.managers.MessageManagerImpl
import edu.csh.chase.messaging.utils.IdGenerator


object Demo {

    val ids: IdGenerator by lazy {
        IdGenerator()
    }

    lateinit var config: MessagingConfig

    val clients: ClientManager by lazy {
        ClientManager()
    }

    val messages: MessageManager by lazy {
        MessageManagerImpl()
    }

}