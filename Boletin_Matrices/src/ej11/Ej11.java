package ej11;

public class Ej11 {
    static void main(String[] args) {
        int[][] matrizA = {
                {5, 8, 9, 0},
                {2, 3, 7, 1},
                {4, 7, 5, 2},
                {1, 7, 3, 2}
        };

        int[][] matrizB = {
                {2, 3, 7, 1},
                {4, 7, 5, 2},
                {0, 9, 8, 5},
                {2, 1, 7, 4}
        };

        if (comprobarMatricesInversas(matrizA, matrizB)) {
            System.out.println(" Las matrices son inversas (índices opuestos).");
        } else {
            System.out.println(" Las matrices NO son inversas.");
        }
    }

    /**
     * TODO: COMPRUEBA SI ESAS DOS MATRICES SON IVERSAS DESDE SUS INDICES OPUESTOS
     * @param matriz1 VARIABLE DEL PARÁMETRO
     * @param matriz2 VARIVABLE DEL PARÁMETRO
     * @return DEVUELVE UN BOOLEANO VERDADERA EN EL CASO DE QUE COINCIDEN
     */
    public static boolean comprobarMatricesInversas(int[][] matriz1, int[][] matriz2) {

        for (int i = 0; i < matriz1.length; i ++){
            for (int j = 0; j < matriz1[i].length; j ++){
                if (matriz1[i][j] != matriz2[matriz2.length -1 -i][matriz2.length - 1 - j]){
                    return false;
                }
            }
        }
        return true;
    }
}
