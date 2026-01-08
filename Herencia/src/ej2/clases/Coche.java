package ej2.clases;

import ej2.enums.TCombustible;
import ej2.enums.TGama;

public class Coche extends Vehiculo {


    public Coche(String matricula, TGama gamas, TCombustible combustible, int numDias) {
        super(matricula, gamas, combustible, numDias);
    }

    @Override
    public double calcularPrecioAlquiler(double calculoTotal) {
        if (getGamas().equals(TGama.BAJA) && getCombustibles().equals(TCombustible.GASOLINA)){
            calculoTotal = getGamas() + (getCombustibles() * (getNumDias()));
        }
        return  calculoTotal;
    }


}
