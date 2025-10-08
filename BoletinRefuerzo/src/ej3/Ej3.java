package ej3;

import mientradasalida.MiEntradaSalida;

public class Ej3 {
    static void main(String[] args) {
       int numero = MiEntradaSalida.leerEnteroPositivo("Introduce un numero");
       String binario = "";
       int bit = numero % 2;
       while (numero > 0 ){
           bit = numero % 2;
           binario = bit + binario;
           numero = numero / 2;
       }
       System.out.println("El número binario es: " + binario);
    }
}
