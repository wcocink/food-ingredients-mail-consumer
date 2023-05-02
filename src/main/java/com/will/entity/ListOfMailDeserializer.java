package com.will.entity;

import io.quarkus.kafka.client.serialization.JsonbDeserializer;

import java.util.ArrayList;
import java.util.List;

public class ListOfMailDeserializer extends JsonbDeserializer<List<Mail>> {

    public ListOfMailDeserializer() {
        super(new ArrayList<Mail>() {}.getClass().getGenericSuperclass());
    }

}
