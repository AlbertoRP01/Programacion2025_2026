package clases;

import excepciones.PeliculaException;

import javax.swing.*;
import java.util.Arrays;

public class Biblioteca {
    private Pelicula[] peliculas;

    public Biblioteca() {
        peliculas = new Pelicula[20];
    }

    public Pelicula[] getPeliculas() {
        return peliculas;
    }

    public boolean annadirPelicula(Pelicula pelicula) {
        for (int i = 0; i < peliculas.length; i++) {
            if (peliculas[i] == null) {
                peliculas[i] = pelicula;
                return true;
            }
        }
        System.out.println("La biblioteca está llena");
        return false;
    }

    public String buscarPorEtiqueta(String etiqueta) {
        StringBuilder sb = new StringBuilder();
        String etiquetaLower = etiqueta.toLowerCase();

        for (Pelicula p : peliculas) {
            if (p != null && p.getEtiquetas() != null &&
                    p.getEtiquetas().toLowerCase().contains(etiquetaLower)) {

                sb.append(p.getTitulo()).append("\n");
            }
        }

        // Devuelve un mensaje si no se encontró ninguna película
        return sb.length() == 0 ? "No hay películas con esa etiqueta" : sb.toString();
    }

    public String buscarPorTitulo(String titulo) {
        if (titulo == null) {
            return "Titulo no válido";
        }
        for (Pelicula p : peliculas) {
            if (p != null && p.getTitulo() != null && p.getTitulo().equalsIgnoreCase(titulo)) {
                return p.toString();
            }
        }
        return "no se encontró ninguna película con el títuo" + titulo;
    }

    public String buscarPorPresupuestoMax(double presupuesto) {
        StringBuilder sb = new StringBuilder();
        for (Pelicula p : peliculas) {
            if (p != null && p.getPresupuesto() <= presupuesto) {
                sb.append(p.getTitulo()).append("\n");
            }
        }
        return sb.length() == 0 ? "No hay peliculas con ese presupuesto" + presupuesto : sb.toString();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\tBiblioteca:");
        sb.append("\n\tPeliculas:").append(Arrays.toString(peliculas));
        return sb.toString();
    }
}
