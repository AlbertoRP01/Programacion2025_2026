package ej7.clase;

import ej7.excepciones.JarraException;

public class Jarra {
    //Atributos
    private static int totalAguaConsumida = 0;
    private int capacidadActual;
    private int capacidad;

    public Jarra(int capacidad) {
        this.capacidadActual = 0;
        this.capacidad = capacidad;
    }

    public int getCapacidadActual() {
        return capacidadActual;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidadActual(int capacidadActual) throws JarraException {
        if (capacidadActual < 0) {
            throw new JarraException("No puede contener numeros negativos");
        }
        this.capacidadActual = capacidadActual;
    }

    public void setCapacidad(int capacidad) throws JarraException {
        if (capacidad < 0) {
            throw new JarraException("No puede contener numeros negativos");
        }
        this.capacidad = capacidad;
    }

    public void llenarJarra() {
        int aguaAAgregar = this.capacidad - this.capacidadActual;
        this.capacidadActual = this.capacidad;
        if (aguaAAgregar > 0) {
            Jarra.totalAguaConsumida += aguaAAgregar;
        }
        Jarra.totalAguaConsumida += this.capacidad;
    }

    public void vaciarJarra() {
        this.capacidadActual = 0;
    }

    public void volcarJarra(Jarra otraJarra) {
        //calculo de vaciar de la Jarra A para llenar la JarraB
        int espacioLibre = otraJarra.capacidad - otraJarra.capacidadActual;
        int cantidadVerter = Math.min(this.capacidadActual, espacioLibre);

        //actualiza las jarras
        this.capacidadActual -= cantidadVerter;
        otraJarra.capacidadActual += cantidadVerter;
    }

    public static int getTotalAguaConsumida() {
        return totalAguaConsumida;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\tCapacidad actual: ").append(getCapacidadActual()).append(".");
        sb.append("\n\tCapacidad:").append(getCapacidad());
        return sb.toString();
    }
}
