package principal;

import clases.Biblioteca;
import clases.Pelicula;
import excepciones.PeliculaException;
import mientradasalida.MiEntradaSalida;

public class principal {
    static void main(String[] args) {
        Pelicula pelicula = new Pelicula("", 1999, 3000000, 5000000, "", "");
        Biblioteca biblioteca = new Biblioteca();
        boolean salir = false;
        int opcion = 0;
        double presupuesto = pelicula.calcularValoracion();
        try {
            pelicula.setPresupuesto(presupuesto);
        } catch (PeliculaException e) {
            System.out.println(e.getMessage());
        }
        do {
            menu();
            opcion = MiEntradaSalida.leerEntero("Introduce la opcion del 1-6");
            switch (opcion) {
                case 1: {
                    annadirLaPeli();
                }
                case 2 : {
                    biblioteca.toString();
                }
                case 3: {
                    String etiqueta = MiEntradaSalida.solicitarCadena("Introduce una etiqueta");
                    biblioteca.buscarPorEtiqueta(etiqueta);
                }
                case 4 : {
                    String titulo = MiEntradaSalida.solicitarCadena("Introduce el titulo que quieres buscar");
                    biblioteca.buscarPorTitulo(titulo);
                }
                case 5 : {
                    int buscarPresupuesto = MiEntradaSalida.leerEntero("Introduce el presupuesto que quieres buscar");
                    biblioteca.buscarPorPresupuestoMax(presupuesto);
                }
            }
        } while (salir);
    }
        public static void annadirLaPeli(){
            String titulo = MiEntradaSalida.solicitarCadena("Introduce el titulo de la película");
            int annoEstreno = MiEntradaSalida.leerEnteroPositivo("Introduce el año de estreno");
            double presupuesto = MiEntradaSalida.solicitarDouble("Introduce la recaudacion de la película");
            double  recaudacion = MiEntradaSalida.solicitarDouble("Introduce la recaudacion");
            String sinopsis = MiEntradaSalida.solicitarCadena("Introduce la sinopsis");
            String etiqueta = MiEntradaSalida.solicitarCadena("Introduce la etqueta de la película");
            Pelicula pelicula = new Pelicula(titulo, annoEstreno, presupuesto,recaudacion,sinopsis,etiqueta);
            Biblioteca biblioteca = new Biblioteca();
            biblioteca.annadirPelicula(pelicula);
        }
    public static void menu() {
        System.out.println("Bienvenido A la Biblioteca de películas");
        System.out.println("1.Añadir pelicula");
        System.out.println("2.consultar Biblioteca");
        System.out.println("3.Buscar películas por etiqueta");
        System.out.println("4.Buscar películas por título ");
        System.out.println("5.Buscar películas por máximo presupuesto");
        System.out.println("6.Salir");
    }
}
