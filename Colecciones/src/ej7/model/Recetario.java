package ej7.model;

import java.util.HashMap;
import java.util.Map;

public class Recetario {

    /**
     * la clave es el nombre de la receta y el valor es la receta
     */
    private Map<String, Receta> recetas;

    /**
     * El constructor de recetario inicializando el mapa de recetas
     */
    public Recetario() {
        this.recetas = new HashMap<>();
    }

}
