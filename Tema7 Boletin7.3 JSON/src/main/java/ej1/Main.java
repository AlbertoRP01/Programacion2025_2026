package ej1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Path destino = Path.of("src/main/java/ej1/salida/persona.json");
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Laura Gómez", "12345678A", "600111222", LocalDate.of(1955,1,23)));
        personas.add(new Persona("Carlos Ruiz", "87654321B", "611222333", LocalDate.of(1925,1,23)));
        personas.add(new Persona("Ana Martínez", "11223344C", "622333444", LocalDate.of(1945,1,23)));
        personas.add(new Persona("Pedro Sánchez", "44332211D", "633444555", LocalDate.of(1975,1,23)));
        personas.add(new Persona("Sofía López", "55667788E", "644555666", LocalDate.of(1995,1,23)));
        exportarAJson(personas, destino);
    }

    public static void exportarAJson(List<Persona> personas, Path destino) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .setPrettyPrinting().create();

        String json = gson.toJson(personas);
        try {
            Files.writeString(destino, json, StandardOpenOption.CREATE);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
