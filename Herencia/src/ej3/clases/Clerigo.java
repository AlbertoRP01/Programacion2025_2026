package ej3.clases;

import ej3.enums.TRaza;
import ej3.excepciones.PersonajeException;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

public class Clerigo extends Personaje {
    //Constantes
    private final int I_MIN = 12;
    private final int I_MAX = 16;
    private final int F_MIN = 18;
    private final int F_MAX = 20;
    //Atributo
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

    /**
     * En este metodo he querido añadir a que el propio clerigo no pueda curar  a si mismo, lo que he querido hacer que
     * curase al aliado es decir al mago para que su aliado no se muera pero en el caso de que cure al mago teniendo
     * la vida al maximo te muestra el mensaje diciendo que la salud del mago está al maximo
     * @param aliado
     */
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
    //Este metodo lo que hace es ordenar de manera natural a los clerigos a traves de su nombre, raza y vida actual
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
        return super.toString() + "Clerigo:\n" +
                "dios=\t'" + dios + '\'' +
                '.';
    }
}
