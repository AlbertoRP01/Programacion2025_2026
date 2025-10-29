package ej10;

import mientradasalida.MiEntradaSalida;

public class Ej10 {
    static void main(String[] args) {
        int[][] matriz = {
                {1, 2, 1},
                {3, 4, 3},
                {5, 6, 5}
        };
        int[][] matriz2 = {
                {1, 7, 3},
                {2, 4, 9},
                {8, 5, 6}};
        MiEntradaSalida.imprimirUnaMatriz(matriz);
        System.out.println(simetrica(matriz));
        MiEntradaSalida.imprimirUnaMatriz(matriz2);
        System.out.println(simetrica(matriz2));
    }

    /**
     * TODO: comprueba si la matriz es simetrtica desde el eje Y es decir desde la columna
     * @param matriz la variable del parametro
     * @return  devuelve la matriz
     */
    public static boolean simetrica(int[][] matriz) {

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length / 2; j++) {
                if (matriz[i][j] != matriz[i][matriz.length - 1 - j]) {
                    return false;
                }
            }
            System.out.println();
        }
        return true;
    }
}
