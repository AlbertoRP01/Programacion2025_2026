package ejemplos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio1 {
    static void main(String[] args) {
        File f = new File("./src/ejemplos/leeme.txt");
        try (FileReader fr = new FileReader(f);
             BufferedReader br = new BufferedReader(fr)) {
           // int contador = 0;
            //while (br.readLine() != null) {
               // contador++;
            //}
            // System.out.printf("Habia  %d  lineas", contador);
           // System.out.printf("Habia lineas" , br.lines().count());

            Path fichero = Path.of("src/ejemplos/leeme.txt");
            System.out.printf("Habia lineas %d", Files.lines(fichero).count());
        } catch (IOException e) {
            System.out.printf(e.getMessage());
        }
    }
}
