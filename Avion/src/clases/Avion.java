package clases;

import com.sun.source.tree.YieldTree;
import excepciones.AvionException;

import javax.swing.table.TableRowSorter;
import java.time.LocalDate;
import java.util.Arrays;
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

    public double getConsumo() {
        return consumo;
    }

    public Revision[] getRevisiones() {
        return revisiones;
    }

    public Deposito getDeposito() {
        return deposito;
    }

    public void setConsumo(double consumo) throws AvionException {
        if (consumo < 0) {
            throw new AvionException("El consumo no puede ser negativo");
        }
        this.consumo = consumo;
    }

    public boolean esValido() {
        try {
            Revision ultimaRevision = ultimaRevision();
            return (ultimaRevision.isEstado() && ultimaRevision.getFecha().plus(ultimaRevision.getPeriodoValidez()).isBefore(LocalDate.now()));
        } catch (AvionException e) {
            return false;
        }
    }

    public void annadirRevision(Revision revision) throws AvionException {
        for (int i = 0; i < revisiones.length; i++) {
            if (revisiones[i] != null) {
                throw new AvionException("Está lleno");
            }
            revisiones[i] = revision;
            return;
        }
    }

    public boolean puedeVolar(double distancia) {
        if (!esValido() || distancia * this.consumo > deposito.getCapacidadActual() || distancia < 0) {
            return false;
        }
        return true;
    }

    public Revision ultimaRevision() throws AvionException {
        for (int i = revisiones.length - 1; i >= 0; i--) {
            if (revisiones[i] != null) {
                return revisiones[i];
            }
        }
        throw new AvionException("La revision no existe");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\tAvion:");
        sb.append("\n\tMarca:").append(getMarca()).append(".");
        sb.append("\n\tModelo:").append(getModelo()).append(".");
        sb.append("\n\tRevisiones").append(esValido()).append(".");
        sb.append("\n\tDeposito").append(getDeposito()).append(".");

        return sb.toString();
    }
}
