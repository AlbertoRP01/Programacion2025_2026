package juegocartasej1.clase;

import juegocartasej1.excepciones.BarajaException;

import java.util.Arrays;

public class Baraja {
    public final int TAM_BARAJA = 52;
    private static final String[] palos = {"TREBOL", "PICAS", "CORAZONES", "DIAMANTES"};
    private Carta[] cartas;
   private int indiceSiguienteCarta = 0;
    private int cartasDisponibles = TAM_BARAJA ;
    public Baraja() {
        this.cartas = new Carta[TAM_BARAJA];
    }

    public Carta[] getCartas() {
        return cartas;
    }

    public void crearBaraja(){
        int posicion = 0;
        for (int i = 0; i < palos.length; i ++){
            for (int j = 1; j  <= 13; j ++){
                cartas[posicion] = new Carta(palos[i], j);
                posicion ++;
            }
        }
    }
    public void barajar() {
        for (int i = cartas.length - 1; i >= 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            Carta temp = cartas[i];
            cartas[i] = cartas[j];
            cartas[j] = temp;
        }
    }
    public void repartirBaraja(int numjugadores, int numCartas) throws BarajaException {

        int reparto = numjugadores * numCartas;
        if (reparto > cartasDisponibles){
            throw new BarajaException("No quedan cartas para repartir a mas jugadores");
        }

        indiceSiguienteCarta += reparto;
        cartasDisponibles -= indiceSiguienteCarta;
        System.out.println("Las cartas disponibles: " + cartasDisponibles);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\tBaraja:");
        sb.append("\n\t Cartas").append(Arrays.toString(cartas));
        return sb.toString();
    }

}
