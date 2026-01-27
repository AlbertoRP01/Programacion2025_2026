package model;

import enums.WeatherCondition;
import exceptions.MuerteException;
import exceptions.RoundStartException;
import exceptions.ValorNoValidoException;
import interfaces.Atacable;
import interfaces.Atacador;

public class PokemonAgua extends PokemonAtacar {
    /**
     * Valores maximos y mínimos permitidos de hidratación.
     */
    private static final int VALOR_HIDRATACION_MAX = 20;

    private static final int VALOR_HIDRATACION_MIN = 10;
    /*
        cantidad de hidratación que influye en la curación bajo  lluvia.
     */
    private int hidratacion;

    private double precision = 1.0;

    /**
     * Constructor de pokemon tipo agua
     *
     * @param nombre
     * @param puntosdSalud
     * @param nivelAtaque
     * @param nivelDefensa
     * @param hidratacion
     * @throws ValorNoValidoException
     */
    public PokemonAgua(String nombre, int puntosdSalud, int nivelAtaque, int nivelDefensa, int hidratacion) throws ValorNoValidoException {
        super(nombre, puntosdSalud, nivelAtaque, nivelDefensa);
        setHidratacion(hidratacion);
    }

    /**
     * El valor actual de hidratación
     *
     * @return
     */
    public int getHidratacion() {
        return hidratacion;
    }

    /**
     * Establece un valor limitado de hidratacion dentro del rango establecido
     *
     * @param hidratacion
     * @throws ValorNoValidoException En el caso de que el valor esté fuera de rango
     */
    public void setHidratacion(int hidratacion) throws ValorNoValidoException {
        if (hidratacion > VALOR_HIDRATACION_MAX || hidratacion < VALOR_HIDRATACION_MIN) {
            throw new ValorNoValidoException("El valor de hidratación debe estar entre" + VALOR_HIDRATACION_MIN + " e " + VALOR_HIDRATACION_MAX);
        }
        this.hidratacion = hidratacion;
    }

    /**
     * Ataca al objetivo teniendo en cuenta la precisión actual
     *
     * @param objetivo
     * @param tiempo
     * @throws MuerteException
     */
    @Override
    public void atacar(Atacable objetivo, WeatherCondition tiempo) throws MuerteException {
        int dannio = (int) (getNivelAtaque() * precision);
        objetivo.recibirDanio(tiempo, dannio, this);
    }

    /**
     * acciones que sucede al inicio de cada ronda
     * bajo lluvia, se cura el pokemon
     *
     * @param tiempo
     * @throws RoundStartException si ocurre un evento especial en la ronda
     */
    @Override
    public void roundStart(WeatherCondition tiempo) throws RoundStartException {
        if (!estaVivo()) {
            return;
        }
        precision = 1.0;
        if (tiempo.equals(WeatherCondition.LLUVIA)) {
            setPuntosdSalud(getPuntosdSalud() + hidratacion);
            precision += Math.random();
        }
        throw new RoundStartException("El pokemon" + getNombre() + "recibe  una curacion por la lluvia");
    }
}
