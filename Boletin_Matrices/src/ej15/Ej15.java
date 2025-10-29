package ej15;

public class Ej15 {
    static void main(String[] args) {
        int columnas = 6;
        int[][] matriz = {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 25, 23, 24},
                {25, 26, 27, 28, 29, 30}
        };
        int casilla1 = obtenerNumeroCasilla(matriz, 5, columnas); // [1,5]
        int casilla2 = obtenerNumeroCasilla(matriz, 0, columnas); // [4,0]

        System.out.println("Casilla [1,5] → " + casilla1);
        System.out.println("Casilla [4,0] → " + casilla2);
    }
    public static int obtenerNumeroCasilla(int[][] matriz, int i, int j) {
        return matriz[0].length * i + j + 1;
    }
}
