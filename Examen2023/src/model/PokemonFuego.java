package model;

import enums.WeatherCondition;
import exceptions.MuerteException;
import exceptions.RoundStartException;
import exceptions.ValorNoValidoException;
import interfaces.Atacable;
import interfaces.Atacador;


public class PokemonFuego extends PokemonAtacar {
    /**
     * Este pokemon posee caracteristicas especiales cuando la ronda es soleada
     * resiste contra los pokemon de agua y tambien  un aumento de daño considerado
     */

    /**
     * Valor maximo permitido de resistrencia al agua
     */
    private static final int RESISTENCIA_AGUA_MAX = 15;

    /**
     * Valor minimo permitido de resistencia al agua
     */
    private static final int RESISTENCIA_AGUA_MIN = 5;
    /**
     * Valor actual de la resistencia al agua
     */
    private int resistenciaAgua;
    /**
     * El buff  de ataque al pokemon de fuego cuando aparece el sol al inicio de la ronda
     */
    private double bonificacionSol = 1.0;

    public PokemonFuego(String nombre, int puntosdSalud, int nivelAtaque, int nivelDefensa, int resistenciaAgua) throws ValorNoValidoException {
        super(nombre, puntosdSalud, nivelAtaque, nivelDefensa);
        setResistenciaAgua(resistenciaAgua);
    }

    public int getResistenciaAgua() {
        return resistenciaAgua;
    }

    /**
     * Aplicas limites en el valor de la resistencia de agua
     *
     * @param resistenciaAgua valor actual de la resistencia al agua
     * @throws ValorNoValidoException Evita que el valor sobrepase los rangos aplicados
     *
     */
    public void setResistenciaAgua(int resistenciaAgua) throws ValorNoValidoException {
        if (resistenciaAgua > RESISTENCIA_AGUA_MAX || resistenciaAgua < RESISTENCIA_AGUA_MIN) {
            throw new ValorNoValidoException("El valor de la resistencia de agua esta entre" + RESISTENCIA_AGUA_MIN + "e" + RESISTENCIA_AGUA_MAX);
        }
        this.resistenciaAgua = resistenciaAgua;
    }

    /**
     * Acciones que se realiza al inicio de cada ronda
     * durante el clima soleado recibe el pokemon de tipo fuego resistencia al agua, es decir a los pokemons de agua
     * por ultimo recibe una bonificacion de daño
     *
     * @param tiempo
     * @throws RoundStartException
     */
    @Override
    public void roundStart(WeatherCondition tiempo) throws RoundStartException {
        if (!estaVivo()) {
            return;
        }
        if (tiempo.equals(WeatherCondition.SOL)) {
            bonificacionSol = 1.0 + Math.random();
            throw new RoundStartException("El pokemon " + getNombre() + "recibe uan bonificacion por el sol");
        } else {
            bonificacionSol = 1.0;
        }

    }

    /**
     * Recibe daño del atacante, pero se aplica la defensa y resistencia de agua que le corresponde
     *
     * @param tiempo condicion climatica actual
     * @param puntosAtaque puntos de daño del atacante
     * @param atacador instancia del atacante
     * @throws MuerteException En el caso de que el pokemon muera tras el ataque
     */
    @Override
    public void recibirDanio(WeatherCondition tiempo, int puntosAtaque, Atacador atacador) throws MuerteException {
        if (atacador instanceof PokemonAgua) {
            puntosAtaque -= resistenciaAgua;
        }
        if (puntosAtaque < 0) {
            puntosAtaque = 0;
        }
        super.recibirDanio(tiempo, puntosAtaque, atacador);
    }

    /**
     * Ataca al objetivo aplicando  bonificacion por sol que le corresponde
     *
     * @param objetivo pokemon objetivo del ataque
     * @param tiempo condicion climatica actual
     * @throws MuerteException si el ataque provocado hace que muera al objetivo
     */
    @Override
    public void atacar(Atacable objetivo, WeatherCondition tiempo) throws MuerteException {
        int dannio = (int) (getNivelAtaque() * bonificacionSol);
        objetivo.recibirDanio(tiempo, dannio, this);
    }
}
