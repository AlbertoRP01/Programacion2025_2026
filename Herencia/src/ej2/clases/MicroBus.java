package ej2.clases;

import ej2.enums.TCombustible;
import ej2.enums.TGama;

public class MicroBus extends Vehiculo{
    public final double PRECIO_POR_PLAZA = 5;
    private int numPlazas;

    public MicroBus(String matricula, TGama gamas, TCombustible combustible, int numPlazas) {
        super(matricula, gamas, combustible);
        this.numPlazas = numPlazas;
    }

    @Override
    public double calcularPrecioAlquiler(int numDias) {
        double precioBase = super.calcularPrecioAlquiler(numDias);
        return precioBase + numDias * numPlazas * PRECIO_POR_PLAZA;
    }

    @Override
    public String toString() {
        return "MicroBus{" +
                "PRECIO_POR_PLAZA=" + PRECIO_POR_PLAZA +
                ", numPlazas=" + numPlazas +
                '}';
    }
}
