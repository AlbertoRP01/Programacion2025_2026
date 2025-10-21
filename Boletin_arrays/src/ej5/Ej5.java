package ej5;

import mientradasalida.MiEntradaSalida;

import java.util.Random;

public class Ej5 {
    static void main() {
        int[] miarray = generararrayAleatorio(8);
        System.out.printf("El array devuelto tiene un tamaño de:" +  miarray.length);
    }

    /**
     * trato de generar un array aleatorio
     * @param tamanno contiene un entero que es el tamaño del array
     * @return devuelve el array
     */
    public static int[] generararrayAleatorio(int tamanno){
        Random numerosAleatorios = new Random();
        int[]  array = new int[tamanno];
        for (int i = 0; i < array.length; i ++){
            array[i] = numerosAleatorios.nextInt(1000);
        }
        return array;
    }
}
