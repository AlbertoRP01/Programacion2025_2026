package ej2.clases;

import ej1.excepciones.PlacaBaseException;

public class PlacaBase {
    private String marca;
    private String chipset;
    private String socket;

    public PlacaBase(String marca, String chipset, String socket) {
        this.marca = marca;
        this.chipset = chipset;
        this.socket = socket;
    }

    public String getMarca() {
        return marca;
    }

    public String getChipset() {
        return chipset;
    }

    public String getSocket() {
        return socket;
    }
    public String compatible(Microprocesador microprocesador) throws PlacaBaseException {
        if (!this.socket.equalsIgnoreCase(microprocesador.getSocket())){
            throw new PlacaBaseException("El socket no es compatible");
        }
        return this.socket;
    }

    @Override
    public String toString() {
        return "PlacaBase:" +
                "marca='" + marca + '\'' +
                ", chipset='" + chipset + '\'' +
                ", socket='" + socket + '\'' +
                '.';
    }
}
