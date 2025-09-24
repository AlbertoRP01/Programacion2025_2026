package ej2;

import java.util.Scanner;

public class Ej2 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un numero");
        int numero = sc.nextInt();
        for (int i = 0 ; i  <= 10;  i ++){
            int resultado = numero * i ;
            System.out.println( numero +  " * " + i + " = " + resultado );
        }
    }
}
