package ej7;

import java.util.Scanner;

public class Ej7 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce tu Estado Civil");
        char estadoCivil = sc.next().charAt(0);
        System.out.println("Introduce una edad ");
        int edad = sc.nextInt();
        if (estadoCivil == 's'&&  edad < 35 || estadoCivil == 'd' && edad <35){
            System.out.println("Tienes una retencion de un 12 %");

        } else if (estadoCivil == 'v' && edad <35 || estadoCivil == 'c' && edad <35 ) {
            System.out.println("Tienes una rentencion de un 11.3% ");

        } else if (edad > 50 ) {
            System.out.println("Tienes una rentencion de un 8.5 %");
        }else {
            System.out.println("Tienes una rentencion de 10.5 %");
        }
    }
}
