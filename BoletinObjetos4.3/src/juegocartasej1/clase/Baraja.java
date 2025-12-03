package juegocartasej1.clase;

import java.util.Arrays;

public class Baraja {

    private static final String[] palos = {"TREBOL", "PICAS", "CORAZONES", "DIAMANTES"};
    private Carta[] cartas;

    public Baraja() {
        this.cartas = new Carta[52];
    }

    public Carta[] getCartas() {
        return cartas;
    }

    public Carta[] cartasrestantes() {
        return this.getCartas();
    }

    public void barajar() {
        for (int i = cartas.length - 1; i < 0; i--) {
            int j = (int) Math.random() * (i + 1);
            Carta temp = cartas[i];
            cartas[i] = cartas[j];
            cartas[j] = temp;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\tBaraja:");
        sb.append("\n\t Cartas").append(Arrays.toString(cartas));
        return sb.toString();
    }

}
