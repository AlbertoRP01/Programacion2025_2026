package ej7.model;

import ej7.exceptions.RecetaException;
import mientradasalida.MiEntradaSalida;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class Receta {
    /**
     * nombre de la receta
     */
    private String nombre;

    /**
     * La duracion del tiempo de preparacion de la receta
     */
    private Duration tiempoPreparacion;

    /**
     * El conjunto de ingredientes
     */
    private Set<Ingrediente> ingredientes;

    /**
     * La lista de pasos
     */
    private LinkedList<String> pasos;

    /**
     * Constructor de la receta Se utiliza duration para saber los minutos de preparacion de la receta
     * porque utiliza el entero para luego procesarlo a minutos
     * @param nombre
     * @param minutos
     */
    public Receta(String nombre, int minutos) {
        this.nombre = nombre;
        this.tiempoPreparacion = Duration.ofMinutes(minutos);
        this.ingredientes = new HashSet<>();
        this.pasos = new LinkedList<>();
    }

    public Duration getTiempoPreparacion() {
        return tiempoPreparacion;
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

    /**
     * TODO:Busca el ingrediente existente
     * @param ingrediente la variable que se aloja en el parámetro
     * @return en el caso de que se encuentre devuelve verdadero y en el casod e que no devuelve false
     */
    public boolean necesitaIngrediente(Ingrediente ingrediente) {
        for (Ingrediente i : ingredientes) {
            if (i.getNombre().equalsIgnoreCase(ingrediente.getNombre())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Añade el ingrediente a la receta necesitando de su nombre y sumando su cantidad en el caso de que ese ingrediente
     * exista, en el caso de que no puedes  se añade su ingrediente
     * @param ingrediente la variable que se aloja en el parámetro
     */
    public void annadirIngrediente(Ingrediente ingrediente) {
        boolean enconntrado = false;
        for (Ingrediente i : ingredientes) {
            if (i.getNombre().equalsIgnoreCase(ingrediente.getNombre())) {
                i.setCantidad(i.getCantidad() + ingrediente.getCantidad());
                enconntrado = true;
                break;
            }
        }
        if (!enconntrado) {
            this.ingredientes.add(ingrediente);
        }
    }

    /**
     * Borra el ingrediente de la receta y también el paso con la condicion de que si contiene ese ingrediente a través
     * de su nombre
     * @param ingrediente la variable que se aloja en el parámetro
     * @throws RecetaException  salta la excepcion cuando no contenga ese ingrediente
     */
    public void borrarIngrediente(Ingrediente ingrediente) throws RecetaException {

        if (!ingredientes.contains(ingrediente)) {
            throw new RecetaException("El ingrediente no existe en la receta");
        }
        this.ingredientes.remove(ingrediente);

        pasos.removeIf(paso -> paso.toLowerCase().contains(ingrediente.getNombre().toLowerCase()));
    }

    /**
     * TODO: Añades un paso nuevo de la misma receta que estás editando
     * @param pasoNuevo variable que se aloja en el parámetro
     * @param pasoExistente La variable que está en el parámétro
     * @throws RecetaException Muestra la excepcion si dicho ingrediente existente no existe
     */
    public void annadirPasoDetrasDe(String pasoNuevo, String pasoExistente) throws RecetaException {
        int indice = pasos.indexOf(pasoExistente);
        if (indice == -1) {
          throw new RecetaException("El paso de referencia no existe");
        }
        pasos.add(indice + 1, pasoNuevo);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Receta receta = (Receta) o;
        return Objects.equals(nombre, receta.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }
}
