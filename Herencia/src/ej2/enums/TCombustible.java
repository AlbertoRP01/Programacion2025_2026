package ej2.enums;

public enum TCombustible {
    DIESEL(2), GASOLINA(3.5);
    private double precioDia;

    TCombustible(double precioDia) {
        this.precioDia = precioDia;
    }

    public double getPrecioDia() {
        return precioDia;
    }
}
