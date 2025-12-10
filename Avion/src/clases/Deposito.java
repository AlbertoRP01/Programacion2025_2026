package clases;

import excepciones.AvionException;

public class Deposito {
    private  double capacidadMax;
    private  double capacidadActual;

    public Deposito(double capacidadActual, double capacidadMax) {
        this.capacidadActual = capacidadActual;
        this.capacidadMax = capacidadMax;
    }

    public double getCapacidadMax() {
        return capacidadMax;
    }

    public double getCapacidadActual() {
        return capacidadActual;
    }

    public void setCapacidadActual(double capacidadActual) throws AvionException {
        if (capacidadActual < 0){
            throw new AvionException("La capacidad actual No puede contener capacidad negativa");
        }
        this.capacidadActual = capacidadActual;
    }

    public void setCapacidadMax(double capacidadMax) throws AvionException {
        if (capacidadMax < 0){
            throw new AvionException("La capacidad maxima no puede ser negativa");
        }
        this.capacidadMax = capacidadMax;
    }

    @Override
    public String toString() {
        return "Deposito{" +
                "capacidadMax=" + capacidadMax +
                ", capacidadActual=" + capacidadActual +
                '}';
    }
}
