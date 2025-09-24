package ej6;

import java.util.Scanner;

public class Ej6 {
    static void main() {
        Scanner sc = new Scanner(System.in);
            System.out.println("Introduce un caracter ");
           char caracter = sc.next().charAt(0);
            if (caracter == 'a') {
                System.out.println( caracter + " Es la primera vocal ");
            } else if ( caracter == 'e' ) {
                System.out.println(caracter + "Es la segunda vocal");
            } else if (caracter == 'i') {
                System.out.println(caracter + " Es la tercera vocal ");
            } else if (caracter == 'o') {
                System.out.println(caracter+ " Es la cuarta vocal");
            } else if (caracter == 'u') {
                System.out.println(caracter + " Es la quinta vocal");
            }else {
                System.out.println(caracter+ "No es una vocal");
            }
    }
}
