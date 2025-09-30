package ej7;

import java.util.Scanner;

public class Ej7 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cuantos numeros deseas introducir");
        double cantidadIntroducir = sc.nextInt();
        double numero;
        double suma = 0;
        for (int i = 0;  i < cantidadIntroducir; i ++){
            numero = sc.nextInt();
            suma = suma + numero;
        }
        double media = suma / cantidadIntroducir;
        System.out.println(media);
        sc.close();
    }
}
