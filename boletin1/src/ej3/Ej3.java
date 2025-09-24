package ej3;

import java.util.Scanner;

public class Ej3 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un numero");
        int num = sc.nextInt();
        if (num % 2 == 0 && num % 3 == 0){
            System.out.printf( num + " Es multiplo de 2 y de 3");
        } else if (num % 2 == 0) {
            System.out.println(num + " Es multiplo de 2 ");
        } else if (num % 3 == 0) {
            System.out.println(num + " Es multiplo de 3 ");
        }else {
            System.out.println( num + " No es multiplo de 2 ni de 3 ");
        }
    }
}
