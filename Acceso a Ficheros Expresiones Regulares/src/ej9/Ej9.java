package ej9;

import mientradasalida.MiEntradaSalida;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

public class Ej9 {
   public static void main(String[] args) {

       String nombreDelFichero = MiEntradaSalida.solicitarCadena("Introduce el nombre del fichero");
       Path p = Path.of("src", "ej9", nombreDelFichero);
       if (!Files.exists(p) || !Files.isRegularFile(p)) {
           System.err.println("El fichero no existe o no es valido");
           return;
       }
       try (Stream<String> lineas = Files.lines(p)) {
          lineas.filter(l -> l.matches("\\p{L}+\\s\\d{4}-[B-Z&&[^EIOU]]{3}")).forEach(l -> {
              try {
                  Files.writeString(p, l,StandardOpenOption.CREATE , StandardOpenOption.APPEND);
              } catch (IOException e) {
                  System.out.println(e.getMessage());
              }
          });

       } catch (IOException e) {
           System.out.println(e.getMessage());
       }
    }

}
