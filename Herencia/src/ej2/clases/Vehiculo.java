package ej2.clases;

import ej2.enums.TCombustible;
import ej2.enums.TGama;

public abstract class Vehiculo {
    private String matricula;
    private TGama gama;
    private TCombustible combustibles;

    public Vehiculo(String matricula, TGama gama, TCombustible combustible) {
        this.matricula = matricula;
        this.gama = gama;
        this.combustibles = combustible;
    }

    public String getMatricula() {
        return matricula;
    }

    public TGama getGama() {
        return gama;
    }

    public TCombustible getCombustibles() {
        return combustibles;
    }


    public double calcularPrecioAlquiler(int numDias) {
        return numDias * gama.getPrecioBase();
    }



    @Override
    public String toString() {
        return "Vehiculo{" +
                "matricula='" + matricula + '\'' +
                ", gama=" + gama +
                ", combustibles=" + combustibles +
                '}';
    }
}
