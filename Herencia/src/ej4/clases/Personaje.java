package ej4.clases;

import ej4.enums.TRaza;
import ej4.excepciones.PersonajeException;

public abstract class Personaje implements Comparable<Personaje> {
    private String nombre;
    private TRaza razas;
    private int fuerza;
    private int inteligencia;
    private int vidaMax;
    private int vidaActual;

    public Personaje(String nombre, TRaza razas, int fuerza, int inteligencia, int vidaMax) throws PersonajeException {
        this.nombre = nombre;
        this.razas = razas;
        setFuerza(fuerza);
        setInteligencia(inteligencia);
        setVidaMax(vidaMax);
        this.vidaActual = vidaMax;
    }

    public TRaza getRazas() {
        return razas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public abstract int getFuerzaMin();

    public abstract int getFuerzaMax();

    public abstract int getInteligenciaMin();

    public abstract int getInteligenciaMax();

    public int getVidaMax() {
        return vidaMax;
    }

    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
    }

    public void setInteligencia(int inteligencia) throws PersonajeException {
        if (inteligencia > getInteligenciaMin() && inteligencia < getInteligenciaMax()) {
            this.inteligencia = inteligencia;

        } else {
            throw new PersonajeException("Inteligencia invalida");
        }
    }

    public void setFuerza(int fuerza) throws PersonajeException {
        if (fuerza > getFuerzaMin() && fuerza < getFuerzaMax()) {
            this.fuerza = fuerza;
        } else {
            throw new PersonajeException("Fuerza invalida");
        }
    }

    public int setVidaMax(int vidaMax) throws PersonajeException {
        if (vidaMax > 0 && vidaMax < 100) {
            this.vidaMax = vidaMax;
        } else {
            throw new PersonajeException("Vida invalida");
        }
        return vidaMax;
    }

    public int compareTo(Personaje o) {
        int resultado = Integer.compare(o.getVidaActual(), this.getVidaActual());

        // 2. Si tienen la misma vida (empate), usamos el nombre como criterio secundario
        if (resultado == 0) {
            resultado = this.getNombre().compareTo(o.getNombre());
        }

        return resultado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personaje personaje = (Personaje) o;
        return java.util.Objects.equals(nombre, personaje.nombre);
    }


    @Override
    public String toString() {
        return "Personaje:\n" +
                "nombre=\t'" + nombre + "\n" +
                ", fuerza=\t" + fuerza + "\n" +
                ", inteligencia=\t" + inteligencia + "\n" +
                ", vidaActual=\t" + vidaActual +
                '.';
    }
}