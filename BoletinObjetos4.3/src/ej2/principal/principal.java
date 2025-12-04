package ej2.principal;

import ej2.clases.Mensaje;
import ej2.clases.Persona;
import ej2.excepciones.MensajeException;
import util.MiEntradaSalida;

import javax.crypto.spec.PSource;

public class principal {
    static void main(String[] args) {
        System.out.println("----------Bienvenido a GMAIL");
        String nombre = MiEntradaSalida.solicitarCadena("Introduce el nombre");
        String destinatario = MiEntradaSalida.solicitarCadena("Introduce el destinatario");
        String asunto =  MiEntradaSalida.solicitarCadena("Introduce el asunto");
        String cuerpo = MiEntradaSalida.solicitarCadena("Introduc el cuerpo del mensaje");

        Persona p = new Persona(nombre);
        Persona p2 = new Persona("Pepe");

        try {
            p.enviarMensaje(asunto,cuerpo,p2);
            p.enviarMensaje(asunto, cuerpo, p2);
            p.enviarMensaje(asunto, cuerpo, p2);
            p.enviarMensaje(asunto,cuerpo,p2);
            p.enviarMensaje(asunto, cuerpo, p2);
            p.enviarMensaje(asunto, cuerpo, p2);

        }catch (MensajeException e){
            System.out.println(e.getMessage());
        }
        try {

            p.borrarMensajeEnviadoMasAntiguo();
            p.borrarMensajeRecibidoMasAntiguo();
            p.enviarMensaje(asunto,cuerpo, p2);

        }catch (MensajeException e){
            System.out.println(e.getMessage());
        }
    }
}
