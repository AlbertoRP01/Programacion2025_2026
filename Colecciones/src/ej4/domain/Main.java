package ej4.domain;

import ej4.exceptions.MensajeException;
import ej4.model.Alumno;
import ej4.model.Mensaje;
import ej4.model.Profesor;

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

            System.out.println("\n--- USO DE REVERSE (Ejercicio 4) ---");
            ArrayList<Mensaje> invertida = reverse((ArrayList<Mensaje>) lucas.getBuzon());
            System.out.println("Último mensaje recibido: " + invertida.get(0).getTexto());

        } catch (MensajeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static <T> ArrayList<T> reverse(ArrayList<T> original) {
        ArrayList<T> nueva = new ArrayList<>();
        for (int i = original.size() - 1; i >= 0; i--) {
            nueva.add(original.get(i));
        }
        return nueva;
    }
}