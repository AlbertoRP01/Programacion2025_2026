package ej5.principal;

import ej5.clase.Linea;
import ej5.clase.Punto;
import ej5.excepciones.LineaException;

public class Main {
    static void main(String[] args) {
        Punto punto3 = new Punto(0, 1);
        Punto punto4 = new Punto(1, 2);
        Punto punto1 = new Punto(1, 1);
        Punto punto2 = new Punto(2, 2);
        Linea linea = new Linea(punto1, punto2);
        Linea linea1 = new Linea(punto3, punto4);
        if (linea1.equals(linea)) {
            System.out.println("Son iguales");
        } else {
            System.out.println("No son iguales");
        }
        try {
            linea1.moverArriba(1);
        } catch (LineaException e) {
            System.out.println(e.getMessage());
        }

        if (linea1.equals(linea)) {
            System.out.println("Son iguales");
        } else {
            System.out.println("No son iguales");
        }
    }

    public void menu() {
        System.out.println("----------Menu----------");
    }
}
