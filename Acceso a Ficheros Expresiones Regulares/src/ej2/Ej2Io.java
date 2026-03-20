package ej2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ej2Io {
    static void main(String[] args) {
        File f = new File("./src/ej1ejemplos/leeme.txt");
        try (FileReader fr = new FileReader(f);
             BufferedReader br = new BufferedReader(fr)) {
            String contenido= " ";
            String linea;

            while ((linea = br.readLine()) !=null){
                contenido+=linea;

            }
            System.out.println(contenido);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}