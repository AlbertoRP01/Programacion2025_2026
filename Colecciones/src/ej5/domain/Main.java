import ej5.exceptions.DiccionarioException;
import ej5.model.Diccionario;
import mientradasalida.MiEntradaSalida;


public static void main(String[] args) {
    Diccionario miDiccionario = new Diccionario();
    int opcion = 0;

    do {
        mostrarMenu();
        opcion = MiEntradaSalida.leerEntero("Selecciona una opción:");

        try {
            switch (opcion) {
                case 1: // Añadir palabra
                    String p = MiEntradaSalida.solicitarCadena("Palabra:");
                    String s = MiEntradaSalida.solicitarCadena("Significado:");
                    miDiccionario.annadirPalabra(p, s);
                    System.out.println("✅ Palabra añadida.");
                    break;

                case 2: // Buscar palabra
                    String buscar = MiEntradaSalida.solicitarCadena("Palabra a buscar:");
                    List<String> significados = miDiccionario.buscarPalabra(buscar);
                    System.out.println("📖 Significados de " + buscar + ": " + significados);
                    break;

                case 3: // Borrar palabra
                    String borrar = MiEntradaSalida.solicitarCadena("Palabra a borrar:");
                    miDiccionario.borrarPalabra(borrar);
                    System.out.println("🗑️ Palabra eliminada.");
                    break;

                case 4: // Listado por prefijo
                    String pref = MiEntradaSalida.solicitarCadena("Introduce el prefijo:");
                    List<String> lista = miDiccionario.ListaPorPrefijo(pref);
                    System.out.println("🔍 Palabras encontradas: " + lista);
                    break;

                case 5:
                    System.out.println("👋 Saliendo...");
                    break;

                default:
                    System.out.println("⚠️ Opción no válida.");
            }
        } catch (DiccionarioException e) {
            // Aquí capturamos tus excepciones personalizadas
            System.out.println("❌ Error: " + e.getMessage());
        }

    } while (opcion != 5);
}

private static void mostrarMenu() {
    System.out.println("\n--- DICCIONARIO ---");
    System.out.println("1. Añadir palabra");
    System.out.println("2. Buscar palabra");
    System.out.println("3. Borrar palabra");
    System.out.println("4. Listado por prefijo");
    System.out.println("5. Salir");
}