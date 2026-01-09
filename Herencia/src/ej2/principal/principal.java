package ej2.principal;

import ej2.clases.Vehiculo;
import ej2.excepciones.VehiculoException;
import mientradasalida.MiEntradaSalida;

public class principal {
    static void main(String[] args) {
        Vehiculo[] vehiculos = new Vehiculo[200];
        int numVehiculos = 0;

        int opcion = 0;
        do {
            menu();
            opcion = MiEntradaSalida.leerEntero("Introduce una opcion");
            switch (opcion){
                case 1 -> {
                    if (numVehiculos >= 200){
                        System.out.println("Has alcanzado el límite");
                    }

                }
            }
        }while (opcion != 3);
    }
    public static void menu(){
        System.out.println("----------Bienvenido a MOTORS RENTALS.SL----------");
        System.out.println("1.Alta de  Vehículo");
        System.out.println("2.calculo del Alquiler");
    }
}
