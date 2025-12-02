package ej3.principal;

import ej2.clases.DiscoDuro;
import ej2.clases.Microprocesador;
import ej2.clases.TarjetaGrafica;
import ej3.clases.Videojuego;
import mientradasalida.MiEntradaSalida;

import java.time.Year;

public class Principal {
    static void main(String[] args) {
        Videojuego videojuego = new Videojuego("Expedition33", "Sandfall Interactive", Year.of(2025), 6, 4.703F, 55, 36, 8);

    }

    public static Microprocesador microprocesador() {
        String marca = mientradasalida.MiEntradaSalida.solicitarCadena("Introduce la marca del procesador");
        String modelo = mientradasalida.MiEntradaSalida.solicitarCadena("Introduce el modelo del microprocesador");
        int numNucleos = mientradasalida.MiEntradaSalida.leerEnteroPositivo("Introduce el numero de nucleos");
        float velocidadBase = mientradasalida.MiEntradaSalida.solicitarFloat("Introduce la velocidadBase");
        String socket = mientradasalida.MiEntradaSalida.solicitarCadena("Introduce el socket");
        return new Microprocesador(marca, modelo, numNucleos, velocidadBase, socket);
    }

    public static DiscoDuro discoDuro() {
        String marca = mientradasalida.MiEntradaSalida.solicitarCadena("Introduce la marca del disco duro");
        String tipo = mientradasalida.MiEntradaSalida.solicitarCadena("Introduce el tipo de disco duro");
        int capacidad = mientradasalida.MiEntradaSalida.leerEnteroPositivo("Introduce la capacidad del disco duro");
        return new DiscoDuro(marca, tipo, capacidad);
    }

    public static TarjetaGrafica tarjetaGrafica() {
        String marca = mientradasalida.MiEntradaSalida.solicitarCadena("Introduce la marca de la tarjeta Gráfica");
        String modelo = mientradasalida.MiEntradaSalida.solicitarCadena("Introduce el modelo de el atarjeta gráfica");
        int numNucleos = mientradasalida.MiEntradaSalida.leerEnteroPositivo("Introduce el numero de núcleos");
        float velocidad = mientradasalida.MiEntradaSalida.solicitarFloat("Introduce la velocidad de la tarjeta gráfica");
        int cantidad = mientradasalida.MiEntradaSalida.leerEnteroPositivo("Introduce la capacidad de VRam");
        return new TarjetaGrafica(marca, modelo, numNucleos, velocidad, cantidad);
    }

    public static Videojuego videojuego() {
        String nombre = mientradasalida.MiEntradaSalida.solicitarCadena("Introduce el nombre del videojuego");
        String companiaCreadora = mientradasalida.MiEntradaSalida.solicitarCadena("Introduce el nombre de la compañia creadora del videojuego");
        Year annoCreacion = mientradasalida.MiEntradaSalida.solicitarYear("Introduce el año de creacion del videoJuego");
        int numNucleosCpu = mientradasalida.MiEntradaSalida.leerEnteroPositivo("Introduce el numero de nucleos de la CPU");
        float velocidadCpu = mientradasalida.MiEntradaSalida.solicitarFloat("Introduce la velocidad de la CPU");
        int espacioDiscoDuro = mientradasalida.MiEntradaSalida.leerEnteroPositivo("Introduce la cantidad de espacio del disco duro");
        int numNucleosGpuMin = MiEntradaSalida.leerEnteroPositivo("Introduce el numero de nucleos de GPU minimo");
        int memoriaMin = mientradasalida.MiEntradaSalida.leerEnteroPositivo("Introduce la VRAM min ");
        return new Videojuego(nombre, companiaCreadora, annoCreacion, numNucleosCpu, velocidadCpu, espacioDiscoDuro, numNucleosGpuMin, memoriaMin);
    }
}
