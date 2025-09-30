package ej9;

import java.util.Scanner;

public class Ej9 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int sumaDeDivisores = 0;
        int num;
        int divisores;
        do {
            System.out.println("Introduce un numero");
            num = sc.nextInt();
            for (divisores = 1; divisores < num; divisores++ ){
                if (num % divisores == 0){
                    sumaDeDivisores += divisores;
                }

            }
        }while (num <=0);
        if (sumaDeDivisores == num){
            System.out.println("El numero es perfecto");
        }else  {
            System.out.println("El numero introducido no es perfecto");
        }
        sc.close();
        }
    }
