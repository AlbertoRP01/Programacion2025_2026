package ej2.clases;

import ej2.enums.TCombustible;
import ej2.enums.TGama;
import ej2.excepciones.VehiculoException;

public abstract class Vehiculo {
    private String matricula;
    private TGama gamas;
    private TCombustible combustibles;
    private  int numDias;
    public Vehiculo(String matricula, TGama gamas, TCombustible combustible, int numDias) {
        this.matricula = matricula;
        this.gamas = gamas;
        this.combustibles = combustible;
        this.numDias = numDias;

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

    public int getNumDias() {
        return numDias;
    }

    public void setNumDias(int numDias) {
        if (numDias < 0 ){
            throw new VehiculoException("No puede contener días negativos");
        }
        this.numDias = numDias;
    }

    public void setGamas(TGama gamas) {
        this.gamas = gamas;
    }

    public void setCombustibles(TCombustible combustibles) {
        this.combustibles = combustibles;
    }

    public  abstract double calcularPrecioAlquiler(double calculoTotal);
}
