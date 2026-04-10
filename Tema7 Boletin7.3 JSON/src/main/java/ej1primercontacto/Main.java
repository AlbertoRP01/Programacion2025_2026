package ej1primercontacto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ej1.Persona;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Main {
    static void main(String[] args) {
        Path p = Path.of("src/main/java/ej1primercontacto/salida/videojuego.json");
        Videojuego videojuego = new Videojuego("Red dead Redemption 2", "Rockstar Games", 2018);
        exportarAJson(videojuego, p);
    }

    public static void exportarAJson(Videojuego videojuego, Path destino) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        if (!Files.exists(destino)) {
            try {
                Files.createFile(destino);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        try (BufferedReader r = Files.newBufferedReader(destino)) {
            String json = gson.toJson(videojuego);
            Files.writeString(destino, json, StandardOpenOption.CREATE);
            videojuego = gson.fromJson(r, Videojuego.class);
            System.out.println(videojuego.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
