package Ej3;

public class Maquina {
    private final int MAX_CAFE = 50;
    private final int MAX_LECHE = 50;
    private final int MAX_VASO = 80;
    private final double PRECIO_CAFE = 1;
    private final double PRECIO_LECHE = 0.8;
    private final  double PRECIO_CAFE_LECHE = 1.5;

    private int dosisCafe;
    private int dosisLeche;
    private int vaso;
    private double monedero;

    public Maquina() {
        this.dosisCafe = MAX_CAFE;
        this.dosisLeche = MAX_LECHE;
        this.vaso = MAX_VASO;
    }

    public Maquina(double monederoInicial) {
        monedero = Math.max(0, monederoInicial);
    }

    public int getDosisCafe() {
        return dosisCafe;
    }

    public int getDosisLeche() {
        return dosisLeche;
    }

    public int getVaso() {
        return vaso;
    }

    public double getMonedero() {
        return monedero;
    }

}
