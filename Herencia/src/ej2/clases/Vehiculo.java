package ej2.clases;

import ej2.enums.TCombustible;
import ej2.enums.TGama;

public abstract class Vehiculo {
    private String matricula;
    private TGama gamas;
    private TCombustible combustibles;
    public Vehiculo(String matricula, TGama gamas, TCombustible combustible) {
        this.matricula = matricula;
        this.gamas = gamas;
        this.combustibles = combustible;
    }

    public String getMatricula() {
        return matricula;
    }

    public TGama getGamas() {
        return gamas;
    }

    public TCombustible getCombustibles() {
        return combustibles;
    }

    public void calcularPrecioAlquiler(){

    }
}
