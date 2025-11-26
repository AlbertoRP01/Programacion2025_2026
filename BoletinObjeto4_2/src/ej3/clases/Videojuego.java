package ej3.clases;

import ej2.clases.DiscoDuro;
import ej2.clases.Microprocesador;
import ej2.clases.TarjetaGrafica;
import ej3.excepciones.VideojuegoExcepcion;

import java.time.Year;

public class Videojuego {
    private String nombre;
    private String companiaCreadora;
    private Year annoCreacion;
    private int numNucleosCpu;
    private float velocidadCpu;
    private int espacioDiscoDuro;
    private int numNucleosGpuMin;
    private int memoriaMin;

    public Videojuego(String nombre, String companiaCreadora, Year annoCreacion, int numNucleosCpu, float velocidadCpu, int espacioDiscoDuro, int numNucleosGpuMin, int memoriaMin) {
        this.nombre = nombre;
        this.companiaCreadora = companiaCreadora;
        this.annoCreacion = annoCreacion;
        this.numNucleosCpu = numNucleosCpu;
        this.velocidadCpu = velocidadCpu;
        this.espacioDiscoDuro = espacioDiscoDuro;
        this.numNucleosGpuMin = numNucleosGpuMin;
        this.memoriaMin = memoriaMin;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCompaniaCreadora() {
        return companiaCreadora;
    }

    public int getNumNucleosCpu() {
        return numNucleosCpu;
    }

    public Year getAnnoCreacion() {
        return annoCreacion;
    }

    public float getVelocidadCpu() {
        return velocidadCpu;
    }

    public int getEspacioDiscoDuro() {
        return espacioDiscoDuro;
    }

    public int getNumNucleosGpuMin() {
        return numNucleosGpuMin;
    }

    public int getMemoriaMin() {
        return memoriaMin;
    }

    public void requisitosMinimos(Microprocesador microprocesador, DiscoDuro discoDuro, TarjetaGrafica tarjetaGrafica) throws VideojuegoExcepcion {
        if (microprocesador.getNumNucleos() < this.numNucleosCpu && microprocesador.getVelocidadBase() < this.velocidadCpu) {
            throw new VideojuegoExcepcion("No cumple con los requisitos del videojuego");
        }
        if (discoDuro.getCapacidad() < this.espacioDiscoDuro) {
            throw new VideojuegoExcepcion("No cumple los requisitos del videojuego");
        }
        if (tarjetaGrafica.getNumNucleos() < numNucleosGpuMin && tarjetaGrafica.getCantidad() < memoriaMin) {
            throw new VideojuegoExcepcion("No cumple con los requisitos del videojuego");
        }
    }

    @Override
    public String toString() {
        return "Requisitos del Videojuego:\n" +
                String.format("nombre: %s\n", getNombre()) +
                String.format(", companiaCreadora: %s\n", getCompaniaCreadora()) +
                String.format(", annoCreacion:  " , getAnnoCreacion())+
                String.format(", numNucleosCpu: %d\n",getNumNucleosCpu()) +
                String.format(", velocidadCpu: %.2f\n", getVelocidadCpu()) +
                String.format(", espacioDiscoDuro: %d\n", getEspacioDiscoDuro()) +
                String.format(", numNucleosGpuMin: %d\n", getNumNucleosGpuMin()) +
                String.format(", memoriaMin: %d",getMemoriaMin()) +
                '.';
    }
}
