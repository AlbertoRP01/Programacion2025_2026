package ej7;

import mientradasalida.MiEntradaSalida;

import javax.naming.ldap.SortResponseControl;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Ej7Nio {
    public static void main(String[] args) {
        boolean salir = false;
        int opcion;
        do {
            System.out.println("======================Bienvenido al pequeño menu  de nuestro sistema=====================================");
            menu();
            opcion = MiEntradaSalida.leerEntero("Elige una opción: ");
            switch (opcion) {
                case 1 -> {
                    listarDirectorio();
                }
                case 2 -> {
                    buscarFicheroQueComienceConUnaPalabra();
                }
                case 3 -> {
                    listarArchivoConExtension();
                }
                case 4 -> {
                    buscarArchivoEnUnDirectorio();
                }
                case 5 -> {
                    buscarRecursivamenteUnArchivo();
                }
                case 6 -> {
                    salir = true;
                }
                default -> {
                    System.out.println("Error. Selecciona entre 1 y 6");
                }
            }
        } while (!salir);
    }

    public static void listarDirectorio() {
        String rutaStr = MiEntradaSalida.solicitarCadena("Introduce la ruta");
        Path ruta = Path.of(rutaStr);
        if (Files.exists(ruta) && Files.isDirectory(ruta)) {
            try (Stream<Path> rutas = Files.list(ruta)) {
                rutas.forEach(p -> {
                    try {
                        if (Files.isDirectory(p)) {
                            System.out.println("[DIR] " + p.getFileName());
                        } else {
                            double sizeKB = Files.size(p) / 1024.0;
                            System.out.printf("[FILE] %s - %.2f KB%n", p.getFileName(), sizeKB);
                        }
                    } catch (IOException e) {
                        System.out.println("Error con " + p.getFileName());
                    }

                });
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Ruta no válida");
        }
    }

    public static void buscarFicheroQueComienceConUnaPalabra() {
        String ruta = MiEntradaSalida.solicitarCadena("Introduce la palabra ");
        Path p = Path.of(ruta);

        String palabraABuscar = MiEntradaSalida.solicitarCadena("Introduce la palabra");
        if (Files.isDirectory(p)) {
            try (Stream<Path> ficheros = Files.list(p)) {
                ficheros.filter(path -> path.getFileName().startsWith(palabraABuscar))
                        .forEach(path -> {
                            if (Files.isDirectory(p)) {
                                System.out.printf("%s - directorio %n", path.getFileName());
                            } else {
                                try {
                                    System.out.printf("%s %.2f kb %n", path.getFileName(), Files.size(path) / 1024.0);
                                } catch (IOException e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                        });

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void listarArchivoConExtension() {
        String ruta = MiEntradaSalida.solicitarCadena("Introduce la ruta");
        Path p = Path.of(ruta);
        String extensionABuscar = MiEntradaSalida.solicitarCadena("Introduce la extensión");
        if (Files.isDirectory(p)) {
            try (Stream<Path> ficheros = Files.list(p)) {
                ficheros.filter(path -> path.getFileName().endsWith(extensionABuscar))
                        .forEach(path -> {
                            if (Files.isDirectory(p)) {
                                System.out.printf("%s - directorio %n", path.getFileName());
                            } else {
                                try {
                                    System.out.printf("%s %.2f KB %n", path.getFileName(), Files.size(path) / 1024.0);
                                } catch (IOException e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                        });
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void buscarArchivoEnUnDirectorio() {
        String ruta = MiEntradaSalida.solicitarCadena("Introduce la ruta");
        Path p = Path.of(ruta);
        String ficheroABuscar = MiEntradaSalida.solicitarCadena("Introduce por cual  fichero quieres buscar");
        if (Files.isDirectory(p)) {
            try (Stream<Path> ficheros = Files.find(p, 1, (path, atr) -> {
                return path.getFileName().toString().equalsIgnoreCase(ficheroABuscar);
            })) {

                ficheros.forEach(path -> {
                    if (Files.isDirectory(p)) {
                        System.out.printf("%s - directorio %n", path.getFileName());
                    } else {
                        try {
                            System.out.printf("%s %.2f KB %n", path.getFileName(), Files.size(path) / 1024.0);
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                });

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void buscarRecursivamenteUnArchivo() {
        String ruta = MiEntradaSalida.solicitarCadena("Introduce la ruta");
        Path p = Path.of(ruta);

        String archivoABuscar = MiEntradaSalida.solicitarCadena("Introduce el archivo");

        if (Files.isDirectory(p)) {
            try (Stream<Path> ficheros = Files.walk(p)) {
                ficheros.filter(path -> path.getFileName().toString().startsWith(archivoABuscar))
                        .forEach(path -> {
                            if (Files.isDirectory(path)) {
                                System.out.printf("%s - directorio %n", path.getFileName());
                            } else {
                                try {
                                    System.out.printf("%s %.2f KB %n", path.getFileName(), Files.size(path) / 1024.0);
                                } catch (IOException e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                        });
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void menu() {
        System.out.println("1. Listar Directorio");
        System.out.println("2. Listar Directorio y buscar ficheros que comiencen con una palabra");
        System.out.println("3. Listar archivos con cierta extensión de un directiorio");
        System.out.println("4. Buscar un archivo en un directorio");
        System.out.println("5. Buscar recursivamente un archivo en un directorio");
        System.out.println("6. Salir");
    }
}
