package ej1;

import mientradasalida.MiEntradaSalida;

public class Ej1 {
    static void main(String[] args) {
        int numero = MiEntradaSalida.leerEnteroPositivo("Introduce un numero");
        int numbInvertido = 0;
        while (numero !=0){
            int resto = numero % 10;
            numbInvertido = numbInvertido * 10 + resto;
            numero /=10;
        }
        System.out.println("Numero invertido " + numbInvertido);
    }
}