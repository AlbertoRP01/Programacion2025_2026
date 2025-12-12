package clases;

import excepciones.AvionException;

public class Deposito {
    private double capacidadMax;
    private double capacidadActual;

    public Deposito(double capacidadActual, double capacidadMax) throws AvionException {
        this.capacidadActual = capacidadActual;
        this.capacidadMax = capacidadMax;
        setCapacidadMax(capacidadMax);
        setCapacidadActual(capacidadActual);
    }

    public double getCapacidadMax() {
        return capacidadMax;
    }

    public double getCapacidadActual() {
        return capacidadActual;
    }

    public void setCapacidadActual(double capacidadActual) throws AvionException {
        if (capacidadActual < 0) {
            throw new AvionException("La capacidad actual No puede contener capacidad negativa");
        }
        if (capacidadActual > capacidadMax) {
            throw new AvionException("No puedes meter esa cantidad, no cabe en el deposito");
        }
        this.capacidadActual = capacidadActual;
    }

    public void setCapacidadMax(double capacidadMax) throws AvionException {
        if (capacidadMax < 0) {
            throw new AvionException("La capacidad maxima no puede ser negativa");
        }
        this.capacidadMax = capacidadMax;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\t Deposito:");
        sb.append("\n\t Capacidad Maxima:").append(getCapacidadMax()).append(".");
        sb.append("\n\t CapacidadActual:").append(getCapacidadActual()).append(".");
        return sb.toString();
    }
}
