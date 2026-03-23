package ej5;

import mientradasalida.MiEntradaSalida;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.PublicKey;
import java.util.regex.MatchResult;

public class Ej5Io {
    public static void main(String[] args) {
        int opcion = 0;
        boolean salir = false;
        do {
            System.out.println("============= Bienvenidos al menu  de ficheros =================");
            menu();
            opcion = MiEntradaSalida.leerEntero("Introduce del 1-5");
            switch (opcion){
                case  1 -> {
                    crearDirectorio();
                }
                case  2 -> {
                    try {
                        crearFichero();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case  3 -> {
                    try {
                        borrarFichero();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case  4 -> {
                    try {
                        mostrarFicherosEnUnaCarpeta();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case  5 -> {
                    salir = true;
                }
                default -> {
                    System.out.println("Has selccionado de manera incorrecta vuelve a seleccionar entre 1-5");
                }
            }
        }while (!salir);
    }

    public static void crearDirectorio() {
        String nombreDelDirectorio = MiEntradaSalida.solicitarCadena("nombre:");
        File directorio = new File("./src/ej5/salidasEjercicio5", nombreDelDirectorio);
        directorio.mkdirs();
        directorio.mkdir();
    }

    public static void crearFichero() throws IOException {
        String nombreDelFichero = MiEntradaSalida.solicitarCadena("nombre:");
        File fichero = new File("./src/ej5", nombreDelFichero);
        if (fichero.getParentFile() != null) {
            fichero.getParentFile().mkdir();
        }
        if (fichero.createNewFile()) {
            System.out.println("Fichero creada exitosamente");
        } else {
            System.out.println("Fichero ya existe");
        }
    }

    public static void borrarFichero() throws IOException {
        String nombreDelFichero = MiEntradaSalida.solicitarCadena("Nombre");
        File fichero = new File("./src/ej5", nombreDelFichero);
        if (fichero.exists()) {
            if (fichero.delete()) {
                System.out.println("Fichero borrado exitosamente");
            } else {
                System.out.println("El fichero no se ha podido borrar");
            }

        }else {
            System.out.println("El fichero no existe en la ruta " + fichero.getAbsolutePath());
        }

    }

    public static void mostrarFicherosEnUnaCarpeta() throws IOException {
        String ruta = MiEntradaSalida.solicitarCadena("La ruta que tienes que indicar");
        File carpeta = new File(ruta);
        if (carpeta.exists() && carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles();
            if (archivos != null) {
            }
            if (archivos != null && archivos.length > 0) {
                System.out.println("contenido " + carpeta.getAbsolutePath());
                for (File archivo : archivos) {
                    String marca = archivo.isDirectory() ? "[DIR]" : "[ARG]";
                    System.out.println(marca + " " + archivo.getName());
                }
            } else {
                System.out.println("La carpeta está vacía");
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

