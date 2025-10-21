package ej4;

import java.util.Random;

public class Ej4 {

    // CONSTANTE: Cantidad total de números a generar (6000)
    public static final int NUMEROS = 6000;

    public static void main(String[] args) {
        // 1. PREPARACIÓN DE DATOS
        // Array para guardar el conteo de los 10 dígitos (índice 0 a 9)
        int[] conteosDigitos = new int[10];

        // 2. RECOLECCIÓN DE DATOS
        // Llama a la función, pasa el array y guarda la suma total devuelta.
        long sumaTotal = generarNumerosAleatorios(conteosDigitos);

        // 3. CÁLCULO DE LA MEDIA (Requisito 1)
        double media = calcularMedia(sumaTotal);

        // 4. BÚSQUEDA DEL DÍGITO GANADOR (Requisito 2)
        // Pasa el array lleno de conteos y guarda el dígito (índice) que ganó.
        int digitoGanador = encontrarDigitoMasRepetido(conteosDigitos);

        // 5. PRESENTACIÓN DE RESULTADOS
        System.out.println("--- Resultados del Análisis Estadístico ---");
        System.out.println("1. Total de números generados: " + NUMEROS);
        System.out.printf("2. La media de los números es: %.2f\n", media);
        System.out.println("3. El dígito en el que más números terminan es: " + digitoGanador);
        System.out.println("   (Con un total de " + conteosDigitos[digitoGanador] + " repeticiones)");
    }

// ====================================================================================

    /**
     * Genera 6000 números aleatorios (0-100), calcula la suma total
     * y llena el array contador de dígitos.
     * @param array El array de 10 posiciones que almacena los conteos de dígitos.
     * @return La suma total de los 6000 números generados (tipo long).
     */
    public static long generarNumerosAleatorios(int[] array) {
        Random numeroAleatorios = new Random();
        int numeroGenerado;
        long sumaTotal = 0; // Para la suma de 6000 números entre 0-100 (máx 600,000)

        for (int i = 0; i < NUMEROS; i++) {
            // 1. Genera un número aleatorio de 0 a 100 (bound: 101 es exclusivo)
            numeroGenerado = numeroAleatorios.nextInt(101);

            // 2. Acumula la suma total
            sumaTotal += numeroGenerado;

            // 3. Cuenta el último dígito (usando el módulo % 10 como índice)
            array[numeroGenerado % 10]++;
        }

        return sumaTotal;
    }

// ------------------------------------------------------------------------------------

    /**
     * Calcula la media de los números de forma precisa.
     * @param sumaTotal La suma de todos los números generados.
     * @return El resultado de la media con decimales (tipo double).
     */
    public static double calcularMedia(long sumaTotal) {
        // Casting a (double) para asegurar una división decimal
        return (double) sumaTotal / NUMEROS;
    }

// ------------------------------------------------------------------------------------

    /**
     * Recorre el array de conteos para encontrar el índice (dígito) con el valor más alto.
     * @param conteoDigitos El array con los conteos de cada dígito (índices 0-9).
     * @return El dígito (0-9) que apareció más veces.
     */
    public static int encontrarDigitoMasRepetido(int[] conteoDigitos) {
        // Inicialización: Asumimos que el dígito 0 es el ganador inicial
        int contadorMax = conteoDigitos[0]; // Guarda el VALOR del conteo
        int digitoGanador = 0;             // Guarda el ÍNDICE (el dígito)

        // Recorre desde el índice 1 hasta el final
        for (int i = 1; i < conteoDigitos.length; i++) {
            // Comparación: Si el conteo actual es mayor que el máximo guardado
            if (conteoDigitos[i] > contadorMax) {
                // 1. Actualiza el valor MÁXIMO
                contadorMax = conteoDigitos[i];

                // 2. Actualiza el ÍNDICE (el dígito) del ganador
                digitoGanador = i;
            }
        }

        return digitoGanador;
    }

}
