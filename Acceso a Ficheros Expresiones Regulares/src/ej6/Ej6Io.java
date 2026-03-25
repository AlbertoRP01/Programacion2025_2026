package ej6;

import mientradasalida.MiEntradaSalida;

import javax.sound.midi.MidiChannel;
import java.io.File;

public class Ej6Io {
    public static void main(String[] args) {
        mostrarLosArchivosQueContiene();
    }

    public static void mostrarLosArchivosQueContiene() {
        String nombreDirectorio = MiEntradaSalida.solicitarCadena("Introduce el nombre del directorio");
        File carpeta = new File("./src/ej6", nombreDirectorio);
        if (carpeta.exists() &&  carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles();
            if (archivos != null && archivos.length > 0) {
                System.out.println("contenido" + carpeta.getAbsolutePath());
                for (File archivo : archivos) {
                    if (archivo.isDirectory()){
                        System.out.printf("[DIR] " + archivo.getName() + "\n");
                    }else {
                        double sizeKB = archivo.length()  /1024.0;
                        System.out.printf("[File] %s - %.2f KB%n", archivo.getName(), sizeKB);
                    }
                }
            } else {
                System.out.println("La carpeta está vacia");
            }
        }else {
            System.out.printf("La ruta del directorio no es valida o no es un directorio");
        }
    }
}
