package Ej2;

import java.util.Scanner;

public class Ej2 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int base;
        int exponente;
        int producto = 1;
        do {
            System.out.println("Introduce la base");
            base = sc.nextInt();
            System.out.println("Introduce el exponente");
            exponente = sc.nextInt();

        } while (base < 0 && exponente < 0);
        for (int i = 0; i < exponente; i++) {
            producto *= base;
        }
        System.out.println("El resultado es " + producto);
        sc.close();
    }
}
