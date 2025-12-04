package juegocartasej1.principal;

import juegocartasej1.clase.Baraja;
import juegocartasej1.clase.Carta;
import juegocartasej1.excepciones.BarajaException;
import mientradasalida.MiEntradaSalida;

import java.security.spec.RSAOtherPrimeInfo;

public class Juego {
    static void main(String[] args) {
        boolean salir = false;
        System.out.println("----------bienvenido al juego de las cartas----------");
        Baraja baraja = new Baraja();
        baraja.crearBaraja();
        int opcion = 0;
        int  jugadores = MiEntradaSalida.leerEnteroPositivo("¿Cuantos van a jugar? ");
        do {
            opcion = MiEntradaSalida.leerEnteroPositivo("Introduce la opción");
            switch (opcion){
                case 1 -> {
                    System.out.println(baraja.toString());
                }
                case 2 -> {
                   baraja.barajar();
                }
                case 3 -> {
                    try {

                        baraja.repartirBaraja(jugadores, 2);
                    }catch (BarajaException e){
                        System.out.println(e.getMessage());
                    }
                }
                case 4 -> {
                    System.out.println("Hasta la proxima");
                    salir = true;
                }
                default -> System.out.println("Error opcion no elegible solo 1-3");
            }
        }while (!salir);
    }
    public void menu(){
        System.out.println("1.MostarBaraja");
        System.out.println("2.Barajar");
        System.out.println("3.Repartir");
        System.out.println("4. salir");
    }
}
