package ej5;

import java.util.Scanner;

public class Ej5B {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int contador = 0;
        System.out.println("Introduce El primer numero");
        int num1 = sc.nextInt();
        System.out.println("Introduce el segundo numero");
        int num2 = sc.nextInt();
        System.out.println("Introduce el tercer numero");
        int num3 = sc.nextInt();
        while (num1 < 0) {
            System.out.println("El numero no es valido");
            num1 = sc.nextInt();
        }
        while (num2 < 0){

        }
    }
}
