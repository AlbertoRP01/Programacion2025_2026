package ej9;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ej9 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el tamaño del array: ");
        int tamanno = sc.nextInt();

        System.out.println("\n--- 1. GENERACIÓN y ORDENACIÓN ---");

        // El método ahora pide al usuario los elementos en lugar de generarlos.
        // Se ordena de forma Ascendente (reverse = false)
        int[] arrayAscendente = pedirYOrdenarArray(sc, tamanno, false);
        System.out.println("Array Ordenado (Ascendente): " + Arrays.toString(arrayAscendente));

        // Se ordena de forma Descendente (reverse = true)
        int[] arrayDescendente = pedirYOrdenarArray(sc, tamanno, true);
        System.out.println("Array Ordenado (Descendente): " + Arrays.toString(arrayDescendente));

        System.out.println("\n--- 2. PRUEBA DE BÚSQUEDA (EJ. 8) ---");

        System.out.print("Introduce un valor para buscar en el array (el último generado): ");
        int valorBuscado = sc.nextInt();

        // Usamos el array ordenado descendentemente para la prueba de búsqueda
        int posEncontrada = mostrarPosicionArray(arrayDescendente, valorBuscado);

        if (posEncontrada != -1) {
            System.out.println(" El valor " + valorBuscado + " se encontró en el índice: " + posEncontrada);
        } else {
            System.out.println(" El valor " + valorBuscado + " NO se encontró (Devuelve: -1)");
        }

        sc.close();
    }

    /**
     *
     * @param tamanno utilizamos la variable tamaño para darle tamaño a ese array
     * @return devuelve el array con su tamaño
     */
    public static int[] pedirYOrdenarArray(Scanner sc, int tamanno, boolean reverse) {

        int[] array = new int[tamanno];

        // 1. Llenar el array PIDIENDO los valores al usuario
        System.out.println("\nIntroduce " + tamanno + " elementos para el array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print("Elemento [" + i + "]: ");
            array[i] = sc.nextInt();
        }

        // 2. Ordenación manual con Selection Sort (Controlada por 'reverse')
        for (int i = 0; i < array.length - 1; i++) {

            int indiceExtremo = i;

            for (int j = i + 1; j < array.length; j++) {

                // Lógica de comparación basada en 'reverse'
                if (!reverse) {
                    // Ascendente (busca el MÍNIMO)
                    if (array[j] < array[indiceExtremo]) {
                        indiceExtremo = j;
                    }
                } else {
                    // Descendente (busca el MÁXIMO)
                    if (array[j] > array[indiceExtremo]) {
                        indiceExtremo = j;
                    }
                }
            }

            // Intercambiar el elemento de la posición 'i' con el Mínimo/Máximo encontrado
            if (indiceExtremo != i) {
                int temp = array[i];
                array[i] = array[indiceExtremo];
                array[indiceExtremo] = temp;
            }
        }
        return array;
    }

    /**
     *
     * @param array    necesitamos el array
     * @param elemento necesitmaos el elemento al que se busca
     * @return devuelve array mostrando la posicion del array con el elemento encontrado
     */
    public static int mostrarPosicionArray(int[] array, int elemento) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == elemento) {
                return i;
            }
        }
        return -1;
    }
}
