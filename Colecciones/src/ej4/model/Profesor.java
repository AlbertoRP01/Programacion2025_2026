package ej4.model;

import ej4.exceptions.MensajeException;

public class Profesor extends Persona {
    public Profesor(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void enviarMensaje(Persona destinatario, String texto) {

        destinatario.getBuzon().add(new Mensaje(this, texto));
    }

    @Override
    public String leerMensaje() throws MensajeException {
        if (getBuzon().isEmpty()) {
            throw new MensajeException("El buzón de " + getNombre() + " está vacío.");
        }
        StringBuilder sb = new StringBuilder();
        int contador = 1;
        sb.append("Buzon de: ").append(getNombre()).append("\n");
        for (Mensaje m : getBuzon()) {
            sb.append("Mensaje ").append(contador).append(": ")
                    .append(m.toString()).append("\n");
            contador++;
        }
        return sb.toString();
    }
}
