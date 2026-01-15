package ej3.clases;

import ej3.enums.TRaza;
import ej3.excepciones.PersonajeException;

import java.util.Arrays;

public class Mago extends Personaje {
    private final int I_MIN = 17;
    private final int I_MAX = 20;
    private final int F_MIN = 0;
    private final int F_MAX = 15;
    private String[] hechizos;

    public Mago(String nombre, TRaza raza, int fuerza, int inteligencia, int vidaMax, int vidaActual) throws PersonajeException {
        super(nombre, raza, fuerza, inteligencia, vidaMax, vidaActual);
        this.hechizos = new String[4];
    }

    @Override
    public int getFuerzaMin() {
        return F_MIN;
    }

    @Override
    public int getFuerzaMax() {
        return F_MAX;
    }

    @Override
    public int getInteligenciaMin() {
        return I_MIN;
    }

    @Override
    public int getInteligenciaMax() {
        return I_MAX;
    }

    @Override
    public int compareTo(Personaje o) {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() +  "Mago:\n" +
                "hechizos=\t" + Arrays.toString(hechizos) +
                '.';
    }
}
