package ej7.domain;

import ej7.exceptions.RecetaException;
import ej7.model.Ingrediente;
import ej7.model.Receta;
import ej7.model.Recetario;
import mientradasalida.MiEntradaSalida;

public class Main {
    public static void main(String[] args) {
        Recetario recetario = new Recetario();

        boolean salir = false;
        do {
            System.out.println("=== BIENVENIDO AL RECETARIO ===");
            menu();
            int opcion = MiEntradaSalida.leerEntero("Elige la opción");

            switch (opcion) {
                case 1 -> {
                    String nombreReceta = MiEntradaSalida.solicitarCadena("Introduce el nombre de la receta");
                    int minutos = MiEntradaSalida.leerEntero("Introduce el tiempo de preparación (minutos):");
                    Receta receta = new Receta(nombreReceta, minutos);

                    // Ingredientes
                    int numIngrediente = MiEntradaSalida.leerEntero("Introduce el número de ingredientes");
                    for (int i = 0; i < numIngrediente; i++) {
                        String nombreIngrediente = MiEntradaSalida.solicitarCadena("Introduce el nombre del ingrediente");
                        double cantidad = MiEntradaSalida.solicitarDouble("Introduce la cantidad del ingrediente (gramos):");
                        receta.annadirIngrediente(new Ingrediente(nombreIngrediente, cantidad));
                    }

                    // Pasos
                    int pasos = MiEntradaSalida.leerEntero("Introduce el número de pasos");
                    for (int i = 0; i < pasos; i++) {
                        String paso = MiEntradaSalida.solicitarCadena("Paso " + (i + 1) + ":");
                        receta.getPasos().add(paso);
                    }

                    // Añadir receta al recetario con try-catch
                    try {
                        recetario.annadirReceta(receta);
                        System.out.println("Receta '" + nombreReceta + "' añadida correctamente.");
                    } catch (RecetaException e) {
                        System.out.println("No se pudo añadir la receta: " + e.getMessage());
                    }
                }

                case 2 -> {
                    try {
                        System.out.println("=== Recetas ordenadas alfabéticamente ===");
                        System.out.println(recetario.listadoRecetasOrenadasAlfabeticamente());
                    } catch (RecetaException e) {
                        System.out.println(e.getMessage());
                    }
                }

                case 3 -> {
                    String ingBuscar = MiEntradaSalida.solicitarCadena("Ingrediente a buscar");
                    Ingrediente ingObj = new Ingrediente(ingBuscar, 0);
                    try {
                        System.out.println("=== Recetas que contienen " + ingBuscar + " ===");
                        System.out.println(recetario.listadoRecetasOrdenadasAscendente(ingObj));
                    } catch (RecetaException e) {
                        System.out.println(e.getMessage());
                    }
                }

                case 4 -> {
                    String recNomadd = MiEntradaSalida.solicitarCadena("Nombre de la receta");
                    String ingAddNom = MiEntradaSalida.solicitarCadena("Nombre del ingrediente");
                    double cantAdd = MiEntradaSalida.solicitarDouble("Introduce la cantidad");
                    Receta rAdd = recetario.getReceta(recNomadd);
                    if (rAdd != null) {
                        rAdd.annadirIngrediente(new Ingrediente(ingAddNom, cantAdd));
                        System.out.println("Ingrediente añadido correctamente.");
                    } else {
                        System.out.println("Receta no encontrada.");
                    }
                }

                case 5 -> {
                    String recNomDel = MiEntradaSalida.solicitarCadena("Introduce el nombre de la receta");
                    String ingDelNom = MiEntradaSalida.solicitarCadena("Nombre del ingrediente a borrar");
                    Receta rDel = recetario.getReceta(recNomDel);
                    if (rDel != null) {
                        try {
                            rDel.borrarIngrediente(new Ingrediente(ingDelNom, 0));
                            System.out.println("Ingrediente borrado correctamente.");
                        } catch (RecetaException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Receta no encontrada.");
                    }
                }

                case 6 -> {
                    String recNomPaso = MiEntradaSalida.solicitarCadena("Introduce el nombre de la receta");
                    Receta rPaso = recetario.getReceta(recNomPaso);
                    if (rPaso != null) {
                        String pasoNuevo = MiEntradaSalida.solicitarCadena("Introduce el nuevo paso");
                        String pasoExistente = MiEntradaSalida.solicitarCadena("Introduce el paso existente detrás del cual quieres añadir");
                        try {
                            rPaso.annadirPasoDetrasDe(pasoNuevo, pasoExistente);
                            System.out.println("Paso añadido correctamente.");
                        } catch (RecetaException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Receta no encontrada.");
                    }
                }

                case 7 -> salir = true;

                default -> System.out.println("Opción no válida.");
            }

        } while (!salir);
    }

    public static void menu() {
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