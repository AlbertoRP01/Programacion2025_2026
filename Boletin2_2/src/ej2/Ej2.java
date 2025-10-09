package ej2;

import mientradasalida.MiEntradaSalida;

public class Ej2 {
    static void main(String[] args) {
        int numero = MiEntradaSalida.leerEnteroPositivo("Introduce un numero");
        int numeroComprobante = numero;
        int numbInvertido = 0;
        while (numero != 0) {
            int resto = numero % 10;
            numbInvertido = numbInvertido * 10 + resto;
            numero /= 10;
        }
        System.out.println("Numero invertido " + numbInvertido);

        if (numeroComprobante == numbInvertido) {
            System.out.println("Es capicua ");
        } else {
            System.out.println("No es capicua");
        }
    }
}
