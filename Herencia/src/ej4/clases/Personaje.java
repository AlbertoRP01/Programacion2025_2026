package ej4.clases;

public abstract class Personaje implements Comparable {
    private static final int VIDA_MAX = 100;
    private String nombre;
    private int fuerza;
    private int inteligencia;
    private int vidaActual;

    public Personaje(String nombre, int fuerza, int inteligencia) {
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.inteligencia = inteligencia;
        this.vidaActual = VIDA_MAX;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFuerza() {
        return fuerza;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "nombre='" + nombre + '\'' +
                ", fuerza=" + fuerza +
                ", inteligencia=" + inteligencia +
                ", vidaActual=" + vidaActual +
                '}';
    }
}
