package ej3;

import java.util.Scanner;

public class Ej3 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int num1;
        int num2;
        int num3;
        int num4;
        do {
            System.out.println("Introduce un numero");
            num1 = sc.nextInt();
            System.out.println("Introduce un otro numero");
            num2 = sc.nextInt();
            System.out.println("Introduce otro numero");
            num3 = sc.nextInt();
            System.out.println("Introduce otro numero");
            num4 = sc.nextInt();
            for (int i = 1; i <= 100; i ++){
                if (num1 %  i == 0 ){
                    System.out.println(num1 + " Es multiplo de " + i);
                }else {
                    System.out.println(num1 + " No es multiplo de " + i);
                }
                if (num2 % i == 0){
                    System.out.println(num2 + " Es multiplo de " + i );
                }else {
                    System.out.println(num2 + " No es multiplo de " +i );
                }
                if (num3 % i == 0){
                    System.out.println(num3 + " Es un multiplo de " +i);
                }else {
                    System.out.println(num3 + " No es multiplo de " +i);
                }
                if (num4 % i == 0){
                    System.out.println( num4 + " Es multiplo de " + i );
                }else {
                    System.out.println(num4 + " No es multiplo de " +i);
                }
            }
        }while (num1 > 0 && num2 > 0  && num3 > 0 && num4 > 0);
        sc.close();
    }
}
