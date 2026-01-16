package ej4.principal;

import ej2.enums.TGama;
import ej3.clases.Clerigo;
import ej3.clases.Mago;
import ej3.clases.Personaje;
import ej3.enums.TRaza;
import mientradasalida.MiEntradaSalida;

public class Main {
    static void main(String[] args) {
        Personaje[] personajes = new Personaje[100];
        boolean salir = false;
        int opcion;
        do {
            menu();
            opcion = MiEntradaSalida.leerEntero("Introduce una opcion");
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

                }
                case 7 -> {
                    System.out.println("Hasta la proxima");
                    salir = true;
                }
                default -> System.out.println("Error!, Solo puedes de 1 al 7");
            }
        } while (salir);

    }

    public static void AltaPersonaje(Personaje[] personajes, Mago mago, Clerigo clerigo) {
        int opcion = 0;
        boolean salir = false;
        do {
            opcion = MiEntradaSalida.leerEntero("Selecciona 1.Mago o 2.Clerigo");
            switch (opcion) {
                case 1 -> {
                    boolean flag = true;
                    TRaza razas = null;
                    String nombre = MiEntradaSalida.solicitarCadena("Introduce el nombre de tu mago");
                    try {
                        while (flag) {
                            razas = TRaza.valueOf(MiEntradaSalida.solicitarCadena("Introduce tu nombre de tu raza Humano, Elfo, Enano o  Orco"));
                            flag = false;
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Solo puedes seleccionar esas razas");
                    }

                }
                case 2 -> {

                }
                case 3 -> {
                    System.out.println("quieres volver");
                    salir = true;
                }
                default -> System.out.println("Error!, selecciona opcion 1 y 2");
            }
        } while (salir);
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
