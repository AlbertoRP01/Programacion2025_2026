package ej2.clases;

public class DiscoDuro {
    private String marca;
    private String tipo;
    private int capacidad;

    public DiscoDuro(String marca, String tipo, int capacidad) {
        this.marca = marca;
        this.tipo = tipo;
        this.capacidad = capacidad;
    }

    public String getMarca() {
        return marca;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    @Override
    public String toString() {
        return "DiscoDuro:" +
                "marca='" + marca + '\'' +
                ", tipo='" + tipo + '\'' +
                ", capacidad=" + capacidad +
                '.';
    }
}
