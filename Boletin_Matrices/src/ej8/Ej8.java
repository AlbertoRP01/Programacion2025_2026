package ej8;

public class Ej8 {
    static void main(String[] args) {
        int[][] matriz1 = {
                {10, 5, 12},
                {98, 5, 6},
                {8, 4, 6},
        };
        int[][] matriz2 = {
                {8, 7, 5},
                {19, 56, 4},
                {8, 76, 90},
        };
        sumarContenidoMatrices(matriz1,matriz2);
    }

    /**
     *TODO: Creo un metodo para sumar ambas matrices con una tercera matriz para el resultado
     *
     * @param matriz1 primera matriz por parametro
     * @param matriz2 segunda matriz por parametro
     * @return devuelve la tercera matriz
     */
    public static int[][] sumarContenidoMatrices(int[][] matriz1, int[][] matriz2){
        int[][] matriz3 = new int[matriz1.length][matriz1[0].length];
        for (int i = 0; i < matriz1.length; i ++){
            for (int j = 0; j < matriz1[i].length; j ++){
                int numeroMatriz1 =  matriz1[i][j];
                int numeroMatriz2 = matriz2[i][j];
                int suma = matriz1[i][j]  + matriz2[i][j];
                matriz3[i][j]= suma;
            }
        }
        System.out.println("\t\t\t1\t\t\t\t\t2\t\t\t\tSuma");
        System.out.println();
        // Finalmente imprimir los resultados
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[i].length; j++) {
                System.out.printf("%5d ", matriz1[i][j]);
            }
            System.out.print(" | ");

            for (int j = 0; j < matriz2[i].length; j++) {
                System.out.printf("%5d ", matriz2[i][j]);
            }
            System.out.print(" | ");

            for (int j = 0; j < matriz3[i].length; j++) {
                System.out.printf("%5d ", matriz3[i][j]);
            }
            System.out.print(" | ");
            System.out.println();
        }
        return matriz3;
    }
    }
