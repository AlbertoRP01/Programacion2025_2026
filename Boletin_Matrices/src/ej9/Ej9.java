package ej9;

import mientradasalida.MiEntradaSalida;

public class Ej9 {
    static void main(String[] args) {
        int[][] matriz = {{1, 3, 5, 6}, {4, 2, 0, 8}};
        MiEntradaSalida.imprimirUnaMatriz(matriz);
        System.out.println(simetrica(matriz));
    }

    /**
     *  TODO: Mi metodo consiste en que compruebe si es simetrica nuestra matriz desde el eje x, es decir desde la fila
     * @param matriz
     * @return
     */
    public static boolean simetrica(int [][] matriz){

        for (int i = 0; i < matriz.length /2 ; i ++){
            for (int j = 0; j < matriz[i].length; j ++){
                if (matriz[i][j] != matriz[matriz.length -1 -i][j]){
                   return false;
                }
            }
        }
        return true;
    }
}
