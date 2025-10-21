package ej1;

public class Ej1 {
    static void main(String[] args) {
        int[] numeros = {7, -3, 234, 56, 7,2,-4,62,78,-225 };
        int sumaPares = 0;
        for (int i = 0; i < numeros.length; i += 2){
            sumaPares += numeros[i];
        }
        System.out.println("La de posiciones de los pares seria " + sumaPares);
    }
}
