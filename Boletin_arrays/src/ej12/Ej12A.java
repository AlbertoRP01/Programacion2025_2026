package ej12;

public class Ej12A {
    static void main(String[] args) {

    }

    public static int[] metodoBurbuja(int[] array) {
        boolean cambio = false;
        int temporal = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temporal = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temporal;
                }
            }
        }
        return array;
    }
}
