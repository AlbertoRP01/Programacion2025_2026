package juegocartasej1.principal;

import juegocartasej1.clase.Baraja;
import juegocartasej1.clase.Carta;
import juegocartasej1.excepciones.BarajaException;

public class Juego {
    static void main(String[] args) {
       boolean salir = false;

        System.out.println("----------Bienvenido al juego de cartas----------");
        Baraja baraja = new Baraja();
        baraja.crearBaraja();
        while (!salir) {
            System.out.println("Mostrando la baraja");
            System.out.println(baraja.toString());
            System.out.println("Barajando las cartas");
            baraja.barajar();
            System.out.println("Repartiendo Cartas");

            try {
                baraja.repartirBaraja(4, 8);
            } catch (BarajaException e) {
                System.out.println(e.getMessage());
            }
            if (baraja.cartasRestantes() == 0) {
            }
        }
        System.out.println("Ha salido de la partida");
    }
}
