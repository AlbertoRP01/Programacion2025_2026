package ej2.enums;

public enum TGama {
    BAJA(30), MEDIA(40), ALTA(50);
    private double precioBase;

    TGama(double precioBase) {
        this.precioBase = precioBase;
    }

    public double getPrecioBase() {
        return precioBase;
    }
}
