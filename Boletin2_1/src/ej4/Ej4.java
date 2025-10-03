package ej4;

import mientradasalida.MiEntradaSalida;

import java.util.IllegalFormatCodePointException;
import java.util.Random;
import java.util.Scanner;

public class Ej4 {
    static void main() {
        final int NUM_INTENTOS = 5;
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int numeroAleatorio = random.nextInt(100);
        int numero;
        do {
            System.out.println("Introduce un numero entre 1 y 100");
            numero = sc.nextInt();

        } while (numero != numeroAleatorio && NUM_INTENTOS >5);
        if (numero > numeroAleatorio){
            System.out.println("El numero introducido es mas grande que " + numero);
        } else if (numero < numeroAleatorio) {
            System.out.println("El numero oculto es mas grande que " +  numero);
        }else {
            System.out.println();
        }
        System.out.println("acertaste es el " + numeroAleatorio);
        sc.close();
    }
}
