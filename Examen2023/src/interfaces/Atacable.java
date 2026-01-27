package interfaces;

import enums.WeatherCondition;
import exceptions.MuerteException;
import model.Pokemon;

public interface Atacable {
     void recibirDanio(WeatherCondition tiempo, int puntosAtaque, Atacador atacador) throws MuerteException;
}
