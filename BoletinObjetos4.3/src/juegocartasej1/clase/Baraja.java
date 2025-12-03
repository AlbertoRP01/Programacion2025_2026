package juegocartasej1.clase;

import juegocartasej1.excepciones.BarajaException;

import java.util.Arrays;

public class Baraja {
    public final int TAM_BARAJA = 52;
    private static final String[] palos = {"TREBOL", "PICAS", "CORAZONES", "DIAMANTES"};
    private Carta[] cartas;
   private int indiceSiguienteCarta = 0;
    public Baraja() {
        this.cartas = new Carta[TAM_BARAJA];
    }

    public Carta[] getCartas() {
        return cartas;
    }

    public Carta[] cartasRestantes() {
        int restantes = TAM_BARAJA - indiceSiguienteCarta;
        Carta[] resultado = new Carta[restantes];

        for (int i = 0; i < restantes; i++) {
            resultado[i] = cartas[indiceSiguienteCarta + i];
        }

        return resultado;
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
        int cartasDisponibles = TAM_BARAJA - indiceSiguienteCarta ;
        int reparto = numjugadores * numCartas;
        if (reparto > cartasDisponibles){
            throw new BarajaException("No quedan cartas para repartir a mas jugadores");
        }
        indiceSiguienteCarta += reparto;
        System.out.println("Las cartas restantes:" + Arrays.toString(cartasRestantes()));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\tBaraja:");
        sb.append("\n\t Cartas").append(Arrays.toString(cartas));
        return sb.toString();
    }

}
