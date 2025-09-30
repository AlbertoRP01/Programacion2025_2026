package ej4;

import mientradasalida.MiEntradaSalida;

import java.util.Random;
import java.util.Scanner;

public class Ej4 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int numeroAleatorio = random.nextInt(100);
        int numero;
        do {
            System.out.println("Introduce un numero entre 1 y 100");
            numero = sc.nextInt();

        } while (numero != numeroAleatorio);
        System.out.println("acertaste es el " + numeroAleatorio);
        sc.close();
    }
}
