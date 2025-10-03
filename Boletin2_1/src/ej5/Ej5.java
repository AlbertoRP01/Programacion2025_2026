package ej5;

import mientradasalida.MiEntradaSalida;

public class Ej5 {
    static void main() {
        int numero;
        int divisores = 1;
        int exponenetes;

        do {
            numero = MiEntradaSalida.leerEntero("Introduce un numero");
        } while (numero <= 1);

        int numeroOriginal = numero; // vamos a necesitar una copia del numero original por que numero cambia su valor

        if (numero % 2 == 0 && numero != 2) { // esta condicion implemeta que el unico par que es primo es 2 y que los demas numero pares son divisores de dos por lo tanto no son primos
            System.out.println(numero + "No es primo");
        }

        for (int i = 3; i * i <= numero; i += 2) { // buscamos los divisores impares y cada divisor encontrado cuantas veces divide el numero
            exponenetes = 0;

            while (numero % i == 0) { //  Mientras que el divisor sea divisible por el divisor actual en la division sea 0
                numero = numero / i; // divides el numero entre el divisor actual
                exponenetes++; // autoincrementa el exponente
            }

            divisores = divisores * (exponenetes + 1); // calcular el total de los divisores multiplicadno el (exponente + 1)

        }
        if (numero > 1) { //
            divisores = divisores * 2;
        }
        if (divisores == 2) {
            System.out.println("Es primo");
        } else if (divisores % 2 == 0 && numero != 2) {

            System.out.println(numeroOriginal + "No es primo");
        }

    }
}
