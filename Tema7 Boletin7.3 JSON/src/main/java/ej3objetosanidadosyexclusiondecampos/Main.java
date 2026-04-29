package ej3objetosanidadosyexclusiondecampos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ej2trabajandoconarraylistas.Estudiante;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Main {
    static void main(String[] args) {
        Path p = Path.of("src/main/java/ej3objetosanidadosyexclusiondecampos/salida/estudantes.json");
        Direccion direccion = new Direccion("Avenida lepe", "Huelva", 53432);
        Usuario usuario = new Usuario("pepe", "1234", "pepe@gmail.com", direccion);
        exportarAJson(direccion, usuario, p);
    }

    public static void exportarAJson(Direccion direccion, Usuario usuario, Path destino) {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        if (!Files.exists(destino)) {
            try {
                Files.createFile(destino);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        try (BufferedReader r = Files.newBufferedReader(destino)) {
            String json = gson.toJson(usuario);
            Files.writeString(destino, json, StandardOpenOption.CREATE);
            usuario = gson.fromJson(r, Usuario.class);
            direccion = gson.fromJson(r, Direccion.class);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
