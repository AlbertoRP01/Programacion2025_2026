package ej2.clases;

import ej2.enums.TCombustible;
import ej2.enums.TGama;
import ej2.excepciones.VehiculoException;

public class Coche extends Vehiculo {

    public Coche(String matricula, TGama gamas, TCombustible combustible) {
        super(matricula, gamas, combustible);
    }

    @Override
    public double calcularPrecioAlquiler(int numDias) {
        double precioBase = super.calcularPrecioAlquiler(numDias);
        return precioBase + numDias * super.getCombustibles().getPrecioDia();
    }

    @Override
    public String toString() {
        return super.toString() +"Coche{ }";
    }
}
