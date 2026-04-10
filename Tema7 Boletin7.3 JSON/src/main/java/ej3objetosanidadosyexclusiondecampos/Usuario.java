package ej3objetosanidadosyexclusiondecampos;

import com.google.gson.annotations.Expose;

public class Usuario {
    @Expose
    private String username;
    @Expose(serialize = false)
    private String password;
    @Expose
    private String email;
    @Expose
    private Direccion direccion;

    public Usuario(String username, String password, String email, Direccion direccion) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.direccion = direccion;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Usuario{");
        sb.append("direccion=").append(direccion);
        sb.append(", email='").append(email).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
