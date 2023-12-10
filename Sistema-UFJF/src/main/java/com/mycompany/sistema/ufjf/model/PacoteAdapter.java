package com.mycompany.sistema.ufjf.model;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.mycompany.sistema.ufjf.model.Pacote;

import java.lang.reflect.Type;

public class PacoteAdapter implements JsonSerializer<Pacote>, JsonDeserializer<Pacote> {
    @Override
    public JsonElement serialize(Pacote pacote, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", pacote.getClass().getName());
        jsonObject.add("data", jsonSerializationContext.serialize(pacote));
        return jsonObject;
    }

    @Override
    public Pacote deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String typeName = jsonObject.get("type").getAsString();
        JsonElement data = jsonObject.get("data");
        try {
            Type actualType = TypeToken.get(Class.forName(typeName)).getType();
            return jsonDeserializationContext.deserialize(data, actualType);
        } catch (ClassNotFoundException e) {
            throw new JsonParseException(e);
        }
    }
}
