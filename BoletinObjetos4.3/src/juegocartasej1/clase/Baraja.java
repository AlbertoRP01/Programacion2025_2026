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

    @Override
    public String toString() {
        return "Baraja{" +
                "cartas=" + Arrays.toString(cartas) +
                '}';
    }
}
