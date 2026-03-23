package ej6;

import mientradasalida.MiEntradaSalida;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Ej5Nio {
    public static void main(String[] args) {
        try {
            mostrarLosArchivosQueContiene();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void mostrarLosArchivosQueContiene() throws IOException {
        String rutaStr = MiEntradaSalida.solicitarCadena("Introduce la ruta");
        Path ruta = Path.of(rutaStr);
        if (Files.exists(ruta) && Files.isDirectory(ruta)) {
            try (Stream<Path> rutas = Files.list(ruta)) {
                rutas.forEach(p -> {
                    try {
                        if (Files.isDirectory(p)) {
                            System.out.println("[DIR] " + p.getFileName());
                        } else {
                            double sizeKB = Files.size(p) / 1024.0;
                            System.out.printf("[FILE] %s - %.2f KB%n", p.getFileName(), sizeKB);
                        }
                    } catch (IOException e) {
                        System.out.println("Error con " + p.getFileName());
                    }

                });
            }
        } else {
            System.out.println("Ruta no válida");
        }
    }
}
