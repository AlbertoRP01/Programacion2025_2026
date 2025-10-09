package ej3;

import mientradasalida.MiEntradaSalida;

import java.util.Scanner;

public class Ej3 {
    public static final int M = 1000;
    public static   final int D = 500;
    public static final int C = 100;
    public static final int L = 50;
    public static final int X = 10;
    public static final int V = 5;
    public static final int I = 1;

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numRomano;
        int acumulado = 0;
        int temporal = 0;
        int anterior = Integer.MAX_VALUE;
        System.out.println("Introduce el numero romano: "); // pido el numero romano
        numRomano = sc.nextLine(); // introduzco el numero romano

        for (int i = 0; i < numRomano.length(); i++) { // busco la letra del numero
            char letraActual = numRomano.charAt(i);
            int valorLetra = 0;
            int a = switch (letraActual) {
                case 'M':
                    yield M;
                case 'D':
                    yield D;
                case 'C':
                    yield C;
                case 'L':
                    yield L;
                case 'X':
                    yield X;
                case 'V':
                    yield V;
                case 'I':
                    yield I;
                default:
                    yield 0;
            };
            if (valorLetra < anterior) {
                if (temporal > 0) { // en el caso de que ese numero sea mayor que el anterior en todo caso se passa al acumulador sumando al temporal y que el temporal sea igual al valor de la letra para indicar que esa letra es ese numero
                    acumulado += temporal;
                }
                temporal = valorLetra;
            } else if (valorLetra == anterior) { // en el caso de que el valor de esa letra se la misma que el anterior lo que hace es que el acumulador guarde la suma del numero temporal y el de la letra
                acumulado += temporal + valorLetra;
                temporal = 0;
            } else { // en el caso de que no sea la condicion anterior,  el acumulador guarda la resta del valor de esa letra y el numero temporal y le damos el valor a temporal que es  0
                acumulado += valorLetra - temporal;
                temporal = 0;
            }
            anterior = valorLetra;
        }
        if (temporal > 0) { // en
            acumulado *= temporal;
        }
        System.out.printf("El numero %s en decimal es %d", numRomano, acumulado);
    }
}
