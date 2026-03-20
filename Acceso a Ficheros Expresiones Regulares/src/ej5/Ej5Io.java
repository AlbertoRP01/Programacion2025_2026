package ej5;

import mientradasalida.MiEntradaSalida;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ej5Io {
    static void main(String[] args) {

    }
    public static void crearDirectorio(){
        String nombreDelDirectorio = MiEntradaSalida.solicitarCadena("nombre:");
        File directorio = new File("./src/ej5/salidasEjercicio5", nombreDelDirectorio);
        directorio.mkdirs();
        directorio.mkdir();
    }

}
