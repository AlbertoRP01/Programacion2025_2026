package ej6.clases;

import ej6.excepciones.ProductoException;

public class Producto {
    private static int contador;
    private int id;
    private String descripcion;
    private double precio;
    private static double iva = 0.20;

    public Producto() {
        this.id = contador++;
    }

    public Producto(String descripcion, double precio) {
        this();
        this.descripcion = descripcion;
        this.precio = precio;
    }

    //getters
    public static int getContador() {
        return contador;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public static double getIva() {
        return iva;
    }

    //Setters
    public void setPrecio(double precio) throws ProductoException {
        if (precio  < 0){
            throw new ProductoException("No puedes introducir un numero negativo en el precio");
        }
        this.precio = precio;
    }



    /**
     *
     * @return devuelve el calculo del precio por el IVA
     */
    public double calcularPrecioIva() {
        return this.precio * (1 + iva);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto: ");
        sb.append("\n\tId: ").append(getId()).append(".");
        sb.append("\n\tDescripcion: ").append(getDescripcion()).append(".");
        sb.append("\n\tPrecio: ").append(getPrecio()).append("€").append(".");
        sb.append("\n\tIVA: ").append(getIva()).append(".");
        return sb.toString();
    }
}
