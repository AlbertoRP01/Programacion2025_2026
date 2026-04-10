package ej1primercontacto;

public class Videojuego {
    private String titulo;
    private String desarolladora;
    private int annioLanzamiento;

    public Videojuego(String titulo, String desarolladora, int annioLanzamiento) {
        this.titulo = titulo;
        this.desarolladora = desarolladora;
        this.annioLanzamiento = annioLanzamiento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDesarolladora() {
        return desarolladora;
    }

    public void setDesarolladora(String desarolladora) {
        this.desarolladora = desarolladora;
    }

    public int getAnnioLanzamiento() {
        return annioLanzamiento;
    }

    public void setAnnioLanzamiento(int annioLanzamiento) {
        this.annioLanzamiento = annioLanzamiento;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Videojuego:\n");
        sb.append("titulo='").append(titulo).append('\'');
        sb.append(", desarolladora='").append(desarolladora).append('\'');
        sb.append(", annioLanzamiento=").append(annioLanzamiento);
        sb.append('}');
        return sb.toString();
    }
}
