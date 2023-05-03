package com.will.boundary;

import com.will.controller.MailMessagingController;
import com.will.entity.Mail;
import io.smallrye.common.annotation.NonBlocking;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Acknowledgment;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import java.util.List;

@ApplicationScoped
public class MailMessagingResource {

    @Inject
    @Channel("food-ingredients-out")
    Emitter<List<Mail>> emitter;

    @Inject
    MailMessagingController mailMessagingController;

    //void onStart(@Observes StartupEvent ev) {
    //    emitter.send("Hello");
    //}

    /**
     * Consume the message from the "food-ingredients-mail" channel.
     * Messages come from the broker.
     **/
    @Incoming("food-ingredients-in")
    @Acknowledgment(Acknowledgment.Strategy.PRE_PROCESSING)
    @NonBlocking
    public Uni<Void> sendMail(Mail message) {
        return mailMessagingController.sendMail(message);
    }

}
