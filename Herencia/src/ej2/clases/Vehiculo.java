package ej2.clases;

import ej2.enums.TGama;

public abstract class Vehiculo {
    private String matricula;
    private TGama gamas;

    public Vehiculo(String matricula, TGama gamas) {
        this.matricula = matricula;
        this.gamas = gamas;
    }

    public String getMatricula() {
        return matricula;
    }

    public TGama getGamas() {
        return gamas;
    }

    public void calcularPrecioAlquiler(){

    }
}
