package model;

import enums.WeatherCondition;
import exceptions.MuerteException;
import exceptions.RoundStartException;
import exceptions.ValorNoValidoException;
import interfaces.Atacable;
import interfaces.Atacador;

public class PokemonTierra extends PokemonAtacar {
    /**
     * Este pokemon contiene unas caracteristicas especiales cuando ocurre un evento
     * en el que hay una tormenta de arena al inicio de la ronda procede a obtener resistencia electrica
     * Por ultimo obtiene una bonificacion de daño
     */

    /**
     * Valor maximo de la resistencia electrica;
     */
    private static final int RESISTENCIA_ELECTRICA_MAX = 9;

    /**
     * Valor minimo  de la  resistencia electrica
     */
    private static final int RESISTENCIA_ELECTRICA_MIN = 1;

    /**
     * Valor actual de la resistencia electrica
     */
    private int resistenciaElectrica;

    /**
     * La bonificacion de daño que recibe en la tormenta de arena
     */
    private double bonificacionTormenta = 1.0;

    public PokemonTierra(String nombre, int puntosdSalud, int nivelAtaque, int nivelDefensa, int resistenciaElectrica) throws ValorNoValidoException {
        super(nombre, puntosdSalud, nivelAtaque, nivelDefensa);
        setResistenciaElectrica(resistenciaElectrica);
    }

    public void setResistenciaElectrica(int resistenciaElectrica) throws ValorNoValidoException {
        if (resistenciaElectrica > RESISTENCIA_ELECTRICA_MAX || resistenciaElectrica < RESISTENCIA_ELECTRICA_MIN) {
            throw new ValorNoValidoException("El valor comprendido de la resistencia eléctrica está entre" + RESISTENCIA_ELECTRICA_MIN + "e" + RESISTENCIA_ELECTRICA_MAX);
        }
        this.resistenciaElectrica = resistenciaElectrica;
    }

    @Override
    public void atacar(Atacable objetivo, WeatherCondition tiempo) throws MuerteException {
        int dannio = (int) (getNivelAtaque() * bonificacionTormenta);
        objetivo.recibirDanio(tiempo, dannio, this);
    }


    @Override
    public void roundStart(WeatherCondition tiempo) throws RoundStartException {
        if (!estaVivo()){
            return;
        }
        if (tiempo.equals(WeatherCondition.TORMENTA_DE_ARENA)){
            bonificacionTormenta = 1.0 * Math.random();
            throw new RoundStartException("Pokemon" + getNombre()+ "recibe bonificacion por  tormenta de arena");
        }else {
            bonificacionTormenta = 1.0;
        }
    }

    @Override
    public void recibirDanio(WeatherCondition tiempo, int puntosAtaque, Atacador atacador) throws MuerteException {
        if (atacador instanceof PokemonElectrico){
            puntosAtaque -= resistenciaElectrica;
            if (puntosAtaque <= 0){
                puntosAtaque = 0;
            }
        }
        super.recibirDanio(tiempo, puntosAtaque, atacador);
    }
}
