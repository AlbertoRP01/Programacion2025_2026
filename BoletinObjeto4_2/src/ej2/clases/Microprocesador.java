package ej2.clases;

public class Microprocesador {
    private String marca;
    private String modelo;
    private int numNucleos;
    private float velocidadBase;
    private String socket;

    public Microprocesador(String marca, String modelo, int numNucleos, float velocidadBase, String socket) {
        this.marca = marca;
        this.modelo = modelo;
        this.numNucleos = numNucleos;
        this.velocidadBase = velocidadBase;
        this.socket = socket;
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

    public float getVelocidadBase() {
        return velocidadBase;
    }

    public String getSocket() {
        return socket;
    }


    @Override
    public String toString() {
        return "Microprocesador:\n" +
                String.format("Marca: %s\n", getMarca()) +
                String.format("Modelo:%s\n", getModelo()) +
                String.format("NumNucleos: %d\n", getNumNucleos()) +
                String.format("VelocidadBase: %.2f\n", getVelocidadBase()) +
                String.format("Socket: %s",getSocket())+
                '.';
    }
}
