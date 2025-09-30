package ej8;

import java.util.Scanner;

public class Ej8 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int h1;
        int min1;
        int se1;
        int h2;
        int min2;
        int se2;
        do {
            System.out.println("Introduce una hora ");
            h1 = sc.nextInt();
            System.out.println("Introduce un minuto ");
            min1 = sc.nextInt();
            System.out.println("Introduce un   segundo ");
            se1 = sc.nextInt();
            System.out.println("Introduce otra hora ");
            h2 = sc.nextInt();
            System.out.println("Introduce otro minuto");
            min2 = sc.nextInt();
            System.out.println("Introduce otro segundo");
            se2 = sc.nextInt();

            if (h1 + min1 + se1 == h2 + min2 + se2){
                System.out.println(h1+":" + min1 + ":" + se1 + "Es igual que " + h2 + ":" + min2 + ":" + se2 );

            } else if (h1 + min1 + se1 > h2 + min2 + se2) {

                System.out.println(h1+":" + min1 + ":" + se1 + "Es Mayor que  " + h2 + ":" + min2 + ":" + se2);

            } else if (h1 + min1 + se1 < h2 + min2 + se2) {

                System.out.println(h2+":" + min2 + ":" + se2 + "Es Mayor que  " + h1 + ":" + min1 + ":" + se1);

            }
        }while (h1 >23 || h2 > 23 || min1 >59 || min2 > 59 || se1 > 59 || se2 > 59 );
    sc.close();
    }
}
