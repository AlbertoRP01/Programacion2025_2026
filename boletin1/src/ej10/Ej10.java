package ej10;

import java.util.Scanner;

public class Ej10 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un cararter");
        char caracter = sc.next().charAt(0);
        System.out.println("Introduce un numero");
        double num1 = sc.nextInt();
        System.out.println("Introduce otro numero");
        double num2 = sc.nextInt();
        if (caracter == '+') {
            double suma = num1 + num2;
            System.out.println("La suma de ambos numeros es " + suma);
        } else if (caracter == '-') {
            double resta = num1 - num2;
            System.out.println("La resta de ambos numeros es " + resta);
        } else if (caracter == '*') {
            double multiplicacion = num1 * num2;
            System.out.println("La multiplicación de ambos numeros es de " + multiplicacion);
        } else if (caracter == '/') {
            double division = num1 / num2;
        } else if (caracter == '%') {
            double restoDivision = num1 % num2;
            System.out.println("El resto es  " + restoDivision);
        } else if (caracter == '^') {
            double raiz = Math.sqrt(num1);
            System.out.println("La raiz cuadrada de "  + num1+ " Es " + raiz );
            double raiz2 = Math.sqrt(num2);
            System.out.println("La raiz cuadrada de "  + num2+ " Es " + raiz2 );

        }
    }
}
