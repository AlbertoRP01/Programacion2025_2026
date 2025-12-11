package clases;

import java.time.LocalDate;
import java.time.Period;

public class Revision {
    private LocalDate fecha;
    private boolean estado;
    private Period periodoValidez;

    public Revision(LocalDate fecha, Period periodoValidez, boolean estado) {
        this.fecha = fecha;
        this.periodoValidez = periodoValidez;
        this.estado = estado;
    }

    public Period getPeriodoValidez() {
        return periodoValidez;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setPeriodoValidez(Period periodoValidez) {
        this.periodoValidez = periodoValidez;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\tRevision:");
        sb.append("\n\tFecha:").append(getFecha()).append(".");
        sb.append("\n\tEstado:").append(isEstado()).append(".");
        sb.append("\n\tPeriodo de Validez:").append(".");
        return sb.toString();
    }
}
