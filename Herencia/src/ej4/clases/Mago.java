package ej4.clases;

import ej4.enums.TRaza;
import ej4.excepciones.PersonajeException;

import java.util.Arrays;

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
        int resultado = this.getNombre().compareTo(o.getNombre());
        if (resultado == 0) {
            resultado = this.getRazas().compareTo(o.getRazas());
        }
        if (resultado == 0) {
            resultado = Integer.compare(this.getVidaActual(), o.getVidaActual());
        }
        return resultado;
    }

    public void aprenderHechizo(String hechizo) {
        if (contadorHechizo < 4) {
            hechizos[contadorHechizo] = hechizo;
            contadorHechizo++;
        } else {
            System.out.println("Está lleno");
        }
    }

    public void aprenderHechizo2(String hechizo) {
        boolean aprendido = false;
        for (int i = 0; i < hechizos.length; i++) {
            if (hechizos[i] == null) {
                hechizos[i] = hechizo;
                System.out.println("Has aprendido" + hechizo + "en el espacio" + i);
                aprendido = true;
                break;
            }
        }
        if (!aprendido) {
            System.out.println("Tu libro de hechizos está lleno! No puedes aprender " + hechizo);
        }
    }

    public String lanzarHechizo(Personaje enemigo, String hechizo) {
        for (int i = 0; i < hechizos.length; i++) {
            if (hechizos[i] != null &&hechizos[i].equalsIgnoreCase(hechizo)) {
                int vidaEnemiga = enemigo.getVidaActual() - 10;
                enemigo.setVidaActual(vidaEnemiga);
                hechizos[i] = null;
                return "Hechizo" + hechizo + "lanzado con exito contra " + enemigo.getNombre();
            }
        }
        return "No tienes ese hechizo en tu libro";
    }

    @Override
    public String toString() {
        return super.toString() + "Mago:\n" +
                "hechizos=\t" + Arrays.toString(hechizos) +
                '.';
    }
}