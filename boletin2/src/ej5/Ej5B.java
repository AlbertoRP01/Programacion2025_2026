package ej5;

import java.util.Scanner;

public class Ej5B {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int contador = 0;
        System.out.println("Introduce El primer numero");
        int num1 = sc.nextInt();
        contador ++;
        while (num1 >=0 ) {
            num1 = sc.nextInt();
            contador ++;
        }
        System.out.println("has introducido " + (contador -1) + " Positivos");
        sc.close();
    }
}
