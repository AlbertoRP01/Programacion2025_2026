package ej4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Ej3Nio {
    static void main(String[] args) {
        Path p = Path.of("./src/ej4/salidaEj3.txt");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String linea;
            while ((linea = br.readLine()) != null && !linea.equalsIgnoreCase("fin")){
                Files.writeString(p, linea, StandardOpenOption.CREATE, StandardOpenOption.APPEND);

            }
            System.out.println(linea);
        }catch (IOException e ){
            System.out.println(e.getMessage());
        }
    }
}
