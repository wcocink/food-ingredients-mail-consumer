package com.will.boundary;

import com.will.controller.MailMessagingController;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.*;

@ApplicationScoped
public class MailMessagingResource {

    @Inject
    @Channel("food-ingredients")
    Emitter<String> emitter;

    @Inject
    MailMessagingController mailMessagingController;

    /**
     * Consume the message from the "send-mail" channel, uppercase it and send it to the uppercase channel.
     * Messages come from the broker.
     **/
    @Incoming("send-mail")
    public void sendMail(Message<String> message) {
        mailMessagingController.sendMail(message);
    }

    /**
     * Consume the uppercase channel (in-memory) and print the messages.
     **/
    @Incoming("uppercase")
    public void sink(String word) {
        System.out.println(">> " + word);
    }

}
