package ej3;

import mientradasalida.MiEntradaSalida;

import java.util.Scanner;

public class Ej3 {
    /*
    Realizar un programa que solicite un número entero y determine el número
   de cifras que tiene dicho número.
   introduce un numero: 124
   El numero 124 tiene 3 cifras
     */
    static void main() {
        Scanner sc = new Scanner(System.in);
        int numero = MiEntradaSalida.leerEntero("Introduce un numero");
        int contador = 1;
        while (numero / 10 != 0) {
            numero = numero / 10;
            contador++;
        }
        System.out.println("El numero " + numero + " tiene " + contador);
        sc.close();
    }
}
