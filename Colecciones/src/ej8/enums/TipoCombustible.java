package ej8.enums;

import ej8.model.Coche;

public enum TipoCombustible {
	GASOLINA(Coche.INCREMENTO_GASOLINA),
	DIESEL(Coche.INCREMENTO_DIESEL);
	
	private double incremento;
	
	private TipoCombustible ( double incremento) {
		this.incremento=incremento;
	}
	
	public double getIncremento() {
		return incremento;
	}
}
