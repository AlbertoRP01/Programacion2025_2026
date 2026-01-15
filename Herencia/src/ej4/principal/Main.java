package ej4.principal;

import mientradasalida.MiEntradaSalida;

public class Main {
    static void main(String[] args) {
        int opcion;
        do {
            menu();
            opcion = MiEntradaSalida.leerEntero("Introduce una opcion");
            switch (opcion) {
                case 1 -> {

                }
                case 2 -> {

                }
                case 3 ->{

                }
                case 4 -> {

                }
                case 5 ->{

                }
                case 6 -> {

                }
                case 7 -> {

                }
                default -> System.out.println("Error!, Solo puedes de 1 al 7");
            }
        } while (opcion <= 7);

    }

    public static void menu() {
        System.out.println("|-----------------------BIENVENIDO A LEAGUE OF VIRGIN---------------------------------|");
        System.out.println("1.Alta del Personaje");
        System.out.println("|-------------------------------------------------------------------------------------|");
        System.out.println("2.Mago aprende hechizo");
        System.out.println("|-------------------------------------------------------------------------------------|");
        System.out.println("3.Mago lanza Hechizo");
        System.out.println("|-------------------------------------------------------------------------------------|");
        System.out.println("4.Clerigo cura al mago");
        System.out.println("|-------------------------------------------------------------------------------------|");
        System.out.println("5.Mostar listado de personajes");
        System.out.println("|-------------------------------------------------------------------------------------|");
        System.out.println("6.Mostrar el listado de personajes ordenados por puntos actuales de mayor a menor");
        System.out.println("|-------------------------------------------------------------------------------------|");
        System.out.println("Salir");
        System.out.println("|-------------------------------------------------------------------------------------|");
    }
}
