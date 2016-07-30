package edu.csh.chase.messaging

import be.tomcools.dropwizard.websocket.WebsocketBundle
import edu.csh.chase.messaging.config.MessagingConfig
import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

class MessagingApp : Application<MessagingConfig>() {

    val websocket = WebsocketBundle()

    override fun initialize(bootstrap: Bootstrap<MessagingConfig>) {
        super.initialize(bootstrap)

        bootstrap.addBundle(websocket)
    }

    override fun run(config: MessagingConfig, env: Environment) {
        Demo.config = config



    }
}