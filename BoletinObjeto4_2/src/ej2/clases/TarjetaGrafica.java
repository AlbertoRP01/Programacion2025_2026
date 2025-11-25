package ej2.clases;

public class TarjetaGrafica {
    private String marca;
    private String modelo;
    private int numNucleos;
    private float velocidad;
    private int cantidad;

    public TarjetaGrafica(String marca, String modelo, int cantidad, float velocidad, int numNucleos) {
        this.marca = marca;
        this.modelo = modelo;
        this.cantidad = cantidad;
        this.velocidad = velocidad;
        this.numNucleos = numNucleos;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getNumNucleos() {
        return numNucleos;
    }

    public float getVelocidad() {
        return velocidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return "TarjetaGrafica:\n" +
                String.format("cadena: %s\n", getMarca()) +
                String.format("Modelo: %s\n", getModelo()) +
                String.format("NumNucleos: %d\n", getNumNucleos()) +
                String.format("Velocidad: %.2f\n", getVelocidad()) +
                String.format("Cantidad %d",getCantidad()) +
                '.';
    }
}
