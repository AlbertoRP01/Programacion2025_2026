package ej8.clase;

import ej8.excepciones.PartidoException;

import java.text.ParseException;

public class Partido {
    private int jornada;
    private String quiniela;
    private String estadio;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private int golesEquipoLocal;
    private int golesEquipoVisitante;

    private boolean jugado;

    public Partido(String estadio, Equipo equipoLocal, Equipo equipoVisitante) throws PartidoException {
        setJornada(jornada);
        this.estadio = estadio;
        if (equipoLocal.equals(equipoVisitante)){
            throw new PartidoException("Melón como va a jugar los mismos equipos");
        }
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.jugado = false;
    }

    public String getEstadio() {
        return estadio;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public int getGolesEquipoLocal() {
        return golesEquipoLocal;
    }

    public int getGolesEquipoVisitante() {
        return golesEquipoVisitante;
    }

    public int getJornada() {
        return jornada;
    }

    public void setJornada(int jornada) throws PartidoException {
        if (jornada < 1 || jornada > 38){
            throw new PartidoException("la jornada no puede ser negativa ni puede sobrepasar el limite de jornadas");
        }
        this.jornada = jornada;
    }

    public String resultadoQuiniela(){

    }
}
