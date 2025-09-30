package ej4;

import java.util.Scanner;

public class Ej4 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int num1;
        int incrementador = 1;
        do {
            System.out.println("Introduce el primer numero");
            num1 = sc.nextInt();
        int suma= num1 * (num1 + 1) /2;
            System.out.println(suma);
        }while (num1 <0 );
        sc.close();
    }
}
