package ej3;

import java.util.Scanner;

public class Ej3B {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un numero");
        String numero = sc.nextLine();
        int  a =  numero.length();
        System.out.println("El numero " + numero + " tiene " + a);
    }
}
