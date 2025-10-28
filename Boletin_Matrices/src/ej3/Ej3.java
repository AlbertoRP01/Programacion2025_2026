package ej3;

public class Ej3 {
    static void main(String[] args) {
        int[][] matriz = {{1, 2,3}, {0,2,7}};
        imprimirMatrizEnUnaLinea(matriz);
    }


    /**
     * TODO: Imprime esta matriz en solo una linea utilizando el print
     * @param matriz la variable del  parametro
     */
    public static void imprimirMatrizEnUnaLinea(int[][] matriz){
        for (int i = 0; i < matriz.length; i ++){
            for (int j = 0 ; j < matriz[i].length; j ++){
                System.out.print(matriz[i][j] + " ");
            }
        }
        System.out.println();
    }
}
