package com.will.controller;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.reactive.ReactiveMailer;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Message;

import java.util.List;

@ApplicationScoped
public class MailMessagingController {

    @Inject
    ReactiveMailer reactiveMailer;

//    public Uni<Void> sendMail(Message<String> message){
//        return reactiveMailer.send(
//                        Mail.withText("mailhere@gmail.com",
//                                "Uma receita gostosa pro seu café da manhã - Panqueca Americana",
//                                "Confira essa receita de panqueca americana deliciosa! Uma das comidas mais comuns no breakfast, o café da manhã dos Estados Unidos, ela é muito versátil e vai te proporcionar uma refeição muito especial!\n" +
//                                        "\n" +
//                                        "1 e 1/4 xícara (chá) de farinha de trigo\n" +
//                                        "1 colher (sopa) de açúcar\n" +
//                                        "3 colheres (chá) de fermento em pó\n" +
//                                        "2 ovos levemente batidos\n" +
//                                        "1 xícara (chá) de leite\n" +
//                                        "2 colheres (sopa) de manteiga derretida\n" +
//                                        "pitada de sal\n" +
//                                        "óleo"))
//                .onFailure().invoke(t -> System.out.println(
//                        "Oh no! We received a failure: " + t.getMessage()));
//    }

    public Uni<Void> sendMail(List<com.will.entity.Mail> listOfMails){
        return reactiveMailer.send(
                        Mail.withText("willian.mistro@gmail.com",
                                "Uma receita gostosa pro seu café da manhã - Panqueca Americana",
                                "Confira essa receita de panqueca americana deliciosa! Uma das comidas mais comuns no breakfast, o café da manhã dos Estados Unidos, ela é muito versátil e vai te proporcionar uma refeição muito especial!\n" +
                                        "\n" +
                                        "1 e 1/4 xícara (chá) de farinha de trigo\n" +
                                        "1 colher (sopa) de açúcar\n" +
                                        "3 colheres (chá) de fermento em pó\n" +
                                        "2 ovos levemente batidos\n" +
                                        "1 xícara (chá) de leite\n" +
                                        "2 colheres (sopa) de manteiga derretida\n" +
                                        "pitada de sal\n" +
                                        "óleo"))
                .onFailure().invoke(t -> System.out.println(
                        "Oh no! We received a failure: " + t.getMessage()));
    }

}
