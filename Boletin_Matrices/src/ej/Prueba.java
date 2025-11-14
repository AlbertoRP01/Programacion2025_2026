package ej;

import java.util.Scanner;

public class Prueba {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matriz =  {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25},
                {26,27,28,29,30}};
     /*  System.out.println("Introduce la Fila");
       int fila = sc.nextInt();
        System.out.println("Introduce la columna");
       int columna = sc.nextInt();
        System.out.println(String.valueOf (matriz[fila][columna]));
        System.out.println("BuscarValor1");
        int buscarValor1 = sc.nextInt();
        System.out.println("Buscar valor2");
        int buscarValor2 = sc.nextInt();
        System.out.print(String.valueOf (matriz[fila + buscarValor1] [columna + buscarValor2]));
        */
        /*System.out.println("BuscarValor3");
        int buscarValor3 = sc.nextInt();
        System.out.println("Buscarvalor4");
        int buscarValor4 = sc.nextInt();
         for (int i = 0 ; i <= buscarValor3 ; i ++){
           for (int j = 0 ; j <= buscarValor4 ; j ++){
               System.out.print(String.valueOf (matriz[i][j] + " "));
            }
        }
         */
        System.out.println("BuscarValor5");
        int buscarValor5 = sc.nextInt();
        System.out.println("Buscarvalor6");
        int buscarValor6 = sc.nextInt();
        System.out.println("PuntoDeBusqueda");
        int puntoDeBusqueda = sc.nextInt();

        for (int i = puntoDeBusqueda -3; i >= puntoDeBusqueda + 3; i ++){
            for (int j =  puntoDeBusqueda -3; j >=  puntoDeBusqueda + 3; i ++){

            }
        }
        int[][] direcciones = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1},           {0, 1},
                {1, -1},  {1, 0},  {1, 1}
        };
        int contador = 0;
        for (int[] dir : direcciones) {
            int ni = matriz.length + dir[0];
            int nj = matriz.length + dir[1];
            if (ni >= 0 && ni < buscarValor5 && nj >= 0 && nj < matriz.length ) {
                // Si el valor del vecino es par (incluido 0)
                if (matriz[ni][nj] % 2 == 0) {
                    contador++;
                }
            }
        }
        System.out.println("la cantidad de pares es " + contador);
    }
}
