package ej2.principal;

import ej2.cuenta.CuentaCorriente;
import ej2.exceptions.CuentaCorrienteException;
import mientradasalida.MiEntradaSalida;

public class Main {
    public static void main(String[] args) {
        CuentaCorriente cuentaCorriente = new CuentaCorriente(1000);
        int opcion = 0;
        boolean salir = false;
        do {
            menu();
            opcion = MiEntradaSalida.leerEntero("Introduce la opcion");
            switch (opcion) {

                case 1 -> {
                    int cantidadRetirar = MiEntradaSalida.leerEntero("Introduce la cantidad a retirar");
                    try {
                        cuentaCorriente.hacerReintegro(cantidadRetirar);
                    } catch (CuentaCorrienteException e) {
                        System.out.println(e.getMessage());
                    }

                }
                case 2 -> {
                    try {
                        int cantidadIngresar = MiEntradaSalida.leerEntero("Introduce la cantidad que quieres ingresar");
                        cuentaCorriente.hacerIngreso(cantidadIngresar);
                    } catch (CuentaCorrienteException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    cuentaCorriente.consultar();
                }
                case 4 -> {
                    String confirmacion = String.valueOf((MiEntradaSalida.solicitarCaracterSN("¿Quieres salir S/N ?")));
                    if (confirmacion.equalsIgnoreCase("S")) {
                        System.out.println(" Operaciones finalizadas. Saldo final: " + cuentaCorriente.getSaldo() + " €");

                        salir = true;
                    } else {
                        System.out.println("Operación cancelada. Volviendo al menú.");
                    }
                }
                default -> {
                    System.out.println("Opcion no valida introduce de nuevo entre 1 y 4  ");
                }
            }
        } while (!salir);
    }

    /**
     * Te muestra el menu de la cuenta corriente
     */
    private static void menu() {
        System.out.println("------------MENU------------");
        System.out.println("1. Hacer un reintegro");
        System.out.println("2. Hacer un ingreso");
        System.out.println("3. Consultar");
        System.out.println("4. Salir");
    }
}
