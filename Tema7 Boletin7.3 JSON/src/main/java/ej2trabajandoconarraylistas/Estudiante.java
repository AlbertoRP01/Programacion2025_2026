package ej2trabajandoconarraylistas;

public class Estudiante {
    private String nombre;
    private String curso;
    private double notaMedia;

    public Estudiante(String nombre, String curso, double notaMedia) {
        this.nombre = nombre;
        this.curso = curso;
        this.notaMedia = notaMedia;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Estudiante:\n");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", curso='").append(curso).append('\'');
        sb.append(", notaMedia=").append(notaMedia);
        sb.append('}');
        return sb.toString();
    }
}
