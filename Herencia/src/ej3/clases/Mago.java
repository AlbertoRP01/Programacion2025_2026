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

    /**
     * TODO:En este caso, la manera de controlar  cuando se llene el libro de hechizos es a traves de un contador,
     * en el caso de que el contador llegue a 4 significa que está lleno el libro de hechizos, en el caso de que no sea así
     * pues se añade el hechizo en el libro de hechizo y el contador actua autoincrementandose.
     * @param hechizo
     */
    public void aprenderHechizo(String hechizo) {
        if (contadorHechizo < 4) {
            hechizos[contadorHechizo] = hechizo;
            contadorHechizo++;
        } else {
            System.out.println("Está lleno");
        }
    }
    /**
     * TODO: Este método lo que hago aqui, trato de controlar cuando se le llena el libro de hechizo desde la ultima posicion cuando recorra la ultima posicion y contenga ese hechizo
     * te muestra el mensaje de que está lleno el libro de hechizos, en el caso de que esté vacio dicha posicion,
     * se añade al libro de hechizos y se sale del bucle.
     * @param hechizo
     */
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

    /**
     * TODO: La manera que he querido hacer este metodo es en el caso de que utilice ese hechizo sobre un enmigo
     * ese mismo hechizo hago que le quite vida al enemigo y que ese mismo hechizo se elimine del libro de hechizo
     * @param enemigo
     * @param hechizo
     * @return
     */
    public String lanzarHechizo(Personaje enemigo, String hechizo) {
        for (int i = 0; i < hechizos.length; i++) {
            if (hechizos[i].equals(hechizo)) {
                int vidaEnemiga = enemigo.getVidaActual() - 10;
                enemigo.setVidaActual(vidaEnemiga);
                hechizos[i] = null;
                return "Hechizo" + hechizo + "lanzado con exito contra " + enemigo.getNombre();
            }
        }
        return "No tienes ese hechizo en tu libro";
    }
    //Este metodo lo que hace es ordenar de manera natural a los magos a traves de su nombre, raza y vida actual
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

    @Override
    public String toString() {
        return super.toString() + "Mago:\n" +
                "hechizos=\t" + Arrays.toString(hechizos) +
                '.';
    }
}
