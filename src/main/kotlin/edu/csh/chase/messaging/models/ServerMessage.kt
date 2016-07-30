package edu.csh.chase.messaging.models

import java.util.*

class ServerMessage(message: String) : Message("server", message, "private") {
}