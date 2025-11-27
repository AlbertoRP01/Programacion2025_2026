package ej5.clase;

public class Punto {
    private double coordenadaY;
    private double coordenadaX;

    public Punto() {
        coordenadaY = 0.0;
        coordenadaX = 0.0;
    }

    public Punto(double coordenadaY, double coordenadaX) {
        this.coordenadaY = coordenadaY;
        this.coordenadaX = coordenadaX;
    }

    public double getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(double coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public double getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(double coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Punto punto = (Punto) o;
        return Double.compare(coordenadaY, punto.coordenadaY) == 0 && Double.compare(coordenadaX, punto.coordenadaX) == 0;
    }

    @Override
    public int hashCode() {
        int result = Double.hashCode(coordenadaY);
        result = 31 * result + Double.hashCode(coordenadaX);
        return result;
    }
}
