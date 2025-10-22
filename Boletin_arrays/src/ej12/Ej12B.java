package ej12;

import java.util.Arrays;

public class Ej12B {
    static void main(String[] args) {
        int[] array = {10, 1, 4, -1, 2, 3};
        System.out.println("Array sin ordenar\n" + Arrays.toString(array));
        System.out.println(Arrays.toString(metodoBurbuja(array)));
    }

    public static int[] metodoBurbuja(int[] array) {
        boolean cambio = false;
        int temporal = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temporal = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temporal;
                    cambio = true;
                }
            }
            if (!cambio){
                break;
            }
        }
        return array;
    }
}
