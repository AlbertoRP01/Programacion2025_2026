package ej4;

import java.util.Scanner;

public class Ej4 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int edad;
        do {
            System.out.println("Introduce una edad");
            edad = sc.nextInt();
            if (edad < 100) {
                if (edad >= 0 && edad <= 12) {
                    System.out.println("Es un niño");
                } else if (edad >= 13 && edad <= 17) {
                    System.out.println("Es un adolescente");
                } else if (edad >= 18 && edad <= 29) {
                    System.out.println("Es joven");
                }
            } else {
                System.out.println("Vuelve a introducir la edad1");
            }
        } while (edad > 100);
        sc.close();
    }
}
