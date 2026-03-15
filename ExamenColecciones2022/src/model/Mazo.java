package model;

import exceptions.MazoException;

import javax.print.DocFlavor;
import java.util.*;
import java.util.stream.Collectors;

public class Mazo {
    private Map<Cromo, Integer> coleccion = new HashMap<>();

    public Map<Cromo, Integer> getColeccion() {
        return coleccion;
    }

    public void addCromo(Cromo c) {
        //if (c == null) return;
        //coleccion.put(c, coleccion.getOrDefault(c, 0)+ 1);
        //usar de compute: k es la llave(el cromo),  es el valor actual (la cantidad)
        coleccion.compute(c, (k, v) -> (v == null) ? 1 : v + 1);
    }

    public void intercambiar(Cromo mio, Cromo otro) throws MazoException {
        if (!coleccion.containsKey(mio)) {
            throw new MazoException("No tienes cromo" + mio.getNombre());
        }
        coleccion.computeIfPresent(mio, (c, v) -> v > 1 ? v - 1 : null);
        addCromo(otro);
    }

    public void mezclar(Mazo otro) {
        otro.getColeccion().forEach((cromo, cantidad) -> {
            this.getColeccion().merge(cromo, cantidad, Integer::sum);
        });
    }

    public int contarDiferentes() {
        return coleccion.size();
    }

    public List<Cromo> cromosDeUnEquipo(String nombreDelEquipo) {
        return coleccion.keySet().stream().filter(c -> c.getEquipo().equalsIgnoreCase(nombreDelEquipo)).toList();
    }

    public List<String> equipoCompleto() {
        return coleccion.keySet().stream()
                .collect(Collectors.groupingBy(Cromo::getEquipo))
                .entrySet()
                .stream()
                .filter(entry -> {
                    List<Cromo> cromos = entry.getValue();
                    boolean tieneEscudo = cromos.stream().anyMatch(c -> c instanceof Escudo);
                    boolean tieneJugador = cromos.stream().anyMatch(c -> !(c instanceof Escudo));
                    return tieneEscudo && tieneJugador;
                })
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<Cromo> ordenar() {
        return coleccion.keySet().stream()
                .sorted(Comparator.comparing(( Cromo c )-> !(c instanceof Escudo))
                        .thenComparing(Comparator.comparing(Cromo::getNombre, Comparator.nullsLast(String::compareTo)))
                ).toList();
    }

    public List<Cromo> getLista() {
        return  coleccion.keySet().stream().collect(Collectors.toList());
    }
    public double alturaMedia(String nombreEquipo) throws MazoException {
        return coleccion.keySet().stream()
                .filter(c -> c instanceof Jugador)
                .filter(c -> c.getEquipo().equalsIgnoreCase(nombreEquipo))
                .distinct().mapToDouble(c ->  ((Jugador) c).getAltura())
                .average()
                .orElseThrow(() -> new MazoException("No hay jugadores para el equipo" + nombreEquipo
                ));

    }
}