package ej2;

import java.util.Scanner;

public class Ej2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el primer numero");
        int num1 = sc.nextInt();
        System.out.println("Introduce el segundo numero ");
        int num2 = sc.nextInt();

        if (num1 > num2){
            System.out.println(num1 + " Es mayor que " + num2);

        } else if (num1 == num2) {
            System.out.println(num1 + " Es igual que " +num2);
        } else  {
            System.out.println(num1 + " Es menor que " +num2);
        }
    }
}
