package ej4adaptadorespersonalizadosmanejodefechas;

import com.google.gson.*;


import java.lang.reflect.Type;
import java.time.LocalDate;

public class LocalDateAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {

    @Override
    public JsonElement serialize(LocalDate fecha, Type type, JsonSerializationContext context) {
        return new JsonPrimitive(fecha.toString()); // "2023-10-25"
    }

    @Override
    public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext context) {
        return LocalDate.parse(json.getAsString());
    }

}
