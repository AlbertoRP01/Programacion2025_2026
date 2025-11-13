package ej2;

public class EJ2Solucion {
    final static int[][] JARDIN = {
            {1, 0, 0, 0, 1, 0, 0, 0, 2, 1, 1, 0, 0, 5, 0},
            {0, 2, 0, 5, 0, 0, 3, 0, 1, 0, 0, 0, 1, 0, 0},
            {3, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 2, 4},
            {0, 0, 2, 0, 0, 0, 0, 0, 2, 1, 3, 0, 0, 0, 1},
            {0, 0, 1, 0, 0, 0, 3, 0, 1, 0, 0, 0, 0, 0, 3},
            {4, 3, 0, 0, 0, 2, 1, 0, 0, 0, 0, 5, 0, 0, 0},
            {1, 2, 0, 5, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
            {3, 0, 0, 0, 0, 0, 2, 1, 4, 0, 0, 0, 1, 0, 0},
            {2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 0},
            {0, 0, 5, 1, 0, 0, 0, 5, 0, 3, 0, 0, 1, 0, 0},
            {1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 5, 2, 4, 0},
            {0, 0, 1, 3, 0, 0, 1, 0, 0, 1, 0, 0, 1, 3, 0},
            {0, 1, 2, 1, 0, 0, 0, 0, 0, 2, 3, 1, 0, 0, 1},
            {1, 3, 4, 0, 0, 5, 0, 0, 1, 0, 0, 0, 0, 4, 2}
    };
    public static final int SEMILLA = 1;
    public static final int AGUA = 2;
    public static final int MALAHIERVA = 3;
    public static final int GUSANO = 4;
    public static final int ABEJA = 5;


    static void main(String[] args) {
        recorerJardin(JARDIN);

    }

    public static void recorerJardin(int[][] jardin) {
        for (int i = 0; i < jardin.length; i++) {
            for (int j = 0; j < jardin[i].length; j++) {
                if (jardin[i][j] == SEMILLA && florece(jardin, i, j)) {
                    System.out.printf("La flor de la posición %d,%d florecerá\n", i, j);
                }
            }
        }

    }

    public static boolean buscaElemento(int[][] matriz, int fila, int columna, int rango, int elementoBuscar) {

        for (int i = fila - rango; i <= fila + rango; i++) {
            for (int j = columna - rango; j <= columna + rango; j++) {
                if (i == fila && j == columna) continue;
                if (i >= 0 && i < matriz.length && j >= 0 && j < matriz[0].length) {
                    if (matriz[i][j] == elementoBuscar) return true;
                }

            }

        }
        return false;
    }

    public static boolean florece(int[][] jardin, int fila, int columna) {
        return hayAgua(jardin, fila, columna) && hayAbeja(jardin, fila, columna) && (!hayMalaHierva(jardin, fila, columna) || hayMalaHierva(jardin, fila, columna) && hayGusano(jardin, fila, columna));
    }

    public static boolean hayAgua(int[][] matriz, int fila, int columna) {
        return buscaElemento(matriz, fila, columna, 1, AGUA);
    }

    public static boolean hayMalaHierva(int[][] matriz, int fila, int columna) {
        return buscaElemento(matriz, fila, columna, 1, MALAHIERVA);
    }

    public static boolean hayGusano(int[][] matriz, int fila, int columna) {
        return buscaElemento(matriz, fila, columna, 1, GUSANO);
    }

    public static boolean hayAbeja(int[][] matriz, int fila, int columna) {
        return buscaElemento(matriz, fila, columna, 3, ABEJA);
    }


}
