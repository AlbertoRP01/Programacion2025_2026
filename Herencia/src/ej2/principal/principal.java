package ej2.principal;

import ej2.clases.Coche;
import ej2.clases.Furgoneta;
import ej2.clases.MicroBus;
import ej2.clases.Vehiculo;
import ej2.enums.TCombustible;
import ej2.enums.TGama;
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
            switch (opcion) {
                case 1 -> {
                    if (numVehiculos >= 200) {
                        System.out.println("Has alcanzado el límite");
                    }
                    int tipo = MiEntradaSalida.leerEnteroPositivo("Tipo de vehículo: 1-Coche, 2-MicroBus, 3-Furgoneta");
                    String matricula = MiEntradaSalida.solicitarCadena("Matricula:");
                    boolean flag = true;
                    TGama gama = null;
                    while (flag) {
                        try {
                            gama = TGama.valueOf(MiEntradaSalida.solicitarCadena("Gama: baja, media, alta"));
                            flag = false;
                        } catch (IllegalArgumentException e) {
                            System.out.println("No  hay otra opción.Solo gama baja, gama media y gama alta ");
                        }
                    }
                    TCombustible combustible = null;
                    while (flag) {
                        try {
                            combustible = TCombustible.valueOf(MiEntradaSalida.solicitarCadena("Combustible: gasolina, diesel").toUpperCase());
                        } catch (IllegalArgumentException e) {
                            System.out.println("No hay otra opción.Solo 1.gasolina, 2.diesel");
                        }
                    }

                    Vehiculo v = null;
                    switch (tipo) {
                        case 1 -> { //Coche
                            v = new Coche(matricula, gama, combustible);
                        }
                        case 2 -> {//MicroBus
                            int plazas = MiEntradaSalida.leerEnteroPositivo("Introduce el numero de plazas");
                            v = new MicroBus(matricula, gama, combustible, plazas);
                        }
                        case 3 -> { //Furgoneta
                            double pma = MiEntradaSalida.solicitarDouble("Introduce el pma");
                            v = new Furgoneta(matricula, gama, combustible, pma);
                        }
                    }

                }
                case 2 -> { //calcular precio
                    String matriculaBuscada = MiEntradaSalida.solicitarCadena("Introduce la matricula");
                    int dias = MiEntradaSalida.leerEnteroPositivo("Introduce el numero de días que quieres alquilar");
                    boolean encontrado = false;
                    for (int i = 0; i < numVehiculos; i++) {
                        if (vehiculos[i].getMatricula().equalsIgnoreCase(matriculaBuscada)) {
                            double precio = vehiculos[i].calcularPrecioAlquiler(dias);
                            System.out.println("precio del alquiler" + precio + "€");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Vehiculo no encontrado");
                    }
                }
                case 3 -> {
                    System.out.println("hasta la proxima");
                }
                default -> System.out.println("Opcion no válida");
            }


        } while (opcion != 3);
    }

    public static void menu() {
        System.out.println("----------Bienvenido a MOTORS RENTALS.SL----------");
        System.out.println("1.Alta de  Vehículo");
        System.out.println("2.calculo del Alquiler");
    }
}
