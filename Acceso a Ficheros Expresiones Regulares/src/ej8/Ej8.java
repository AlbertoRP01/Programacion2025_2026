package ej8;

import mientradasalida.MiEntradaSalida;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Ej8 {
    static void main(String[] args) {

        String nombreFichero = MiEntradaSalida.solicitarCadena("Introduce el nombre del fichero");

        Path p = Path.of("src", "ej8", nombreFichero);
        if (!Files.exists(p) || !Files.isRegularFile(p)) {
            System.err.println("El fichero no existe o no es valido");
            return;
        }
        try (Stream<String> lineas = Files.lines(p)) {
            boolean cumple = lineas.allMatch(l -> l.matches("(\\p{L}{2,}\\s){3}([1-9]|([1-9][0-9]))$"));
            if (cumple) System.out.println("cumple");
            else System.out.println("No cumple");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
