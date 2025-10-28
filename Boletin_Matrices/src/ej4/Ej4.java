package ej4;

public class Ej4 {
    static void main(String[] args) {
        int[][] matriz = {{1, 2,3}, {0,2,7}};
        imprimirMatrizEnUnaLinea(matriz);
    }


    /**
     * TODO: Recorremos la matriz de manera inversa y luego imprime al reves los elementos de la matriz
     * @param matriz la variable del parametro
     */
    public static void imprimirMatrizEnUnaLinea(int[][] matriz){
        for (int i = matriz.length - 1; i >= 0; i --){
            for (int j = matriz[i].length - 1; j >= 0; j --){
                System.out.print(matriz[i][j] + " ");
            }
        }
        System.out.println();
    }
}
