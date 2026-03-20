package ej2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ej2Nio {
    static void main(String[] args) {
        Path p = Path.of("./src/ej1ejemplos/leeme.txt");

        try (Stream<String> lineas = Files.lines(p)){
            System.out.println(lineas.collect(Collectors.joining(" ")));

        } catch (IOException e) {
            System.out.printf(e.getMessage());
        }
    }
}
