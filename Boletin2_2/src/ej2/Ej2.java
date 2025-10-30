package ej2;

import mientradasalida.MiEntradaSalida;

import java.security.PublicKey;

public class Ej2 {
    static void main(String[] args) {
        int[][] matriz = {{1, -2, 3, -4, 5}, {-6, 8, -10, 12,-14}};
        MiEntradaSalida.imprimirUnaMatriz(matriz);
        System.out.println("La suma total de los elementos de la matriz es " + sumaPosicionesMatriz(matriz));
    }

    /**
     * TODO: SUMA EL TOTAL DE LOS ELEMENTOS DE LA MATRIZ
     * @param matriz
     * @return devuelve la suma de los elementos
     */
    public static int sumaPosicionesMatriz(int[][]matriz){
        int suma = 0; // inicializamos a 0 el acumulador
        for (int i = 0; i < matriz.length; i++){
            for (int j  = 0; j < matriz[i].length; j ++){
                suma += matriz[i][j]; //  una vez recorrido todos los elementos encontrados para luego sumarlos
            }
        }
        return  suma;
    }
}
