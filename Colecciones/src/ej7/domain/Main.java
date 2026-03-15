package ej7.domain;


import ej7.exceptions.RecetaException;
import ej7.model.Ingrediente;
import ej7.model.Receta;
import ej7.model.Recetario;
import mientradasalida.MiEntradaSalida;

public class Main {
    static void main(String[] args) {
        Recetario recetario = new Recetario();
        try {
            System.out.println("=== BIENVENIDO AL RECETARIO ===");
            boolean salir = false;
            menu();
            int opcion = MiEntradaSalida.leerEntero("Elige la opcion");
            switch (opcion){
                case 1 -> {
                    String nombreReceta = MiEntradaSalida.solicitarCadena("Introduce el nombre de la receta");
                    int minutos = MiEntradaSalida.leerEntero("Introduce el timepo de preparacion (minutos):");
                    Receta receta = new Receta(nombreReceta, minutos);
                    //Ingredientes
                    int numIngrediente = MiEntradaSalida.leerEntero("Introduce el numero de ingrediente");
                    for (int i = 0; i < numIngrediente; i ++) {
                        String nombreIngrediente = MiEntradaSalida.solicitarCadena("Introduce el nombre del ingrediente");
                        double cantidad = MiEntradaSalida.solicitarDouble("Introduce la cantidad del ingrediente (Gramos):");
                        receta.annadirIngrediente(new Ingrediente(nombreIngrediente,cantidad ));

                    }
                    //pasos
                    int pasos = MiEntradaSalida.leerEntero("Introduce el numero de pasos");
                    for (int i = 0; i < pasos; i++){
                        String paso = MiEntradaSalida.solicitarCadena("paso" + (i+1) + ":");
                        receta.getPasos().add(paso);
                    }
                    recetario.annadirReceta(receta);
                    System.out.println("Receta Añadida correctamente");

                    
                }
            }
            while (!salir){
            }
        }catch (RecetaException e ){
            System.out.println(e.getMessage());
        }
    }
    public static void menu(){
        System.out.println("\nElige una opción:");
        System.out.println("1. Añadir receta");
        System.out.println("2. Listado de recetas ordenadas alfabéticamente");
        System.out.println("3. Listado de recetas por ingrediente (ordenadas por tiempo)");
        System.out.println("4. Añadir ingrediente a una receta");
        System.out.println("5. Borrar ingrediente de una receta");
        System.out.println("6. Añadir paso detrás de otro paso");
        System.out.println("7. Salir");
        System.out.print("Opción: ");
    }
}

