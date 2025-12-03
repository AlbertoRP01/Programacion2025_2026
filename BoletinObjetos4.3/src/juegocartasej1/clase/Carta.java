package juegocartasej1.clase;

public class Carta {
    private String palo;
    private int numero;

    public Carta(String palo, int numero) {
        this.palo = palo;
        this.numero = numero;
    }

    public String getPalo() {
        return palo;
    }

    public int getNumero() {
        return numero;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\t palo: ").append(getPalo()).append(".");
        sb.append("\n\t numero :").append(getNumero()).append(".");
        return sb.toString();
    }
}
