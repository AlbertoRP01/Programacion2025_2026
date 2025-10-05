package ej8;

import java.util.Scanner;

public class Ej8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a;
        double b;
        double c;

        System.out.println("Introduce el coeficiente A:");
        a = sc.nextDouble();
        System.out.println("Introduce el coeficiente B:");
        b = sc.nextDouble();
        System.out.println("Introduce el coeficiente C:");
        c = sc.nextDouble();

        // 1. Verificar si es una ecuación de segundo grado (A != 0)
        if (a == 0) {
            System.out.println("\nEl coeficiente A es 0. No es una ecuación de segundo grado.");

            // Lógica interna para la ecuación de primer grado (Bx + C = 0)
            if (b != 0) {
                double solucion_lineal = -c / b;
                System.out.println("La única solución (de primer grado) es x = " + solucion_lineal);
            } else if (c == 0) {
                System.out.println("La ecuación es 0 = 0. Son infinitas soluciones.");
            } else {
                System.out.println("La ecuación es una contradicción (ej. 5 = 0). No tiene solución.");
            }

        }
        // 2. Si A != 0, procedemos a resolver la ecuación de segundo grado
        else {
            double valorDiscriminante = b * b - 4 * a * c;

            if (valorDiscriminante > 0) {
                // Dos soluciones reales y distintas
                double x1 = (-b + Math.sqrt(valorDiscriminante)) / (2 * a);
                double x2 = (-b - Math.sqrt(valorDiscriminante)) / (2 * a);

                System.out.println("\nLa ecuación tiene dos soluciones reales distintas :");
                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);

            } else if (valorDiscriminante == 0) {
                // Una solución real (solución doble)
                double x = -b / (2 * a);
                System.out.println("\nLa ecuación tiene una solución real (solución doble):");
                System.out.println("x = " + x);

            } else {
                // Ninguna solución real
                System.out.println("\nLa ecuación tiene un discriminante negativo (" + valorDiscriminante + "). Por lo tanto, no tiene soluciones reales (tiene dos soluciones complejas).");
            }
        }
        sc.close();
    }
}