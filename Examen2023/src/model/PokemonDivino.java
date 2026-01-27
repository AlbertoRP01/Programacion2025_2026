package model;

import enums.WeatherCondition;
import exceptions.MuerteException;
import exceptions.RoundStartException;
import exceptions.ValorNoValidoException;
import interfaces.Atacable;

public class PokemonDivino extends Pokemon{
    public PokemonDivino(String nombre, int puntosdSalud, int nivelAtaque, int nivelDefensa) throws ValorNoValidoException {
        super(nombre, puntosdSalud, nivelAtaque, nivelDefensa);
    }

    @Override
    public void atacar(Atacable objetivo, WeatherCondition tiempo) throws MuerteException {
        objetivo.recibirDanio(tiempo, getNivelAtaque(), this);
    }


    @Override
    public void roundStart(WeatherCondition tiempo) throws RoundStartException {
        throw new RoundStartException("El pokemon " + getNombre() + "no puede morir ");
    }
}
