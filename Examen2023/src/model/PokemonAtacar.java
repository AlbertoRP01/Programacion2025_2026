package model;

import enums.WeatherCondition;
import exceptions.MuerteException;
import exceptions.ValorNoValidoException;
import interfaces.Atacable;
import interfaces.Atacador;

public abstract class PokemonAtacar extends Pokemon implements Atacable {

    public PokemonAtacar(String nombre, int puntosdSalud, int nivelAtaque, int nivelDefensa) throws ValorNoValidoException {
        super(nombre, puntosdSalud, nivelAtaque, nivelDefensa);
    }

    @Override
    public void recibirDanio(WeatherCondition tiempo, int puntosAtaque, Atacador atacador) throws MuerteException {
        if (puntosAtaque <= 0) {
            return;
        }
        double factorDefensa = 1 - (getNivelDefensa() -100 );
        int dannioFinal =  (int) (puntosAtaque  * factorDefensa);
        setPuntosdSalud(getPuntosdSalud() - dannioFinal);
        if (!estaVivo()){
            throw new MuerteException("El pokemon" + getNombre() +  "Ha fallecido");
        }
    }
}
