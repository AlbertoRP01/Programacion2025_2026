package ej4adaptadorespersonalizadosmanejodefechas;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ej1.LocalDateAdapter;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

public class Main {

    static void main(String[] args) {
        Path p = Path.of("src/main/java/ej4adaptadorespersonalizadosmanejodefechas/salida/evento.json");
        Evento evento = new Evento("Boda", LocalDate.of(2026, 6, 25));
        exportarJson(evento, p);
    }
    public static void exportarJson(Evento evento, Path destino){
        Gson gson =  new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .setPrettyPrinting()
                .create();
        if (!Files.exists(destino)){
            try {
                Files.createFile(destino);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        try(BufferedReader r =  Files.newBufferedReader(destino)) {
            String json = gson.toJson(evento);
            Files.writeString(destino,json, StandardOpenOption.CREATE);
            evento = gson.fromJson(r, Evento.class);
            System.out.println(evento.getFecha());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
