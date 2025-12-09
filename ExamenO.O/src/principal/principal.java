package principal;

import clases.Biblioteca;
import clases.Pelicula;
import excepciones.PeliculaException;

public class principal {
    static void main(String[] args) {
        Pelicula pelicula = new Pelicula("", 1999, 3000000, 5000000, "", "");
        Biblioteca biblioteca = new Biblioteca();
        double presupuesto = pelicula.calcularValoracion();
        try {
            pelicula.setPresupuesto(presupuesto);
        }catch (PeliculaException e ){
            System.out.println(e.getMessage());
        }

    }
    public void menu(){
        System.out.println("Bienvenido A la Biblioteca de películas");
        System.out.println("1.Añadir pelicula");
        System.out.println("2.consultar Biblioteca");
        System.out.println("3.Buscar películas por etiqueta");
        System.out.println("4.Buscar películas por título ");
        System.out.println("5.Buscar películas por máximo presupuesto");
        System.out.println("6.Salir");
    }
}
