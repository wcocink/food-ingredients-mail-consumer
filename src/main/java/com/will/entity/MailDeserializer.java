package com.will.entity;

import io.quarkus.kafka.client.serialization.JsonbDeserializer;

public class MailDeserializer extends JsonbDeserializer<Mail> {

    public MailDeserializer() {
        super(Mail.class);
    }

}
