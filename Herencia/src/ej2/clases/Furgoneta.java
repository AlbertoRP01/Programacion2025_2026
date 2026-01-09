package ej2.clases;

import com.sun.jdi.PrimitiveValue;
import ej2.enums.TCombustible;
import ej2.enums.TGama;

public class Furgoneta extends Vehiculo {
    private double PMA;

    public Furgoneta(String matricula, TGama gamas, TCombustible combustible, double PMA) {
        super(matricula, gamas, combustible);
        this.PMA = PMA;
    }

    @Override
    public double calcularPrecioAlquiler(int numDias) {
        double precioBase = super.calcularPrecioAlquiler(numDias);
        return precioBase + 0.5 * numDias * PMA;
    }

    @Override
    public String toString() {
        return "Furgoneta{" +
                "PMA=" + PMA +
                '}';
    }
}
