package ej1;

import java.time.LocalDate;

public class Persona {
    private String nombre;
    private String dni;
    private String telefono;
    private LocalDate fechanac;

    public Persona(String nombre, String dni, String telefono, LocalDate fechanac) {
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.fechanac = fechanac;
    }



    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }



    public LocalDate getFechanac() {
        return fechanac;
    }

    public String getTelefono() {
        return telefono;
    }

    // Setters (opcionales para este ejercicio, pero buena práctica)
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDni(String dni) { this.dni = dni; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public void setFechanac(LocalDate fechaNacimiento) {
        this.fechanac = fechaNacimiento;
    }
}
