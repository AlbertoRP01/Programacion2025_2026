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
        System.out.println(mensaje);
        return sc.nextInt();
    }

    /**
     *
     * @param mensaje el mensaje a mostrar
     * @return el enetero leido por teclado
     */
    public static int leerEnteroPositivo(String mensaje) {
        System.out.println(mensaje);
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
     * @param min     rango minimo
     * @param max     rango maximo
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
     * @param min              el rango mas pequeño
     * @param max              el rango maximo
     * @param seAceptaElMaximo ¿El maximo entra en ese intervalo?
     * @return el numero que genera aleatoriamente
     */
    public static int generaAleatorioEntre(int min, int max, boolean seAceptaElMaximo) {
        int ventana;

        if (seAceptaElMaximo) {
            ventana = max - min + 1;

        } else {
            ventana = max - min;

        }
        return (int) (Math.random() * ventana) + min;
    }

    /**
     * TODO: Vamos a imprimir una matriz de manera ordenada por espacios tanto la columna como la fila
     * @param matriz variable en el parametro
     */
    public static void imprimirUnaMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%3d ", matriz[i][j]); //  damos 3 espacios  para los numeros negativos dentro de la matriz de esta forma es más ordenado
            }
            System.out.println();
        }
    }
    public static char solicitarCaracterSN(String mensaje) {
        char c = '0';
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;

        while (flag) {
            // Pedimos el carácter por pantalla.
            System.out.println(mensaje);

            String cadena = sc.nextLine();

            // Comprobamos que la longitud sea de 1 solo carácter.
            if (cadena.length() == 1) {
                c = cadena.toUpperCase().charAt(0);

                // Comprobamos si es S o N.
                if (c == 'S' || c == 'N') {
                    // Si llegamos hasta aquí, el dato es correcto.
                    flag = false;
                } else {
                    // 2. Mensaje de error específico (carácter incorrecto).
                    System.out.println("Error: Respuesta no válida. Debe introducir 'S' o 'N'.");
                }
            } else {
                // 2. Mensaje de error específico (longitud incorrecta).
                System.out.println("Error: Debe introducir un solo carácter ('S' o 'N').");
            }
        }

        return c;
    }

    public static char solicitarCaracter(String mensaje) {
        char c = '0';
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;

        while (flag) {
            // Pedimos el carácter por pantalla.
            System.out.println(mensaje);

            try {
                // Obtenemos el primer carácter de la línea.
                c = sc.nextLine().charAt(0);
                // Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto.
                flag = false;
            }
            // Si se lanza la excepción (porque el usuario no escribió nada).
            catch (StringIndexOutOfBoundsException e) { // Es más específico que IndexOutOfBoundsException
                // 2. Mensaje de error específico.
                System.out.println("Error: No ha introducido ningún carácter. Inténtelo de nuevo.");
            }

        }

        return c;
    }

    public static void main(String[] args) {
        int a = MiEntradaSalida.leerEnteroPositivo("Introduce un numero");
        System.out.printf("Numero introducido es %d", a);
    }

}