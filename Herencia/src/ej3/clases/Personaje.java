package ej3.clases;

import ej3.enums.TRaza;
import ej3.excepciones.PersonajeException;

public abstract class Personaje implements Comparable<Personaje> {
    private String nombre;
    private TRaza razas;
    private int fuerza;
    private int inteligencia;
    private int vidaMax;
    private int vidaActual;

    public Personaje(String nombre, TRaza razas, int fuerza, int inteligencia, int vidaMax, int vidaActual) throws PersonajeException {
        this.nombre = nombre;
        this.razas = razas;
        setFuerza(fuerza);
        setInteligencia(inteligencia);
        setVidaMax(vidaMax);
        this.vidaActual = setVidaMax(vidaMax);
    }

    public TRaza getRazas() {
        return razas;
    }

    public abstract int getFuerzaMin();

    public abstract int getFuerzaMax();

    public abstract int getInteligenciaMin();

    public abstract int getInteligenciaMax();

    public int getVidaMax() {
        return vidaMax;
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
        return Integer.compare(this.vidaActual, o.vidaActual);
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
