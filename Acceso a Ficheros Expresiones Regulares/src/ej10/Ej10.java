package ej10;

import mientradasalida.MiEntradaSalida;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Ej10 {
    static void main(String[] args) {
        String nombreFichero = MiEntradaSalida.solicitarCadena("Introduce el nombre del fichero");
        Path fichero = Path.of("./src", "/ej10", nombreFichero);

        if (Files.isRegularFile(fichero) && Files.isReadable(fichero)) {
            Pattern p = Pattern.compile("\\s((?:\\w:\\/)?(?:\\w+\\/)*[\\d\\p{L}]{3,}\\.\\p{L}{3})");
            try (Stream<String> lineas = Files.lines(fichero)) {
                lineas
                        .map(p::matcher).filter(Matcher::find)
                        .map(m -> m.group(1))
                        .map(Path::of)
                        .forEach(l -> {
                            try {
                                Files.createFile(l);
                            } catch (IOException e) {
                                System.out.println(e.getMessage());
                            }
                        });


            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        } else {
            System.out.println("Fichero no encontrado");
        }
    }
}
