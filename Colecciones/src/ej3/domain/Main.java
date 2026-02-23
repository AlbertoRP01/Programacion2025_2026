package ej3.domain;

import ej3.exceptions.MensajeException;
import ej3.model.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            Profesor profe = new Profesor("Don Alberto", 45);
            Alumno lucas = new Alumno("Lucas", 15);
            Alumno sara = new Alumno("Sara", 20);

            // Envíos cronológicos
            profe.enviarMensaje(lucas, "Mensaje 1: Bienvenido al curso.");
            sara.enviarMensaje(lucas, "Mensaje 2: ¿Tienes los apuntes?");
            profe.enviarMensaje(lucas, "Mensaje 3: Mañana hay examen.");

            System.out.println("--- BUZÓN CRONOLÓGICO (Antiguo -> Nuevo) ---");
            System.out.println(lucas.leerMensaje());

            System.out.println("\n--- BÚSQUEDA ---");
            System.out.println("Buscando 'examen': " + lucas.buscarMensaje("examen"));


        } catch (MensajeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


}