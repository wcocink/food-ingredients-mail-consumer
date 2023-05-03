package com.will.controller;

import com.will.entity.UserMessage;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.reactive.ReactiveMailer;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.stream.Collectors;

@ApplicationScoped
public class MailMessagingController {

    @Inject
    ReactiveMailer reactiveMailer;

    public Uni<Void> sendMail(com.will.entity.Mail mail){
        Mail mailObject = new Mail();
        mailObject.setTo(mail.getUserList().stream().map(UserMessage::getEmail).toList());
        mailObject.setSubject("Olá, Uma receita gostosa pro seu café da manhã - Panqueca Americana");
        mailObject.setText(mail.getIngredientList().stream().map(String::valueOf)
                .collect(Collectors.joining("-", "{", "}")));
        return reactiveMailer.send(mailObject).onFailure().invoke(t -> System.out.println(
                "Oh no! We received a failure: " + t.getMessage()));
    }

}
