package model;

import enums.WeatherCondition;
import exceptions.MuerteException;
import exceptions.RoundStartException;
import exceptions.ValorNoValidoException;
import interfaces.Atacable;
import interfaces.Atacador;

import java.security.PublicKey;
import java.util.IllegalFormatCodePointException;

public abstract class Pokemon implements Atacador {
    public static final int MAX_SALUD = 100;
    public static final int MAX_ATAQUE = 15;
    public static final int MIN_ATAQUE = 5;
    public static final int MAX_DEFENSA = 25;
    public static final int MIN_DEFENSA = 5;
    private String nombre;
    private int puntosdSalud;
    private int nivelAtaque;
    private int nivelDefensa;

    public Pokemon(String nombre, int puntosdSalud, int nivelAtaque, int nivelDefensa) throws ValorNoValidoException {
        this.nombre = nombre;
        setPuntosdSalud(puntosdSalud);
        setNivelAtaque(nivelAtaque);
        setNivelDefensa(nivelDefensa);
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntosdSalud() {
        return puntosdSalud;
    }

    public int getNivelAtaque() {
        return nivelAtaque;
    }

    public int getNivelDefensa() {
        return nivelDefensa;
    }

    public void setPuntosdSalud(int puntosdSalud) {
        if (puntosdSalud < 0){
            puntosdSalud = 0;
        }else if (puntosdSalud > MAX_SALUD){
                puntosdSalud = MAX_SALUD;
        }
        this.puntosdSalud = puntosdSalud;
    }


    public void setNivelAtaque(int nivelAtaque) throws ValorNoValidoException {
        if (nivelAtaque < MIN_ATAQUE || nivelAtaque > MAX_ATAQUE){
            throw new ValorNoValidoException("El valor de ataca debe estar entre " + MIN_ATAQUE + "y" + MAX_ATAQUE);
        }
        this.nivelAtaque = nivelAtaque;
    }

    public void setNivelDefensa(int nivelDefensa) throws ValorNoValidoException {
        if (nivelDefensa < MIN_DEFENSA || nivelDefensa > MAX_DEFENSA){
            throw new ValorNoValidoException("El valor de la defensa debe estar entre" + MIN_DEFENSA + "Y" + MAX_DEFENSA);
        }
        this.nivelDefensa = nivelDefensa;
    }

    @Override
    public abstract void atacar(Atacable objetivo, WeatherCondition tiempo) throws MuerteException;
    public abstract void roundStart(WeatherCondition tiempo) throws RoundStartException;
    public boolean estaVivo(){
        return getPuntosdSalud()  > 0;
    }
}
