package ej2.clases;

import ej2.excepciones.MensajeException;

import java.time.LocalDateTime;

public class Persona {
    private String nombre;
    private Mensaje[] buzonMensajeRecibidos;
    private Mensaje[] buzonMensajeEnviados;

    public Persona(String nombreRemi) {
        this.nombre = nombreRemi;
        this.buzonMensajeRecibidos = new Mensaje[5];
        this.buzonMensajeEnviados = new Mensaje[5];

    }

    public String getNombre() {
        return nombre;
    }

    public void enviarMensaje(String asunto, String cuerpo, Persona destinatario) throws MensajeException {
        if (asunto == null || asunto.isBlank() ||cuerpo == null ||cuerpo.isBlank() || destinatario == null) {
            throw new MensajeException("Error: Al mensaje le falta algo");
        }
        if (estaLlenoEnviado()){
            throw new MensajeException("esta lleno  el buzon");
        } if (estaLlenoRecibido()){
            throw new MensajeException("La otra persona no puede recibir el mensje");
        }


        Mensaje m = new Mensaje(asunto, cuerpo, this, destinatario, LocalDateTime.now());

        for (int i = 0; i < buzonMensajeEnviados.length; i ++){
            if (buzonMensajeEnviados[i] == null){
                buzonMensajeEnviados[i] = m;
                break;
            }
        }
        for (int i = 0; i < destinatario.buzonMensajeRecibidos.length; i ++){
            if (destinatario.buzonMensajeRecibidos[i] == null){
                destinatario.buzonMensajeRecibidos[i] = m;
                break;
            }
        }
        System.out.println("Se ha enviado correctamente");
    }

    public void borrarMensajeRecibidoMasAntiguo() {
        for (int i = 0; i < buzonMensajeRecibidos.length - 1 && buzonMensajeRecibidos[i] != null; i++) {
            buzonMensajeRecibidos[i] = buzonMensajeRecibidos[i + 1];
        }
        buzonMensajeRecibidos[buzonMensajeRecibidos.length - 1] = null;
    }

    public void borrarMensajeEnviadoMasAntiguo() {
        for (int i = 0; i < buzonMensajeEnviados.length - 1 && buzonMensajeEnviados[i] != null; i++) {
            buzonMensajeEnviados[i] = buzonMensajeEnviados[i + 1];
        }
        buzonMensajeEnviados[buzonMensajeEnviados.length - 1] = null;
    }


    public boolean estaLlenoRecibido() {
        for (int i = 0; i < buzonMensajeEnviados.length; i++) {
            if (buzonMensajeRecibidos[i] == null) {
                return false;
            }
        }
        return true;
    }

    public boolean estaLlenoEnviado() {
        for (int i = 0; i < buzonMensajeEnviados.length; i++) {
            if (buzonMensajeEnviados[i] == null) {
                return false;
            }
        }
        return true;
    }
}