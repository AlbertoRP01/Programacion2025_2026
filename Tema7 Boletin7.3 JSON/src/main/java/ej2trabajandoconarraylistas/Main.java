package ej2trabajandoconarraylistas;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ej1primercontacto.Videojuego;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main(String[] args) {
        Path p = Path.of("src/main/java/ej2trabajandoconarraylistas/salida/estudiantes.json");
        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("paco", "2ºDAM", 9.5));
        estudiantes.add(new Estudiante("Francisco", "1ºDAM", 6.5));
        estudiantes.add(new Estudiante("Laura", "2ºSMR", 10.0));
        estudiantes.add(new Estudiante("Pepa", "1ºSMR", 4.3));
        try {
            exportarAJson(estudiantes, p);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void exportarAJson(List<Estudiante> estudiantes, Path destino) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        if (!Files.exists(destino)) {
            try {
                Files.createFile(destino);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        try (FileWriter escritor = new FileWriter("src/main/java/ej2trabajandoconarraylistas/salida/estudiantes.json")) {


            gson.toJson(estudiantes, escritor);
            escritor.flush();
            Type miLista = new TypeToken<ArrayList<Estudiante>>() {}.getType();
            estudiantes = gson.fromJson(Files.newBufferedReader(destino), miLista);
            estudiantes.forEach(System.out::println);


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
