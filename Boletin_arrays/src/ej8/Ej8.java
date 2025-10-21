package ej8;

import java.util.Random;

public class Ej8 {
    static void main() {
        int tamanno = 10;
        int[] array = generararrayAleatorio(tamanno);
        int valorA = array[5];
        int valorB = -99;
        int posicionA = mostrarPosicionArray(array, valorA);
        int posicionB = mostrarPosicionArray(array, valorB);
        System.out.println("Array generado " + java.util.Arrays.toString(array));

        System.out.println("\n Busqueda del valor " + valorA + ":");
        if (posicionA != -1){
            System.out.println("El valor SÍ está, en el índice:  " + posicionA);
        }
        System.out.println("\nBusqueda del valor " + valorB + ":");
        if (posicionB == -1){
            System.out.println("El valor no se ha encontrado por lo tanto (te devuelve -1) ");
        }
    }

    /**
     *
     * @param tamanno  utilizamos la variable tamaño para darle tamaño a ese array
     * @return devuelve el array con su tamaño
     */
    public static int[] generararrayAleatorio(int tamanno){
        Random numerosAleatorios = new Random();
        int[]  array = new int[tamanno];
        for (int i = 0; i < array.length; i ++){
            array[i] = numerosAleatorios.nextInt(1000);
        }
        return array;
    }

    /**
     *
     * @param array necesitamos el array
     * @param elemento necesitmaos el elemento al que se busca
     * @return devuelve array mostrando la posicion del array con el elemento encontrado
     */
    public static int  mostrarPosicionArray(int[] array, int elemento){
        for (int i = 0;  i < array.length; i ++){
            if (array[i] ==elemento){
                return i;
            }
        }
        return  -1;
    }
}
