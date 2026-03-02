package ej7.model;

import ej7.exceptions.RecetaException;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class Receta {
    private String nombre;
    private Duration tiempoPreparacion;
    private Set<Ingrediente> ingredientes;
    private LinkedList<String> pasos;

    public Receta(String nombre, int minutos) {
        this.nombre = nombre;
        this.tiempoPreparacion = Duration.ofMinutes(minutos);
        this.ingredientes = new HashSet<>();
        this.pasos = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Set<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public LinkedList<String> getPasos() {
        return pasos;
    }

    public boolean necesitaIngrediente(Ingrediente ingrediente) {
        for (Ingrediente i : ingredientes) {
            if (i.getNombre().equalsIgnoreCase(ingrediente.getNombre())) {
                return true;
            }
        }
        return false;
    }

    public void annadirIngrediente(Ingrediente ingrediente) {
        boolean enconntrado = false;
        for (Ingrediente i : ingredientes) {
            if (i.getNombre().equalsIgnoreCase(ingrediente.getNombre())) {
                i.setCantidad(ingrediente.getCantidad() + ingrediente.getCantidad());
                enconntrado = true;
                break;
            }
        }
        if (!enconntrado) {
            this.ingredientes.add(ingrediente);
        }
    }

    public void BorrarIngrediente(Ingrediente ingrediente) throws RecetaException {
        if (!ingredientes.contains(ingrediente)) {
            throw new RecetaException("El ingrediente no existe en la receta");
        }
        this.ingredientes.remove(ingrediente);

        pasos.removeIf(paso -> paso.toLowerCase().contains(ingrediente.getNombre().toLowerCase()));
    }
    public void annadirPasoDetrasDe(String pasoNuevo, String pasoExistente) throws RecetaException {
        int indice = pasos.indexOf(pasoExistente);
        if (indice == -1) {
          throw new RecetaException("El paso de referencia no existe");
        }
        pasos.add(indice + 1, pasoNuevo);
    }
}
