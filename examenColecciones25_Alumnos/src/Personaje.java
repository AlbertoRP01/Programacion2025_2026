import java.util.*;

public class Personaje {
    private String nombre;
    private TRaza raza;

    private final int vidaMax;
    private final int kiMax;

    private int nivelVidaActual;
    private int nivelKiActual;
    private Set<Ataque> ataques;
    ;

    public Personaje(String nombre, TRaza raza, int vidaMax, int nivelVidaActual, int kiMax, int nivelKiActual) {
        this.nombre = nombre;
        this.raza = raza;
        this.vidaMax = vidaMax;
        this.kiMax = kiMax;
        this.nivelVidaActual = Math.min(nivelVidaActual, vidaMax);
        this.nivelKiActual = Math.min(nivelKiActual, kiMax);
        this.ataques = new LinkedHashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivelVidaActual() {
        return nivelVidaActual;
    }

    public int getNivelKiActual() {
        return nivelKiActual;
    }

    public TRaza getRaza() {
        return raza;
    }

    public Set<Ataque> getAtaques() {
        return ataques;
    }

    public void setNivelVidaActual(int nivelVidaActual) {
        this.nivelVidaActual = nivelVidaActual;
    }

    public void addAtaque(Ataque ataque) throws DBException {
        if (!ataques.add(ataque)) {
            throw new DBException("El ataque ya existe");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Personaje personaje = (Personaje) o;
        return nombre.equalsIgnoreCase(personaje.nombre) && raza == personaje.raza;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre.toLowerCase(), raza);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Personaje:\n");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", raza=").append(raza);
        sb.append(", vidaMax=").append(vidaMax);
        sb.append(", kiMax=").append(kiMax);
        sb.append(", nivelVidaActual=").append(nivelVidaActual);
        sb.append(", nivelKiActual=").append(nivelKiActual);
        sb.append(", ataques=").append(ataques);
        sb.append('}');
        return sb.toString();
    }
}
