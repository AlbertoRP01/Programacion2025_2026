package ej3objetosanidadosyexclusiondecampos;

import com.google.gson.annotations.Expose;

public class Direccion {
    @Expose
    private String calle;
    @Expose
    private String ciudad;
    @Expose
    private int codigoPostal;

    public Direccion(String calle, String ciudad, int codigoPostal) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Direccion:\n");
        sb.append("calle='").append(calle).append('\'');
        sb.append(", ciudad='").append(ciudad).append('\'');
        sb.append(", codigoPostal=").append(codigoPostal);
        sb.append('}');
        return sb.toString();
    }
}
