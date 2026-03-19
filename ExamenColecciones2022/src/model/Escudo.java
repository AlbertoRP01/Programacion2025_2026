package model;



public  class Escudo extends Cromo {
    private String nombreEquipo;
    private int annoFundacion;
    int numJugadores;

    public Escudo(int id, String nombreEquipo, int annoFundacion, int numJugadores) {
        super(id);
        this.nombreEquipo = nombreEquipo;
        this.annoFundacion = annoFundacion;
        this.numJugadores = numJugadores;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public int getAnnoFundacion() {
        return annoFundacion;
    }

    public int getNumJugadores() {
        return numJugadores;
    }

    @Override
    public String getNombre() {
        return this.nombreEquipo;
    }

    @Override
    public String getNombreParaOrdenar() {
        return this.getNombreEquipo();
    }

    @Override
    public String getEquipo() {
        return this.getNombreEquipo();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Escudo{");
        sb.append("id=").append(getId());
        sb.append(", nombreEquipo='").append(nombreEquipo).append('\'');
        sb.append(", annoFundacion=").append(annoFundacion);
        sb.append(", numJugadores=").append(numJugadores);
        sb.append('}');
        return sb.toString();
    }
}

