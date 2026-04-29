package ejerciciorepaso;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.print.DocFlavor;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Ej {
    public static void main(String[] args) {

        Path rutaOrigen = Path.of("src", "main","java","ejerciciorepaso", "salida", "matriculas_extendido.txt");
        Path rutaDestino = Path.of("src", "main", "java", "ejerciciorepaso", "salida", "matriculas_extendido.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Pattern pattern = Pattern.compile("^(?<numeros>[0-9]{4})-(?<letras>[A-Z&&[^AEIOU]]{3})");
        try (Stream<String> lineas = Files.lines(rutaOrigen)) {
            List<MatriculaDTO> matriculas = lineas.map(pattern::matcher)
                    .filter(Matcher::find)
                    .map(m -> {
                        String numeros = m.group("numeros");
                        String letras = m.group("letras");
                        return new MatriculaDTO(numeros,letras);
                    }).toList();
            String json = gson.toJson(matriculas);
            Files.writeString(rutaDestino, json, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.getMessage();
        }

    }

}

