package ej3.model;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Mensaje {
    private Persona remitente;
    private String texto;
    private LocalDateTime fechaDeEnvio;

    public Mensaje(Persona remitente, String texto) {
        this.remitente = remitente;
        this.texto = texto;
        this.fechaDeEnvio = LocalDateTime.now();
    }

    public Persona getRemitente() {
        return remitente;
    }

    public String getTexto() {
        return texto;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        StringBuilder sb = new StringBuilder("\nMensaje de:\n");
        sb.append("Remitente:" + " ").append(remitente.getNombre()).append("\n");
        sb.append("Fecha de envio:" + " ").append(fechaDeEnvio.format(dtf)).append("\n");
        sb.append("Texto:\n" + " ").append(texto);
        return sb.toString();
    }
}
