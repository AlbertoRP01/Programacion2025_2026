package ej1;

import java.util.Scanner;

public class Ej1 {
    static void main(String[]agr) {
        Scanner sc = new Scanner(System.in);
        int num1;
        int num2;
        int num3;
        System.out.println("Introduce el primer numero");
        num1 = sc.nextInt();
        System.out.println("Introduce el segundo numero");
        num2 = sc.nextInt();
        System.out.println("Introduce el tercer numero");
        num3= sc.nextInt();
        if (num1 < num2 && num1 < num3 && num2 < num3){
            System.out.println(num1 +  ',' + num2 + ',' + num3);
        } else if (num1 < num2  && num1 < num3 && num3 < num2) {
            System.out.println(num1 + ',' +  num3 + ',' +  num2 );
        } else if (num2 <num1  && num2 <  num3 && num1 < num3 ) {
            System.out.println(num2 + ',' +  num1 + ',' +  num3 );
        } else if (num2 < num3 &&  num2 <num1 && num3 < num1) {
            System.out.println(num2 + ',' +  num3 + ',' +  num1 );
        } else if (num3 < num2 && num3 < num1 && num2 < num1) {
            System.out.println(num3 + ',' +  num2 + ',' +  num1 );
        } else if (num3 < num2 && num3 <num1 && num1 < num2 ) {
            System.out.println(num3 + ',' +  num2 + ',' +  num1 );
        }
    }
}
