package mientradasalida;

import java.util.Scanner;

public class MiEntradaSalida {
    private static Scanner sc = new Scanner(System.in);

    /**
     * Lee un entero mostrando el mensaje pasado como parámetro
     *
     * @param mensaje El mensaje a mostrar
     * @return el entero leído por teclado
     */

    public static int leerEntero(String mensaje) {
        System.out.println("Introduce un numero: ");
        return sc.nextInt();
    }

    public static int leerEnteroPositivo(String mensaje) {
        System.out.println("Introduce un numero positivo");
        int a = sc.nextInt();
        while (a < 0) {
            System.out.println("El  numero tiene que ser  positivo: ");
            a = sc.nextInt();
        }
        return a;
    }

    public static double leerDecimales(String mensaje) {
        System.out.println("Introduce un numero decimal");
        double a = sc.nextDouble();
        while (a < 0) {
            System.out.println("El numero tiene que ser positivo");
            a = sc.nextDouble();
        }
        return a;
    }

    public static int leeEnteroRango(String mensaje, int min, int max) {
        if (min > max) {
            //mostrar error
            System.out.println("El minimo es mayor que el maximo");
            //TODO: cambiar esto al ver las excepciones
            return -1;
        }
        int num = leerEntero(mensaje);
        while (num < min || num > max) {
            System.out.printf("El numero está fuera del rango %d -%d", min, max);
            num = leerEntero(mensaje);
        }
        return num;
    }

    public static String leerCadena(String mensaje) {
        System.out.println("Introduce una cadena");
        return sc.nextLine().toUpperCase();
    }

    public static void main(String[] args) {
        int a = MiEntradaSalida.leerEnteroPositivo("Introduce un numero");
        System.out.printf("Numero introducido es %d", a);
    }

}
