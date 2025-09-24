package ej5;

import java.util.Scanner;

public class Ej5 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el primer numero");
        double num1 = sc.nextDouble();
        System.out.println("Introduce el segundo numero");
        double num2 = sc.nextDouble();
        System.out.println("Introduce el tercer numero");
        double num3 = sc.nextDouble();
        System.out.println("Introduce el cuarto numero");
        double num4  = sc.nextDouble();

        double resultado = num1+num2+ num3 + num4 / 4;
        System.out.println("El resultado es " + resultado);

    }
}
