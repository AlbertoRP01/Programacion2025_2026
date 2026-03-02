package ej6.model;

import ej6.exceptions.SupermercadoException;
import mientradasalida.MiEntradaSalida;
import mientradasalida.MiEntradaSalidaException;

import java.util.ArrayList;
import java.util.List;

public class Almacen {
    private static final int NUM_MAX_CAJAS = 20;
    private List<Caja> cajas;
    private int contadorClientes = 1;
    public Almacen() {
        this.cajas = new ArrayList<>(NUM_MAX_CAJAS);
        for (int i = 0; i < NUM_MAX_CAJAS; i++) {
            cajas.add(new Caja());
        }
    }

    public void nuevoCliente() {
        int  cliente = contadorClientes ++;
        Caja c = cajas.stream().filter(Caja::isAbierta).min(Caja::compareTo).orElseThrow(() -> new SupermercadoException("No puede añadir al cliente"));
        c.annadirCliente(cliente);
        System.out.println("El cliente numero " + cliente + " se ha ido a la caja" + c.getNUM_DE_CAJA());
        System.out.println(cajas.stream().map(Caja::isAbierta).toList());
    }

    public void atenderCliente() throws MiEntradaSalidaException {
        int numeroDeCajaElegida = MiEntradaSalida.leeEnteroRango("Que caja quieres atender", 1, cajas.size() - 1);
        cajas.get(numeroDeCajaElegida).atenderCliente();
    }

    public void abrirCaja() throws MiEntradaSalidaException {
        int numeroCaja = MiEntradaSalida.leeEnteroRango("Elige una caja que quieras abrir", 1, 20);
        Caja c = cajas.get(numeroCaja  -1 );
        System.out.println("Abriendo caja nº real: " + c.getNUM_DE_CAJA());
        c.cajaAbierta();
    }

    public void cerrarCaja() throws MiEntradaSalidaException {

        int numCaja = MiEntradaSalida.leeEnteroRango("Elige la caja que quieras cerrar", 1, 20);
       Caja c = cajas.get(numCaja - 1);
        System.out.println("Cerrando caja nº real: " + c.getNUM_DE_CAJA());
        c.cajaCerrada();
    }
}
