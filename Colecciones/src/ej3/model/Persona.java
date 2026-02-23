package ej3.model;

import ej3.exceptions.MensajeException;

import java.util.*;

public abstract class Persona {
    private String nombre;
    private int edad;
    private List<Mensaje> buzon;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.buzon = new ArrayList<>();

    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public List<Mensaje> getBuzon() {
        return buzon;
    }

    public abstract void enviarMensaje(Persona destinatario, String texto) throws MensajeException;


    public abstract String leerMensaje() throws MensajeException;

    public String leerOrdenado() throws MensajeException {
        if (buzon.isEmpty()) {
            throw new MensajeException("Error: El buzón está vacío");
        }
        int contador = 0;
        List<Mensaje> copia = new ArrayList<>(buzon);
        copia.sort(Comparator.comparing(m -> m.getRemitente().getNombre()));
        StringBuilder sb = new StringBuilder();
        for (Mensaje mensaje : copia) {
            contador++;
            sb.append("Mensaje: ").append(contador).append(":")
                    .append(mensaje.toString()).append("\n");

        }
        return sb.toString();
    }

    public void borrarMensaje(int numero) throws MensajeException {
        int indce = numero - 1;
        if (indce < 0 || indce >= buzon.size()) {
            throw new MensajeException("El mensaje numero" + numero + "no existe");
        }
        buzon.remove(indce);
    }

    public String buscarMensaje(String frase) throws MensajeException {
        StringBuilder sb = new StringBuilder();
        int contador = 0;
        for (Mensaje m : buzon) {
            if (m.getTexto().contains(frase)) {
                    contador ++;
                    sb.append("Mensaje: ").append(contador).append(":\n")
                            .append(m.toString()).append("\n");
            }
        }
        if (contador == 0) {
            throw new MensajeException("No se encontraron mensajes con la frase " + frase);
        }
        return sb.toString();
    }
    private static <T> ArrayList<T> reverse(ArrayList<T> arrayOriginal) {
        ArrayList<T> listaInvertida = new ArrayList<>();

        for (int i = arrayOriginal.size() - 1; i >= 0; i--) {
            listaInvertida.add(arrayOriginal.get(i));
        }

        return listaInvertida;
    }
}
