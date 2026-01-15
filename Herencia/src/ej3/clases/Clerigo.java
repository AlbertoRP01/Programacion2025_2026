package ej3.clases;

import ej3.enums.TRaza;
import ej3.excepciones.PersonajeException;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

public class Clerigo extends Personaje {
    private final int I_MIN = 12;
    private final int I_MAX = 16;
    private final int F_MIN = 18;
    private final int F_MAX = 20;
    private String dios;

    public Clerigo(String nombre, TRaza razas, int fuerza, int inteligencia, int vidaMax, String dios) throws PersonajeException {
        super(nombre, razas, fuerza, inteligencia, vidaMax);
        this.dios = dios;
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
        return super.toString() + "Clerigo:\n" +
                "dios=\t'" + dios + '\'' +
                '.';
    }
}
