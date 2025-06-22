package com.watchplant.app.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Month;

public class MonthDeserializer extends JsonDeserializer<Month> {
    @Override
    public Month deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getText().toUpperCase();
        return Month.valueOf(value);
    }
}
