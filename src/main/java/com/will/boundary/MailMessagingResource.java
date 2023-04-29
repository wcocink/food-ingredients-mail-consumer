package com.will.boundary;

import com.will.controller.MailMessagingController;
import io.quarkus.runtime.StartupEvent;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

@ApplicationScoped
public class MailMessagingResource {

    @Inject
    @Channel("food-ingredients-out")
    Emitter<String> emitter;

    @Inject
    MailMessagingController mailMessagingController;

    void onStart(@Observes StartupEvent ev) {
        emitter.send("Hello");
    }

    /**
     * Consume the message from the "food-ingredients-mail" channel.
     * Messages come from the broker.
     **/
    @Incoming("food-ingredients-in")
    public Uni<Void> sendMail(Message<String> message) {
        return mailMessagingController.sendMail(message);
    }

}
