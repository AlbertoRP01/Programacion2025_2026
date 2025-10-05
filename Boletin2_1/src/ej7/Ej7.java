package ej7;

import mientradasalida.MiEntradaSalida;

public class Ej7 {
   public static void main(String[] args) {
        int temp;
        int a;
        int b;

        a = MiEntradaSalida.leerEntero("Introduce un numero");
        b = MiEntradaSalida.leerEntero("Introduce ortro numero");

        while (b != 0){
            temp = b;
            b = a %b;
            a = temp;
        }
        System.out.println("El MCD es: " + a);
    }
}
