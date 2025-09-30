package ej1;

import java.util.Scanner;

public class Ej1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el numero");
        int num = sc.nextInt();
        if (num % 2 == 0) {
            System.out.println(num + " Es par  de ");
        } else {
            int suma = num + 2;
            System.out.println(num + " Es  impar  " + " por la tanto la suma de los impares es " + suma);
        }
        sc.close();
    }
}
