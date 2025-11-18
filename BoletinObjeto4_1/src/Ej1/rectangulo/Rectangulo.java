package Ej1.rectangulo;

import Ej1.exception.RectanguloException;

public class Rectangulo {

    private int longitud;
    private int ancho;

    public Rectangulo() {
        longitud = 1;
        ancho = 1;
    }

    public int getLongitud() {
        return longitud;
    }

    public int getAncho() {
        return ancho;
    }

    public void setLongitud(int longitud) throws RectanguloException {

        if (longitud < 0) {
            throw new RectanguloException("La longitud  que has introducido es demasiado corto");
        }
        if (longitud > 20) {
            throw new RectanguloException("La longitud que has introducido es demasiado largo");
        }
        this.longitud = longitud;
    }

    public void setAncho(int ancho) throws RectanguloException {
        if (ancho < 0) {
            throw new RectanguloException("El ancho que has introducido es demasiado pequeño");
        }
        if (ancho > 20) {
            throw new RectanguloException("El ancho que has introducido es demeasiado grande");
        }
        this.ancho = ancho;
    }

    public int calcularPerimetro() {
        return 2 * (this.ancho + this.longitud);
    }

    public int calcularArea() {
        return this.ancho * this.longitud;
    }
}
