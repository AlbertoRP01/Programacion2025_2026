package ej4.principal;

import ej4.clases.Clerigo;
import ej4.clases.Mago;
import ej4.clases.Personaje;
import ej4.enums.TRaza;
import ej4.excepciones.PersonajeException;
import mientradasalida.MiEntradaSalida;

import java.util.Arrays;

public class Main {
    static void main(String[] args) {
        Personaje[] personajes = new Personaje[100];
        boolean salir = false;
        int opcion;
        do {
            menu();
            opcion = MiEntradaSalida.leerEntero("Introduce una opcion");
            switch (opcion) {
                case 1 -> {
                    altaPersonaje(personajes);
                }
                case 2 -> {
                    magoAprendeHechizo(personajes);
                }
                case 3 -> {
                    magoLanzaHechizo(personajes);
                }
                case 4 -> {
                    clerigoCuraMago(personajes);
                }
                case 5 -> {
                    System.out.println(Arrays.toString(personajes));

                }
                case 6 -> {
                    mostrarListaOrdenada(personajes);
                }
                case 7 -> {
                    System.out.println("Hasta la proxima");
                    salir = true;
                }
                default -> System.out.println("Error!, Solo puedes de 1 al 7");
            }
        } while (salir);

    }

    public static void altaPersonaje(Personaje[] personajes) {
        int opcion = 0;
        boolean salir = false;
        do {
            opcion = MiEntradaSalida.leerEntero("Selecciona 1.Mago o 2.Clerigo");
            switch (opcion) {
                case 1 -> {
                    boolean flag = true;
                    TRaza razas = null;
                    String nombre = MiEntradaSalida.solicitarCadena("Introduce el nombre de tu mago");
                    try {
                        while (flag) {
                            razas = TRaza.valueOf(MiEntradaSalida.solicitarCadena("Introduce tu nombre de tu raza Humano, Elfo, Enano o  Orco"));
                            flag = false;
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Solo puedes seleccionar esas razas");
                    }
                    int vidaMax = MiEntradaSalida.leerEntero("Introduce la vida maxima de tu personaje");
                    int fuerza = MiEntradaSalida.leerEntero("Introduce la fuerza");
                    int inteligencia = MiEntradaSalida.leerEntero("Introduce la inteligencia");
                    Mago mago = null;
                    try {
                        mago = new Mago(nombre, razas, fuerza, inteligencia, vidaMax);
                    } catch (PersonajeException e) {
                        System.out.println(e.getMessage());
                    }

                    annadirMago(personajes, mago);
                }
                case 2 -> {
                    boolean flag = true;
                    TRaza razas = null;
                    String nombre = MiEntradaSalida.solicitarCadena("Introduce el nombre de tu mago");
                    try {
                        while (flag) {
                            razas = TRaza.valueOf(MiEntradaSalida.solicitarCadena("Introduce tu nombre de tu raza Humano, Elfo, Enano o  Orco"));
                            flag = false;
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Solo puedes seleccionar esas razas");
                    }
                    int vidaMax = MiEntradaSalida.leerEntero("Introduce la vida maxima de tu personaje");
                    int fuerza = MiEntradaSalida.leerEntero("Introduce la fuerza");
                    int inteligencia = MiEntradaSalida.leerEntero("Introduce la inteligencia");
                    String dios = MiEntradaSalida.solicitarCadena("Introduce el nombre de tu dios al que rezas");

                    Clerigo clerigo = null;
                    try {
                        clerigo = new Clerigo(nombre, razas, vidaMax, fuerza, inteligencia, dios);
                    } catch (PersonajeException e) {
                        System.out.println(e.getMessage());
                    }
                    annadirClerigo(personajes, clerigo);
                }
                case 3 -> {
                    System.out.println("quieres volver");
                    salir = true;
                }
                default -> System.out.println("Error!, selecciona opcion 1 y 2");
            }
        } while (salir);
    }

    public static void annadirMago(Personaje[] personajes, Mago mago) {
        if (mago == null) return; // Evitamos los nulos
        for (Personaje p : personajes) {
            if (p != null && p.equals(mago)) {
                System.out.println("Ya existe este mago con este nombre");
                return;
            }
        }
        for (int i = 0; i < personajes.length; i++) {
            if (personajes[i] == null) {
                personajes[i] = mago;
                return;
            }
        }
        System.out.println("No hay espacio de personaje");
    }

    public static void annadirClerigo(Personaje[] personajes, Clerigo clerigo) {
        if (clerigo == null) return;
        for (Personaje p : personajes) {
            if (p != null || p.equals(clerigo)) {
                System.out.println("Ya existe este clerigo con este nombre");
                return;
            }
        }
        for (int i = 0; i < personajes.length; i++) {
            if (personajes[i] == null) {
                personajes[i] = clerigo;
                System.out.println("clerigo añadido");
                return;
            }
        }
        System.out.println("No hay espacio de personaje");
    }

    public static void magoAprendeHechizo(Personaje[] personajes) {
        String nombreMago = MiEntradaSalida.solicitarCadena("Introduce el nombre del mago");
        String hechizo = MiEntradaSalida.solicitarCadena("Introduce el nombre del hechizo");
        boolean mE = false;
        boolean pE = false;
        for (Personaje personaje : personajes) {
            if (personaje != null) {
                if (nombreMago.equals(personaje.getNombre())) {
                    pE = true;
                    if (personaje instanceof Mago) {
                        mE = true;
                        ((Mago) personaje).aprenderHechizo2(hechizo);
                    }
                }
            }
        }
        if (!pE) {
            System.out.println("No se ha encontrado personaje");
        } else if (!mE) {
            System.out.println("No se ha encontrado al mago");
        }
    }

    public static void magoLanzaHechizo(Personaje[] personajes) {
        String nombreMago = MiEntradaSalida.solicitarCadena("Nombre del Mago lanzador:");
        String nombreObjetivo = MiEntradaSalida.solicitarCadena("Nombre del Personaje objetivo:");
        String nombreHechizo = MiEntradaSalida.solicitarCadena("Nombre del hechizo:");

        Mago lanzador = null;
        Personaje objetivo = null;

        // 1. Buscamos a los dos personajes en el array
        for (Personaje p : personajes) {
            if (p != null) {
                if (p.getNombre().equalsIgnoreCase(nombreMago) && p instanceof Mago) {
                    lanzador = (Mago) p;
                }
                if (p.getNombre().equalsIgnoreCase(nombreObjetivo)) {
                    objetivo = p;
                }
            }
        }
        // 2. Validaciones antes de lanzar
        if (lanzador == null || objetivo == null) {
            System.out.println("No se ha encontrado a alguno de los personajes.");
            return;
        }

        // USO DEL EQUALS: Controlar que no sea él mismo
        if (lanzador.equals(objetivo)) {
            System.out.println("Un mago no puede lanzarse un hechizo a sí mismo.");
            return;
        }

        // 3. Ejecución del hechizo
        String resultado = lanzador.lanzarHechizo(objetivo, nombreHechizo);
        System.out.println(resultado);

        // 4. Control de muerte (sin eliminar del array)
        if (objetivo.getVidaActual() <= 0) {
            objetivo.setVidaActual(0); // Aseguramos que no sea negativa
            System.out.println("¡El personaje " + objetivo.getNombre() + " ha muerto!");
        }
    }

    public static void clerigoCuraMago(Personaje[] personajes) {
        String nombreClerigo = MiEntradaSalida.solicitarCadena("Introduce el nombre del clerigo");
        String nombreMago = MiEntradaSalida.solicitarCadena("Introduce el nombre del mago");
        Mago mago = null;
        Clerigo clerigo = null;

        for (Personaje personaje : personajes) {
            if (personaje != null) {
                if (personaje.getNombre().equalsIgnoreCase(nombreClerigo) && personaje instanceof Clerigo) {
                    clerigo = (Clerigo) personaje;
                }
                if (personaje.getNombre().equalsIgnoreCase(nombreMago) && personaje instanceof Mago) {
                    mago = (Mago) personaje;
                }
            }
        }
        if (mago == null || clerigo == null) {
            System.out.println("no se ha encontrado alguno de los personajes");
            return;
        }
        clerigo.curar(mago);
    }

    public static void mostrarListaOrdenada(Personaje[] personajes) {
        // contamos los personajes que no sean nulos
        int contador = 0;
        for (Personaje p : personajes) {
            if (p != null) contador++;
        }
        // creamos un array temporal del mismo tamaño
        Personaje[] aux = new Personaje[contador];
        int j = 0;
        for (Personaje p : personajes) {
            if (p != null) {
                aux[j] = p;
                j++;
            }
        }
        // ordena con el metodo compareTo que modfico arriba
        Arrays.sort(aux);
        System.out.println("\n---PERSONAJES POR VIDA  (MENOR A MAYOR) ---");
        for (Personaje p : aux) {
            System.out.println(p.getNombre() + "| Vida:" + p.getVidaActual() + "| Raza:" + p.getRazas());
        }
    }

    public static void menu() {
        System.out.println("|-----------------------BIENVENIDO A LEAGUE OF VIRGIN---------------------------------|");
        System.out.println("1.Alta del Personaje");
        System.out.println("|-------------------------------------------------------------------------------------|");
        System.out.println("2.Mago aprende hechizo");
        System.out.println("|-------------------------------------------------------------------------------------|");
        System.out.println("3.Mago lanza Hechizo");
        System.out.println("|-------------------------------------------------------------------------------------|");
        System.out.println("4.Clerigo cura al mago");
        System.out.println("|-------------------------------------------------------------------------------------|");
        System.out.println("5.Mostar listado de personajes");
        System.out.println("|-------------------------------------------------------------------------------------|");
        System.out.println("6.Mostrar el listado de personajes ordenados por puntos actuales de mayor a menor");
        System.out.println("|-------------------------------------------------------------------------------------|");
        System.out.println("Salir");
        System.out.println("|-------------------------------------------------------------------------------------|");
    }
}