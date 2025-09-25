import java.util.Scanner;

public class DivisorEj {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int x = 2;
        while (x <= num /2 && num % x !=0){
            x ++;
        }
        if (num % x == 0 ){

            System.out.println("El primer divisor de " + num +  " es " + x);

        }else {
            System.out.printf("El num %d  es primo ", num );
        }

    }
}
