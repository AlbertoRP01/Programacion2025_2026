package ej7;

import mientradasalida.MiEntradaSalida;

public class Ej7Nio {
    public static void main(String[] args) {
        boolean salir = false;
        int opcion;
        do {
            System.out.println("======================Bienvenido al pequeño menu  de nuestro sistema=====================================");
            menu();
            opcion = MiEntradaSalida.leerEntero("Elige una opción: ");
            switch (opcion) {
                case 1 -> {

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
    public void listarDirectorio(){

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
