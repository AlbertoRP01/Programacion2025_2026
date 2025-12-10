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

}
