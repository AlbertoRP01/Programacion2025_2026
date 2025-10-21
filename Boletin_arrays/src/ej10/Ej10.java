package ej10;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.Scanner;

public class Ej10 {
    static void main(String[] args) {
        // 1. Preparación: Creamos el Scanner y pedimos el tamaño.
        Scanner sc = new Scanner(System.in);
        int tamanno;

        System.out.print("Introduce el tamaño del array inicial: ");
        if (sc.hasNextInt()) {
            tamanno = sc.nextInt();
        } else {
            System.out.println("Entrada inválida. Usando tamaño 5.");
            tamanno = 5;
            sc.next();
        }



        // Pedir los datos al usuario
        int[] arrayOriginal = pedirArray(sc, tamanno);
        System.out.println("Array Original (con duplicados): " + Arrays.toString(arrayOriginal));

        // Eliminar los duplicados
        int[] arrayLimpio = eliminarDuplciados(arrayOriginal);
        System.out.println("Array sin Duplicados: " + Arrays.toString(arrayLimpio));

        //  Ordenar el array limpio (Ascendente = false)
        int[] arrayFinalAsc = ordenarArray(arrayLimpio, false);
        System.out.println("Array Final Ordenado Ascendente: " + Arrays.toString(arrayFinalAsc));

        // SEGUNDA PRUEBA: DESCENDENTE
        // (Reutilizamos el array limpio del primer paso)
        System.out.println("\n--- 2. PRUEBA DESCENDENTE (reverse = true) ---");
        int[] arrayFinalDesc = ordenarArray(arrayLimpio, true);
        System.out.println("Array Final Ordenado Descendente: " + Arrays.toString(arrayFinalDesc));

        sc.close();

    }
    public static int[] pedirArray (Scanner sc,int tamanno) {

        int[] array = new int[tamanno];


        // 1. Llenar el array PIDIENDO los valores al usuario
        System.out.println("\nIntroduce " + tamanno + " elementos para el array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print("Elemento [" + i + "]: ");
            array[i] = sc.nextInt();
        }

        return array;
    }

    /**
     *
     * @param array el array principal
     * @return devuelve  el array sin duplicados
     */
    public  static  int[] eliminarDuplciados(int[] array){

        int conteoUnicos = 0;
        // CONTAR ÚNICOS
        // (Necesita el conteo para saber el tamaño exacto del nuevo array)
        for (int i = 0; i < array.length; i++) {
            boolean esDuplicado = false;

            //Revisa SOLO los elementos anteriores (j < i)
            for (int j = 0; j < i; j++) {
                if (array[i] == array[j]) {
                    esDuplicado = true;
                    break;
                }
            }
            if (!esDuplicado) {
                // Si llegamos aquí, es la PRIMERA VEZ que vemos este número.
                conteoUnicos++;
            }

        }
        // Crea el array de destino con el tamaño que acabamos de calcular.
        int[] arraySinduplciados = new int[conteoUnicos];
        int indice = 0; // Rastrea dónde guardar en el array nuevo.

        //(Tenemos que repetir la detección porque ahora sí tenemos el array de destino)
        for (int i = 0; i < array.length; i++) {
            boolean esDuplicado = false;

            // Volvemos a revisar (j < i) para ver si es la primera aparición.
            for (int j = 0; j < i; j++) {
                if (array[i] == array[j]) {
                    esDuplicado = true;
                    break;
                }
            }

            if (!esDuplicado){
                // ¡Solo se copia  si es la primera aparición!
                arraySinduplciados[indice] = array[i]; // se copia el valor
                indice ++; //  se avanza el indicie para la siguiente copia
            }
        }
        return  arraySinduplciados;
    }
    public  static int[] ordenarArray(int[]array, boolean reverse){
        //creamos una capia del array para no modificar el original
        array = Arrays.copyOf(array, array.length);
        //  Ordenación manual con Selection Sort (Controlada por 'reverse')
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
}
