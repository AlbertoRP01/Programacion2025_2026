package ej6.model;

import ej6.excepciones.SupermercadoException;
import mientradasalida.MiEntradaSalida;

import java.util.ArrayList;
import java.util.List;

public class Almacen {
    private static final int NUM_MAX_CAJAS = 20;
    private List<Caja> cajas;

    public Almacen() {
        this.cajas = new ArrayList<>(NUM_MAX_CAJAS);
    }

    public void nuevoCliente() {
        int cliente = 1;
        cliente++;
        Caja c = cajas.stream().filter(Caja::isAbierta).min(Caja::compareTo).orElseThrow(() -> new SupermercadoException("No puede añadir al cliente"));
        c.annadirCliente(cliente);
        System.out.println("El cliente numero" + cliente + "se ha ido a la caja" + c.getNUM_DE_CAJA());
    }

    public void atenderCliente() {
        int numeroDeCajaElegida = MiEntradaSalida.leeEnteroRango("Que caja quieres atender", 1, cajas.size() - 1);
        cajas.get(numeroDeCajaElegida).atenderCliente();
    }

}
