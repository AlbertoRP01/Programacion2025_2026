package ej1.principal;

import ej1.persona.Persona;

import java.time.LocalDate;

public class Main {
    static void main(String[] args) {
        Persona persona = new Persona("Alberto", LocalDate.of(2001, 10, 12), 29623195, 'M', 1.61F, 84);
        System.out.println(persona.toString());
        System.out.printf("El IMC es de: %s es %.2f " , persona.getNombre(), persona.getIMC());
        System.out.println();
        System.out.println("La letra del dni es : " + persona.getNombre() + " " + persona.letraDni());
    }
}
