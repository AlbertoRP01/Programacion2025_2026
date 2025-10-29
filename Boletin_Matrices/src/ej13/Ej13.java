package ej13;

import mientradasalida.MiEntradaSalida;

public class Ej13 {
    static void main(String[] args) {
        int[][] matriz = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 0},
                {3, 2, 1, 4, 5},
                {9, 5, 8, 6, 7},
                {0, 9, 8, 5, 4}
        };

        int[][] resultado = matrizCuadrada(matriz);

        MiEntradaSalida.imprimirUnaMatriz(resultado);
    }
    public static int[][] matrizCuadrada ( int[][] matriz){
        int n = matriz.length;
        for (int i = 0; i < n; i++) {
            if (matriz[i].length != n) {
                System.out.println("La matriz no es cuadrada");
            }
        }
        int[][] reflejada = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                reflejada[i][j] = matriz[n -1 - j][n -1 -i];
            }
        }
        return reflejada;
    }
}
