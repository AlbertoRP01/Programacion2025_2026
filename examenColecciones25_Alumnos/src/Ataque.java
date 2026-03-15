import java.util.Objects;

public class Ataque {
    private String nombre;
    private int nivelKiNecesario;
    private int nivelPerfeccion;
    private int danioProvoca;

    public Ataque(String nombre, int danioProvoca, int nivelPerfeccion, int nivelKiNecesario) throws DBException {
        this.nombre = nombre;
        setDanioProvoca(danioProvoca);
        setNivelPerfeccion(nivelPerfeccion);
        setNivelKiNecesario(nivelKiNecesario);
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivelKiNecesario() {
        return nivelKiNecesario;
    }

    public int getNivelPerfeccion() {
        return nivelPerfeccion;
    }

    public int getDanioProvoca() {
        return danioProvoca;
    }

    public void setNivelKiNecesario(int nivelKiNecesario) throws DBException {
        if (nivelKiNecesario <= 0) {
            throw new DBException("El ki debe mayor a 0 ");
        }
        this.nivelKiNecesario = nivelKiNecesario;
    }

    public void setNivelPerfeccion(int nivelPerfeccion) throws DBException {
        if (nivelPerfeccion < 1 || nivelPerfeccion > 3) {
            throw new DBException("el nivel debe estar entre 1 y 3");
        }
        this.nivelPerfeccion = nivelPerfeccion;
    }

    public void setDanioProvoca(int danioProvoca) throws DBException {
        if (danioProvoca <= 0) {
            throw new DBException("el daño provocado debe ser mayor que 0");
        }
        this.danioProvoca = danioProvoca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ataque ataque = (Ataque) o;
        return nivelPerfeccion == ataque.nivelPerfeccion && danioProvoca == ataque.danioProvoca && nombre.equals(ataque.nombre);
    }

    @Override
    public int hashCode() {
      return Objects.hash(nombre.toLowerCase(), nivelPerfeccion, danioProvoca);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ataque{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", nivelKiNecesario=").append(nivelKiNecesario);
        sb.append(", nivelPerfeccion=").append(nivelPerfeccion);
        sb.append(", danioProvoca=").append(danioProvoca);
        sb.append('}');
        return sb.toString();
    }
}
