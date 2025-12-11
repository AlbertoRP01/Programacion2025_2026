package clases;

import excepciones.AvionException;

import java.time.LocalDate;
import java.util.PrimitiveIterator;

public class Avion {
    private String marca;
    private String modelo;
    private double consumo;
    private Revision[] revisiones;
    private Deposito deposito;

    public Avion(String marca, String modelo, Deposito deposito) {
        this.marca = marca;
        this.modelo = modelo;
        this.revisiones = new Revision[20];
        this.deposito = deposito;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void annadirRevision(Revision revision) throws AvionException {
        for (int i = 0; i < revisiones.length; i++) {
            if (revisiones[i] != null) {
                throw new AvionException("Está lleno");
            }
            revisiones[i] = revision;
        }
    }

    public boolean estaListo() {
        try {
            Revision utlimaRevision = getUltimaRevision();
            if (getUltimaRevision().isEstado() && utlimaRevision.getFecha().plus(getUltimaRevision().getPeriodoValidez()).isBefore(LocalDate.now())){
                return false;
            }else {
                return true;
            }
        } catch (AvionException e) {
            return false;
        }
    }

    public Revision getUltimaRevision() throws AvionException {
        for (int i = revisiones.length - 1; i >= 0; i--) {
            if (revisiones[i] != null) {
                return revisiones[i];
            }
        }
        throw new AvionException("El avion no tiene revisiones");
    }
}
