package ej6;

import mientradasalida.MiEntradaSalida;

import java.util.Random;

public class Ej6 {
    static void main(String[] args) {
        // creamos el tamaño del array
        int tamanno = 15;
        //generamos el array con su tamaño correspondiente
        int[] array = generararrayAleatorio(tamanno);
        System.out.println("Array generado" + java.util.Arrays.toString(array));
        int elementoABuscar = MiEntradaSalida.leerEntero("Introduce el elemento  a buscar entre (0 y 1000)");

        if (encuentraElelemento(array, elementoABuscar)){ // En la condicion llamamos al meteodo encuentra array
            System.out.println("\n El valor de " + elementoABuscar + " Si está contenido en el array"); // una vez que la condicion sea si muesyra este mensaje
        }else {
            System.out.println("\n El valor de " + elementoABuscar + " No está contenido en el array "); // en el caso de que sea false que muestre este mensaje
        }
    }

    /**
     *
     * @param tamanno utilizamos el temaño determinado del array
     * @return devuelve el array generado
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
     * @param array necesitamos el array para que se recorra
     * @param valorEncontrado El elemento al que se debe buscar
     * @return devuelve verdadero o falso en fucnion de que se encuentre el elemento en el array
     */
    public static  boolean encuentraElelemento(int[] array, int valorEncontrado){
        for (int elemento: array){
            if (elemento == valorEncontrado){ // le damos una condicion del elemento dentro  del array si esta o no esta
                return true; //  en todo caso de que esté  devuelve verdadero
            }
        }
        return false; // en caso de que no está  devuelve falso
    }
}
