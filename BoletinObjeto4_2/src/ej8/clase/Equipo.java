package ej8.clase;

import java.util.Objects;

public class Equipo {
    private String nombre;
    private int numGoles;
    private int partidosGanados;

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumGoles() {
        return numGoles;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Equipo equipo = (Equipo) o;
        return numGoles == equipo.numGoles && partidosGanados == equipo.partidosGanados && Objects.equals(nombre, equipo.nombre);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(nombre);
        result = 31 * result + numGoles;
        result = 31 * result + partidosGanados;
        return result;
    }

    public int marcarGoles(){
       return this.numGoles ++;
    }

    public int partidosGanados(){
       return this.partidosGanados ++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\tpartidos: ");
        sb.append("\n\tnombre: ").append(getNombre()).append(".");
        sb.append("\n\tnumero de goles :").append(getNumGoles()).append(".");
        sb.append("\n\tpartidos ganados:").append(getPartidosGanados()).append(".");
        return sb.toString();
    }
}
