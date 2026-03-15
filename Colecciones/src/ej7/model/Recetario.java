package ej7.model;

import ej7.exceptions.RecetaException;

import java.util.*;
import java.util.stream.Collectors;

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

    public Map<String, Receta> getRecetas() {
        return recetas;
    }

    public Receta getReceta(String nombre) {
        return recetas.get(nombre);
    }

    /**
     * Añade una receta al recetario.
     * Verifica si ya existe una receta con el mismo nombre y lanza una excepción en ese caso.
     *
     * @param nuevaReceta la receta que se desea añadir al recetario
     * @throws RecetaException si ya existe una receta con el mismo nombre
     */
    public void annadirReceta(Receta nuevaReceta) throws RecetaException {
        if (recetas.containsKey(nuevaReceta.getNombre())) {
            throw new RecetaException("La receta ya existe");
        }
        recetas.put(nuevaReceta.getNombre(), nuevaReceta);
    }

    /**
     * TODO: ordena alfabeticamente el recetario,  utilice treeMap temporal para ordenar el mapa desordenado
     * de esta forma no haces un for, se ordena por su nombre y su tiempo de preparación
     *
     * @return devuelve un toString del StringBuilder que es la lista de recetas
     * @throws RecetaException Lanza la excepcion en el caso de que el recetario está vacío
     */
    public String listadoRecetasOrenadasAlfabeticamente() throws RecetaException {
        StringBuilder sb = new StringBuilder();
        if (recetas.isEmpty()) {
            throw new RecetaException("No contiene  recetas");
        }
        TreeMap<String, Receta> mapaOrdednado = recetas.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        // cuando compara las  recetas para ordenarlas son insensible a las minusculas y mayusculas
                        //de esta manera no hay problemas al comparar
                        () -> new TreeMap<>(String.CASE_INSENSITIVE_ORDER)
                ));
        mapaOrdednado.forEach((nombre, r) -> {
            sb.append(r.getNombre())
                    .append(" - ")
                    .append(r.getTiempoPreparacion().toMinutes())
                    .append(" min\n");
        });
        return sb.toString();
    }

    /**
     * TODO: Ordena de manera ascendente el recetario a traves de una lista temporal sobre el mapa para ordenarlo
     * se filtra por el metodo encontrar el ingrediente para que luego devuelve la lista y luego esa lista se ordena
     * Luego se utiliza El StringBuilder para añadir el nombre y el tiempo de preparacion del recetario,
     * para luego mostrarlo en el listado
     *
     * @param ingrediente la variable que se aloja en el parámetro
     * @return devuelve la lista del StringBuilder con el nombre de la reeceta y el tiempo de preeparación
     * @throws RecetaException lanza una excepcio si el recetario está vacío
     */
    public String listadoRecetasOrdenadasAscendente(Ingrediente ingrediente) throws RecetaException {
        List<Map.Entry<String, Receta>> listaFiltrada = recetas.entrySet()
                .stream()
                .filter(entry -> entry.getValue().necesitaIngrediente(ingrediente))
                .toList();

        if (listaFiltrada.isEmpty()) {
            throw new RecetaException("No hay recetas con ingrediente" + ingrediente.getNombre());

        }

        listaFiltrada.sort(Comparator.comparing(entry -> entry.getValue().getTiempoPreparacion()));

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Receta> entry : listaFiltrada) {
            Receta r = entry.getValue();
            sb.append(r.getNombre())
                    .append(" - ")
                    .append(r.getTiempoPreparacion().toMinutes())
                    .append(" min\n");
        }
        return sb.toString();
    }
}
