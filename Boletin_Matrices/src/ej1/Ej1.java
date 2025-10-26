package ej1;

import mientradasalida.MiEntradaSalida;

import java.util.Arrays;

public class Ej1 {
    static void main(String[] args) {
        int[][] matriz = {{1, -2, 3, -4, 5}, {-6, 8, -10, 12,-14}};
        MiEntradaSalida.imprimirUnaMatriz(matriz);
        System.out.println("¿Se ha encontado un elemento negativo ? " + comprobarNegativoMartriz(matriz));
    }

    public  static boolean comprobarNegativoMartriz(int[][] matriz) {
       boolean hayElementoNegativo = false;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] < 0) {
                    hayElementoNegativo = true;
                }
            }
        }
        return hayElementoNegativo;
    }
}
