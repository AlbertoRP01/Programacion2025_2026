package clases;

import java.util.PrimitiveIterator;

public class Avion {
    private String marca;
    private String modelo;
    private double consumo;
    private Revision[] revisiones;

    public Avion(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.revisiones = new Revision[20];
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

}
