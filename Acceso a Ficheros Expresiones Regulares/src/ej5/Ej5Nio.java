package ej5;

import mientradasalida.MiEntradaSalida;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Ej5Nio {
    public static void main(String[] args) {
        int opcion = 0;
        boolean salir = false;
        do {
            System.out.println("============= Bienvenidos al menu  de ficheros =================");
            menu();
            opcion = MiEntradaSalida.leerEntero("Introduce del 1-5");
            switch (opcion) {
                case 1 -> {
                    try {
                        crearDirectorio();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> {
                    try {
                        crearFichero();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    try {
                        borrarFichero();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 4 -> {
                    try {
                        mostrarFicherosEnUnaCarpeta();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 5 -> {
                    salir = true;
                }
                default -> {
                    System.out.println("Has selccionado de manera incorrecta vuelve a seleccionar entre 1-5");
                }
            }
        } while (!salir);
    }

    public static void crearDirectorio() throws IOException {
        String nombreDelDirectorio = MiEntradaSalida.solicitarCadena("nombre:");
        Path ruta = Path.of("./src/ej5/", nombreDelDirectorio);
        Files.createDirectories(ruta);
        System.out.println("Directorio creado correctamente");
    }

    public static void crearFichero() throws IOException {
        String nombreDelFichero = MiEntradaSalida.solicitarCadena("nombre:");
        Path ruta = Path.of("./src/ej5/salidasEj5", nombreDelFichero);
        if (Files.notExists(ruta)) {
            Files.createFile(ruta);
            System.out.println("Fichero creado correctamente");
        } else {
            System.out.println("Fichero ya existe");
        }
    }

    public static void borrarFichero() throws IOException {
        String nombreDelFichero = MiEntradaSalida.solicitarCadena("Nombre");
        Path ruta = Path.of("./src/ej5/salidasEj5", nombreDelFichero);
        if (Files.exists(ruta)) {
            Files.delete(ruta);
            System.out.println("Fichero eliminado correctamente");
        } else {
            System.out.println("Fichero no existe");
        }
    }

    public static void mostrarFicherosEnUnaCarpeta() throws IOException {
        String rutaStr = MiEntradaSalida.solicitarCadena("La ruta que tienes que indicar");
        Path ruta = Path.of(rutaStr);
        if (Files.exists(ruta) && Files.isDirectory(ruta)) {
            Stream<Path> rutas = Files.list(ruta);
            {
                rutas.forEach(p -> {
                    String tipo = Files.isDirectory(p) ? "[DIR]" : "[FILE]";
                    System.out.println(tipo + " " + p.getFileName());
                });
            }
        } else {
            System.out.println("Error en la ruta " + ruta + "No es válido");
        }
    }

    public static void menu() {
        System.out.println("1. Crear directorio: ");
        System.out.println("2. Crear fichero de texto:");
        System.out.println("3. Borrar fichero de texto:");
        System.out.println("4. Mostrar los ficheros que contiene una carpeta:");
        System.out.println("5.Salir");
    }
}



