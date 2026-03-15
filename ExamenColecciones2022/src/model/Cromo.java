package model;

import java.util.Objects;

public abstract class Cromo implements Comparable<Cromo> {
    private int id;

    public Cromo(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public abstract String getNombre();
    public abstract String getNombreParaOrdenar();
    public abstract String getEquipo();
    @Override
    public boolean equals(Object o) {
        if (this == o)return true;
        if (!(o instanceof Cromo)) return false;
        Cromo cromo = (Cromo) o;
        return Objects.equals(id, cromo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Cromo o) {
        if (this instanceof Escudo && o instanceof Jugador) return  -1;
        if (this instanceof  Jugador && o instanceof Escudo) return  1;
        return this.getNombreParaOrdenar().compareToIgnoreCase(o.getNombreParaOrdenar());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cromo{");
        sb.append("id='").append(id).append('\'');
        sb.append('}');
        return sb.toString();
    }
}