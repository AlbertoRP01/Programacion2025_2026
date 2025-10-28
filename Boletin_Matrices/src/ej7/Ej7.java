package ej7;

import mientradasalida.MiEntradaSalida;

public class Ej7 {
    static void main(String[] args) {
        int[][] matriz = {{1, 3, 5,}, {0, 2, 7}};
        int[][] matriz2 = {{1, 3, 5,}, {0, 2, 7}};
        MiEntradaSalida.imprimirUnaMatriz(matriz);
        System.out.println();
        MiEntradaSalida.imprimirUnaMatriz(matriz2);
        System.out.println(comprobarDosMatricesIguales(matriz, matriz2));
    }


    public static boolean comprobarDosMatricesIguales(int[][] matriz1, int[][] matriz2) {
        boolean sonIguales = true;
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[i].length; j++) {

            }
        }
        System.out.println();
        for (int i = 0; i < matriz2.length; i++) {
            for (int j = 0; j < matriz2[i].length; j++) {
                if (matriz1[i][j] != matriz2[i][j]) {
                    sonIguales = false;
                }
            }
        }
        return sonIguales;
    }
}