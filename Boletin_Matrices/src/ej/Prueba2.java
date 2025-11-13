package ej;

import java.util.Scanner;

public class Prueba2 {
    static int contador(int[][] matriz, int valor, int rango) {

        //
        int n = matriz.length;
        int m = matriz[0].length;
        int contador = 0;

        // Recorremos la matriz buscando la posición del valor
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (matriz[i][j] == valor) {

                    // Recorremos el área dentro del rango
                    for (int x = i - rango; x <= i + rango; x++) {
                        for (int y = j - rango; y <= j + rango; y++) {

                            // Comprobamos que los índices estén dentro de los límites
                            if (x >= 0 && x < n && y >= 0 && y < m) {

                                // Evitamos contar la celda central
                                if (!(x == i && y == j)) {

                                    // Si es par la contamos
                                    if (matriz[x][y] % 2 == 0) {
                                        contador++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return contador;
    }

     static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] matriz = {
                {1,2,3, 4, 5},
                {6, 7, 8, 9, 0},
                {3, 2, 1, 4, 5},
                {9, 5, 8, 6, 7},
                {0, 9, 8, 5, 4}
        };

        System.out.print("Introduce el valor a buscar: ");
        int valor = sc.nextInt();

        System.out.print("Introduce el rango de búsqueda: ");
        int rango = sc.nextInt();

        System.out.printf("La cantidad de pares " + contador(matriz, valor, rango));
    }
}
