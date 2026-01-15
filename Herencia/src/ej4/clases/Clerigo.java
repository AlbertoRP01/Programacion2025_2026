package ej4.clases;

import ej4.enums.TRaza;
import ej4.excepciones.PersonajeException;

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
        int resultado = this.getNombre().compareTo(o.getNombre());
        if (resultado == 0) {
            resultado = this.getRazas().compareTo(o.getRazas());
        }
        if (resultado == 0) {
            resultado = Integer.compare(this.getVidaActual(), o.getVidaActual());
        }
        return resultado;
    }

    public void curar(Personaje aliado) {
        if (this == aliado) {
            System.out.println("¡Error! El clérigo no puede usar sus plegarias en sí mismo.");
            return;
        }
        if (aliado.getVidaActual() + 10 <= aliado.getVidaMax()) {
            int curarAliado = aliado.getVidaActual() + 10;
            System.out.println(aliado.getNombre() + "se ha curado");
        } else {
            System.out.println(aliado.getNombre() + "Su salud está al completo");
        }

    }

    @Override
    public String toString() {
        return super.toString() + "Clerigo:\n" +
                "dios=\t'" + dios + '\'' +
                '.';
    }
}
