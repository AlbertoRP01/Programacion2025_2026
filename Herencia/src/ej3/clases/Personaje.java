package ej3.clases;

import ej3.enums.TRaza;
import ej3.excepciones.PersonajeException;

public abstract class Personaje implements Comparable<Personaje> {
    //Atributos
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
    public String getNombre() {
        return nombre;
    }
    public TRaza getRazas() {
        return razas;
    }
    public int getVidaMax() {
        return vidaMax;
    }

    public int getVidaActual() {
        return vidaActual;
    }
    // Estos metodos abstractos para que guarde informacion tanto de clerigo como de mago sobre algunas de sus caracteristicas
    public abstract int getFuerzaMin();

    public abstract int getFuerzaMax();

    public abstract int getInteligenciaMin();

    public abstract int getInteligenciaMax();


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
        int resultado = this.getNombre().compareTo(o.getNombre());
        if (resultado == 0) {
            resultado = this.getRazas().compareTo(o.getRazas());
        }
        if (resultado == 0) {
            resultado = Integer.compare(this.getVidaActual(), o.getVidaActual());
        }
        return resultado;
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
