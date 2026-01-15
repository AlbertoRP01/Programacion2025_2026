package ej3.clases;

import ej3.enums.TRaza;
import ej3.excepciones.PersonajeException;

import java.util.Arrays;
import java.util.IllegalFormatCodePointException;

public class Mago extends Personaje {
    private final int I_MIN = 17;
    private final int I_MAX = 20;
    private final int F_MIN = 0;
    private final int F_MAX = 15;
    private String[] hechizos;
    private int contadorHechizo = 0;

    public Mago(String nombre, TRaza razas, int fuerza, int inteligencia, int vidaMax) throws PersonajeException {
        super(nombre, razas, fuerza, inteligencia, vidaMax);
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

    public void aprenderHechizo(String hechizo) {
        if (contadorHechizo < 4) {
            hechizos[contadorHechizo] = hechizo;
            contadorHechizo++;
        }else {
            System.out.println("Está lleno");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Mago:\n" +
                "hechizos=\t" + Arrays.toString(hechizos) +
                '.';
    }
}
