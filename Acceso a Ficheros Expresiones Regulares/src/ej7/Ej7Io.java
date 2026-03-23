package ej7;

import mientradasalida.MiEntradaSalida;

import java.io.File;

public class Ej7Io {
    public static void main(String[] args) {
        boolean salir = false;
        int opcion;
        do {
            System.out.println("======================Bienvenido al pequeño menu  de nuestro sistema=====================================");
            menu();
            opcion = MiEntradaSalida.leerEntero("Elige una opción: ");
            switch (opcion) {
                case 1 -> {
                    listarDirectorio();
                }
                case 2 -> {

                }
                case 3 -> {

                }
                case 4 -> {

                }
                case 5 -> {

                }
                case 6 -> {
                    salir = true;
                }
                default -> {
                    System.out.println("Error. Selecciona entre 1 y 6");
                }
            }
        } while (!salir);
    }

    public static void listarDirectorio(){
        String ruta = MiEntradaSalida.solicitarCadena("Introduce la ruta");
        File carpeta = new File(ruta);
        if (carpeta.exists() && carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles();
            if (archivos != null && archivos.length > 0) {
                for (File archivo : archivos) {
                    if (archivo.isDirectory()) {
                        System.out.println("[DIR]" + archivo.getName());
                    }else {
                        double sizeKB = archivo.length() /1024.0;
                        System.out.printf("[File %s - %.2f KB%n]",  archivo.getName(), sizeKB);
                    }
                }
            }else {
                System.out.println("La carpita está vacia");
            }

        }else {
            System.out.println("No existe la ruta o no es un directorio");
        }
    }

    public static void BuscarFicheroQueComienceConUnaPalabra(){

    }
    public static void listarArchivoConExtension(){

    }
    public static void buscarArchivoEnUnDirectorio(){

    }
    public static void buscarRecursivamenteUnArchivo(){

    }
    public static void menu() {
        System.out.println("1. Listar Directorio");
        System.out.println("2. Listar Directorio y buscar ficheros que comiencen con una palabra");
        System.out.println("3. Listar archivos con cierta extensión de un directiorio");
        System.out.println("4. Buscar un archivo en un directorio");
        System.out.println("5. Buscar recursivamente un archivo en un directorio");
        System.out.println("6. Salir");
    }
}
