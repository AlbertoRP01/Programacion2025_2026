package ej5;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Ej5 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int num1;
        int num2;
        int num3;
        do {
            System.out.println("Introduce el primer numero");
            num1 = sc.nextInt();
            System.out.println("Introduce el segundo numero");
            num2 = sc.nextInt();
            System.out.println("Introduce el tercer numero");
            num3 = sc.nextInt();
        } while (num3 >= 0 && num1 < 0 && num2 < 0);
        System.out.println(num1 + " Es positivo");
        System.out.println(num2 + " Es positivo");
        System.out.println(num3 + " Es negativo");
    }
}
