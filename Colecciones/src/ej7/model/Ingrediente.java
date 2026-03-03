package ej7.model;

public class Ingrediente {
    /**
     * Nombre del ingrediente
     */
    private String nombre;

    /**
     * La cantidad en gramos del ingrediente
     */
    private double cantidad;

    /**
     * Constructor del ingrediente
     *
     * @param nombre
     * @param cantidad
     */
    public Ingrediente(String nombre, double cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    //getter y setters
    public String getNombre() {
        return nombre;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }


    /**
     * Te muestra la información completa del ingrediente
     *
     * @return devuelve toda la información del ingrediente
     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Ingrediente{");
        sb.append("nombre= ").append(getNombre()).append("\n");
        sb.append("cantidad= ").append(getCantidad()).append(".");
        return sb.toString();
    }
}
