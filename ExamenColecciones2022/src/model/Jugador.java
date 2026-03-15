package model;



public class Jugador extends Cromo {
    private String nombre;
    private String nombreEquipo;
    private double altura;

    public Jugador(int id, String nombre, String nombreEquipo, double altura) {
        super(id);
        this.nombre = nombre;
        this.nombreEquipo = nombreEquipo;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Jugador{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", nombreEquipo='").append(nombreEquipo).append('\'');
        sb.append(", altura=").append(altura);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public String getNombreParaOrdenar() {

        return this.getNombre();
    }

    @Override
    public String getEquipo() {
        return this.getNombreEquipo();
    }
}