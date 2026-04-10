package ej4adaptadorespersonalizadosmanejodefechas;

import java.io.Serial;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

public class Evento {
    private String nombre;
    private LocalDate fecha;

    public Evento(String nombre, LocalDate fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

}
