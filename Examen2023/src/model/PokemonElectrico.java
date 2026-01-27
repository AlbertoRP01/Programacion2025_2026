package model;

import enums.WeatherCondition;
import exceptions.MuerteException;
import exceptions.RoundStartException;
import exceptions.ValorNoValidoException;
import interfaces.Atacable;

public class PokemonElectrico extends PokemonAtacar{


    public PokemonElectrico(String nombre, int puntosdSalud, int nivelAtaque, int nivelDefensa) throws ValorNoValidoException {
        super(nombre, puntosdSalud, nivelAtaque, nivelDefensa);
    }

    @Override
    public void atacar(Atacable objetivo, WeatherCondition tiempo) throws MuerteException {

    }

    @Override
    public void roundStart(WeatherCondition tiempo) throws RoundStartException {

    }
}
