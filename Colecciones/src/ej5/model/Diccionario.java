package ej5.model;

import ej5.exceptions.DiccionarioException;
import util.MiEntradaSalida;

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

    public List<String> buscarPalabra(String palabra) throws DiccionarioException {
        if (!mapaDiccionario.containsKey(palabra)) {
           throw new DiccionarioException("No se encuentra la palabra" + palabra);
        }
        return mapaDiccionario.get(palabra);
    }
    public List<String> borrarPalabra(String palabra) throws DiccionarioException {
        if (!mapaDiccionario.containsKey(palabra)) {
            throw new DiccionarioException("No se encuentra la palabra" + palabra);
        }
        return  mapaDiccionario.remove(palabra);
    }
    public List<String> ListaPorPrefijo(String prefijo) throws DiccionarioException {
        List<String> resultados = new ArrayList<>();
        for (String palabra : mapaDiccionario.keySet()) {
            if (palabra.startsWith(prefijo)) {
                resultados.add(palabra);
            }
        }
        if (resultados.isEmpty()) {
            throw new DiccionarioException("No se encontro la prefijo" + prefijo);
        }
        return resultados;
    }
}

