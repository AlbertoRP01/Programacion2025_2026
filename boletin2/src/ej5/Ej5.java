package ej5;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Ej5 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int num1;


        int contador = 0;
        do {
            System.out.println("Introduce un  numero");
            num1 = sc.nextInt();
            contador ++;
        } while ( num1 >= 0 );
        System.out.println("Has introducido "+ (contador   -1) + " numeros positivos");
    }
}
