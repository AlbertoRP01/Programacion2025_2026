package ej5.model;

import java.util.*;

public class Diccionario {
    private Map<String, List<String>> mapaDiccionario;

    public Diccionario() {
        mapaDiccionario = new TreeMap<>();
    }

    public String annadirPalabra(String palabra, String siginificado) {
        if (mapaDiccionario.containsKey(palabra)) {
            mapaDiccionario.get(palabra).add(siginificado);
        } else {
            List<String> significados = new ArrayList<>();
            significados.add(siginificado);
            mapaDiccionario.put(palabra, significados);
        }
        return mapaDiccionario.toString();
    }
    
}

