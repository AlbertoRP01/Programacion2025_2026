package ej2;

import mientradasalida.MiEntradaSalida;

public class Ej2 {
     public static void main(String[] args) {
        String binario = MiEntradaSalida.leerCadena("Introduce un numero binario");
        int valorDecimal = 0;
        int potencia = 0;
        for (int i = 0; i < binario.length(); i ++ ){
            potencia =  binario.length() -1 -i; // calculamos la potencia antes de usarse
             int bitnumero = Character.getNumericValue(binario.codePointAt(i)); // buscamos el digito

             double  valorPotencia = Math.pow(2, potencia); // Uso el exponente que he calculado

            valorDecimal += bitnumero * valorPotencia; // El resultado de la multiplicacion
        }
         System.out.println("El valor decimal es " + valorDecimal);
    }
}
