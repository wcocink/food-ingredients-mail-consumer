package com.will.controller;

import com.will.entity.User;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Message;

@ApplicationScoped
public class MailMessagingController {

    @Inject
    Mailer mailer;

    public void sendMail(Message<String> message){
        Mail mail = new Mail();
        mail.addHeader("");
        mail.addTo();
        mailer.send(mail);
    }

}
