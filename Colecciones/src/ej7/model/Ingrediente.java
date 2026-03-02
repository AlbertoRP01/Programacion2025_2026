package ej7.model;

public class Ingrediente {
    private String nombre;
    private double cantidad;

    public Ingrediente(String nombre, double cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Ingrediente{");
        sb.append("nombre= ").append(getNombre()).append("\n");
        sb.append("cantidad= ").append(getCantidad()).append(".");
        return sb.toString();
    }
}
