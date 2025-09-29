package ej10;

import java.util.Scanner;

public class Ej10 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int numero;

        int  numFactorial;
        do {
            System.out.println("Introduce un numero positivo");
            numero = sc.nextInt(); // Introducimos el numero

        }while (numero < 0);
        int factorial = 1; // inicializamos uno despues de introducir el numero
        for (numFactorial = 1; numFactorial <= numero; numFactorial ++){
            factorial *= numFactorial; // hacemos la operacion del factorial
        }
        System.out.println("El factorial  de " + numero + " es: " + factorial);
    }
}
