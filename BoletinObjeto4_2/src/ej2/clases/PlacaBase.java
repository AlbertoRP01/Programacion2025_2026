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

    /**
     * TODO: Este método booleano devuelve la compatibilidad de ambos comonentes
     * @param microprocesador
     * @return devuelve en el caso de que el microprocesador sea compatible con la placa base
     */
    public boolean compatible(Microprocesador microprocesador)  {
        return this.socket.equalsIgnoreCase(microprocesador.getSocket());
    }

    /**
     * TODO: Aqui en este metodo es si es compatible la placa  base con el procesador
     * @param microprocesador
     * @throws PlacaBaseException en el caso de que no encuentre compatibilidad lanza excepción
     */
    public void compatible2(Microprocesador microprocesador) throws PlacaBaseException {
        if (!this.socket.equalsIgnoreCase(microprocesador.getSocket())){
            throw new PlacaBaseException("El microprocesador no es compatible con la placa Base");
        }
    }
    @Override
    public String toString() {
        return "PlacaBase:\n" +
                String.format("Marca: %s\n", getMarca()) +
                String.format("Chipset: %s \n", getChipset()) +
                String.format("Socket: %s",getSocket()) +
                '.';
    }
}
