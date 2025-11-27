package ej5.clase;

import ej5.excepciones.LineaException;

import java.util.Objects;

public class Linea {
    // Atributos
    private Punto puntoA;
    private Punto puntoB;

    //Constructor1
    public Linea() {
        puntoA = new Punto(0, 0);
        puntoB = new Punto(0, 0);
    }

    //Constructor 2
    public Linea(Punto puntoA, Punto puntoB) {
        this.puntoA = puntoA;
        this.puntoB = puntoB;
    }

    //Getters y Setters
    public Punto getPuntoA() {
        return puntoA;
    }

    public void setPuntoA(Punto puntoA) {
        this.puntoA = puntoA;
    }

    public Punto getPuntoB() {
        return puntoB;
    }

    public void setPuntoB(Punto puntoB) {
        this.puntoB = puntoB;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Linea linea = (Linea) o;
        return puntoA.equals(linea.puntoA) && puntoB.equals(linea.puntoB);
    }

    @Override
    public int hashCode() {
        int result = puntoA.hashCode();
        result = 31 * result + puntoB.hashCode();
        return result;
    }

    public void moverDerecha(double distancia) throws LineaException {
        if (distancia < 0) {
            throw new LineaException("La distancia no puede ser negativa");
        }
        puntoA.setCoordenadaX(puntoA.getCoordenadaX() + distancia);
        puntoB.setCoordenadaX(puntoB.getCoordenadaX() + distancia);
    }

    public void moverIzquierda(double distancia) throws LineaException {
        if (distancia < 0) {
            throw new LineaException("La distancia no puede ser negativa");
        }
        puntoA.setCoordenadaX(puntoA.getCoordenadaX() - distancia);
        puntoB.setCoordenadaX(puntoB.getCoordenadaX() - distancia);
    }

    public void moverArriba(double distancia) throws LineaException {
        if (distancia < 0) {
            throw new LineaException("La distancia no puede ser negativa");
        }
        puntoA.setCoordenadaY(puntoA.getCoordenadaY() + distancia);
        puntoB.setCoordenadaY(puntoB.getCoordenadaY() + distancia);
    }

    public void moverAbajo(double distancia) throws LineaException {
        if (distancia < 0) {
            throw new LineaException("La distancia no puede ser negativa");
        }
        puntoA.setCoordenadaY(puntoA.getCoordenadaY() - distancia);
        puntoB.setCoordenadaY(puntoB.getCoordenadaY() - distancia);
    }
}
