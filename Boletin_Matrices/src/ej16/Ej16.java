package ej16;

import mientradasalida.MiEntradaSalida;



public class Ej16 {
    static void main(String[] args) {
        int[][]matriz1 = {
                {1, 2, 3, 4 ,5},
                {6 ,7 ,8 ,9, 0},
                {3 ,2 ,1 ,4 ,5},
                {9, 5 ,8 ,6 ,7},
                {0, 9 ,8, 5 ,4 }
        };
        MiEntradaSalida.imprimirUnaMatriz(matriz1);
        System.out.println();
        int n = matriz1.length;
        int[][] matriz2 = new int[n][n];
        AdyacentesPares(matriz1, matriz2);

        MiEntradaSalida.imprimirUnaMatriz(matriz2);
    }

   public  static int[][] AdyacentesPares(int[][] matriz1, int[][] matriz2){
        for (int i = 0; i < matriz2.length; i ++){
            for (int j = 0; j < matriz2[i].length; j ++){
                matriz2[i][j] = matriz1[i][j];
            }
        }
        for (int i = 0; i < matriz1.length; i ++){
            for (int j= 0; j < matriz1[i].length; j ++){
                int contador = 0;
                if (matriz1[i][j] % 2 != 0){
                    for (int x =  i -1; x <= i +1; x ++){
                        for (int y =  j -1; y <=  j +1; y ++ ){
                            if (x >= 0 && x < matriz1.length && y >= 0 && y < matriz1[0].length ){
                                    if (! (x == i && y == j)){
                                        if (matriz1[x][y] % 2 == 0){
                                            contador ++;
                                            matriz2[i][j] = contador;
                                        }
                                    }

                            }

                        }
                        matriz2[i][j] =contador;
                    }

                }

            }

        }

        return matriz2;
    }

}
