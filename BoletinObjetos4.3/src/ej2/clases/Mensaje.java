package ej2.clases;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Mensaje {
    private String asunto;
    private String cuerpo;
    private LocalDateTime fechaEnvio;
    private Persona remitente;
    private Persona destinatario;

    public Mensaje(String asunto, String cuerpo, Persona remitente, Persona destinatario, LocalDateTime fechaEnvio) {
        this.asunto = asunto;
        this.cuerpo = cuerpo;
        this.fechaEnvio = fechaEnvio;
        this.remitente = remitente;
        this.destinatario = destinatario;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    public Persona getRemitente() {
        return remitente;
    }

    public Persona getDestinatario() {
        return destinatario;
    }

}
