package ej3;

import mientradasalida.MiEntradaSalida;

public class Ej3 {
    static void main(String[] args) {
        int numeroArrays;
        numeroArrays = MiEntradaSalida.leerEntero("Introduce la cantidad de numeros de un array");

        // En el caso de que sea  0 elementos o negativo  tienes que volver a introducir el elemento
        while (numeroArrays <= 0) {
            numeroArrays = MiEntradaSalida.leerEntero("Vuelve a introducir el numero no debe ser ni negativo ni 0 ");
        }
        // El array que vamos llenar de elementos
        int[] array = new int[numeroArrays];
        //
        for (int i = 0; i < numeroArrays; i++) {
            array[i] = MiEntradaSalida.leerEntero("Introduzca el numero" + (i + 1) + ": ");
        }

        int valorMayor = array[0];

        int valorMenor = array[0];
        //Busca el elemento  mas grande y pequeño del array
        for (int a = 1; a < numeroArrays; a++) {
            if (array[a] > valorMayor) {
                valorMayor = array[a];
            }
            if (array[a] < valorMenor) {
                valorMenor = array[a];
            }
        }

        int contMayor = 0;
        int contMenor = 0;
        // busca el numero del array y se suma el contador dependiendo si el valor del numero es mayor y menor
        for (int numero : array) {
            if (numero == valorMayor) {
                contMayor++;
            }
            if (numero == valorMenor) {
                contMenor++;
            }
        }
        // Suma todos los numeros dentro del array
        int sumaArrays = 0;
        for (int numero : array) {
            sumaArrays += numero;
        }
        // Se encarga de dar la media dentro del array
        double media = (double) sumaArrays / numeroArrays;
        System.out.println("El mayor  numero introducido es " + valorMayor);

        // cuenta las veces que se repite el  numero mayor y menor
        if (contMayor > 1) {
            System.out.println("El numero mayor se repite " + contMayor + " Veces");
        }
        System.out.println("El numero menor introducido es " + valorMenor);
    }
}
