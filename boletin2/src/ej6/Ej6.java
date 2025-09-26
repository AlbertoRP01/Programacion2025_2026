package ej6;

import java.util.Scanner;

public class Ej6 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce primer numero");
        int numeroA = sc.nextInt();
        System.out.println("Introduce el segundo numero");
        int numeroB = sc.nextInt();
        int calc = 0;
        for (int i = 0; i < numeroB; i++) {
            calc += numeroA;

        }
        System.out.println("calculo " + calc);
    }
}
