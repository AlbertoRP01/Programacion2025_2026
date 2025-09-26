package ej8;

import java.util.Scanner;

public class Ej8 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int num;
        char respuesta;
        int  numeroIntroducido = 0;
        do {
            System.out.println("Introduce un numero");
            num = sc.nextInt();
            System.out.println("¿Quieres seguir introduciendo numeros? ");
            respuesta = sc.next().charAt(0);
            if (num > numeroIntroducido){
                num = numeroIntroducido;
            }
        }while (respuesta != 'S');

        System.out.println("El numero pequeño es " +  num);
    }
}
