package clases;

import excepciones.PeliculaException;

public class Pelicula {

    private String titulo;
    private int annoEstreno;
    private double presupuesto;
    private double recaudacion;
    private String sinopsis;
    private String etiquetas;
    private double valoracion;

    public Pelicula(String titulo, int annoEstreno, double presupuesto, double recaudacion, String sinopsis, String etiquetas) {
        this.titulo = titulo;
        this.annoEstreno = annoEstreno;
        this.presupuesto = presupuesto;
        this.recaudacion = recaudacion;
        this.sinopsis = sinopsis;
        this.etiquetas = etiquetas;
        this.valoracion = calcularValoracion();
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnnoEstreno() {
        return annoEstreno;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public double getRecaudacion() {
        return recaudacion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public String getEtiquetas() {
        return etiquetas;
    }

    public double getValoracion() {
        return valoracion;
    }

    public void setPresupuesto(double presupuesto) throws PeliculaException {
        if (presupuesto < 0){
            throw new PeliculaException("El presupuesto no puede ser negativo");
        }
        this.presupuesto = presupuesto;
    }

    public double calcularValoracion() {
        if (recaudacion <= 0) return 0;
        if (recaudacion >= 2 * presupuesto) return 10;
        if (recaudacion == presupuesto) return 5;

        if (recaudacion < presupuesto) {
            // Entre 0 y presupuesto → 0 a 5
            return 5 * recaudacion / presupuesto;
        } else {
            // Entre presupuesto y 2*presupuesto → 5 a 10
            return 5 + 5 * (recaudacion - presupuesto) / presupuesto;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\tPeliculas:");
        sb.append("\n\tTitulo:").append(getTitulo()).append(".");
        sb.append("\n\tEstreno:").append(getAnnoEstreno()).append(".");
        sb.append("\n\tPresupuesto:").append(getPresupuesto()).append(".");
        sb.append("\n\tRecaudacion:").append(getRecaudacion()).append(".");
        sb.append("\n\tSinopsis:").append(getSinopsis()).append(".");
        sb.append("\n\tEtiquetas:").append(getEtiquetas()).append(".");
        sb.append("\n\tValoracion:").append(getValoracion()).append(".");
        return sb.toString();
    }
}
