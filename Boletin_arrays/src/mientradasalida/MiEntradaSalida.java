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

    /**
     *
     * @param mensaje el mensaje a mostrar
     * @return el enetero leido por teclado
     */
    public static int leerEnteroPositivo(String mensaje) {
        System.out.println("Introduce un numero positivo");
        int a = sc.nextInt();
        while (a < 0) {
            System.out.println("El  numero tiene que ser  positivo: ");
            a = sc.nextInt();
        }
        return a;
    }

    /**
     *
     * @param mensaje // el mensaje que tengas que introducir
     * @return devuelve el numero decimal
     */
    public static double leerDecimales(String mensaje) {
        System.out.println(mensaje);
        double a = sc.nextDouble();
        while (a < 0) {
            System.out.println("El numero tiene que ser positivo");
            a = sc.nextDouble();
        }
        return a;
    }

    /**
     *
     * @param mensaje
     * @param min rango minimo
     * @param max rango maximo
     * @return devuelve el numero
     */
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

    /**
     *
     * @param mensaje mostando un mensaje que escriba
     * @return devuelve la cadena y la trnasforma en mayuscula
     */
    public static String leerCadena(String mensaje) {
        System.out.println(mensaje);
        return sc.nextLine().toUpperCase();
    }

    /**
     *
     * @param min el rango mas pequeño
     * @param max el rango maximo
     * @param seAceptaElMaximo ¿El maximo entra en ese intervalo?
     * @return el numero que genera aleatoriamente
     */
    public static int generaAleatorioEntre( int min, int  max, boolean seAceptaElMaximo){
       int ventana;

       if (seAceptaElMaximo){
           ventana = max - min + 1;

       }else {
           ventana = max -min;

       }
       return (int)  (Math.random() * ventana) + min;
    }

    public static void main(String[] args) {
        int a = MiEntradaSalida.leerEnteroPositivo("Introduce un numero");
        System.out.printf("Numero introducido es %d", a);
    }

}
