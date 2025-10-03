package ej6;

import mientradasalida.MiEntradaSalida;

/**
 * Realizar un programa que lea el número de alumnos que hay en una clase.
 * A continuación debe leer la nota de cada uno de ellos en un examen y nos
 * debe informar del número de suspensos y aprobados, así como los
 * porcentajes.
 */
public class Ej6 {
    static void main() {
        int alumnos;
        int notas;
        double cantidadSuspenso = 0;
        double cantidadAprobado = 0;
        do {
            alumnos = MiEntradaSalida.leerEntero("Introduce el numero de alumnos");
        } while (alumnos < 0);
        for (int i = 0; i < alumnos; i++) {
            notas = MiEntradaSalida.leerEnteroPositivo("Introduce un numero entre 0 y 10 ");
            if (notas < 5) {
                cantidadSuspenso++;

            } else if (notas >= 5) {
                cantidadAprobado++;
            }

        }

        double resultadoAprobados = (cantidadAprobado / alumnos) * 100;
        double resultadoSuspenso = (cantidadSuspenso / alumnos) * 100;
        int suspenso = (int) resultadoSuspenso;
        int aprobado = (int) resultadoAprobados;

        System.out.println("Cantidad de aprobados es " + aprobado + " %");
        System.out.println("Cantidad de suspensos es "  + suspenso + " %");
    }
}
