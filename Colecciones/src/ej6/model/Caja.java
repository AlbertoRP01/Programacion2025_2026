package ej6.model;

import ej6.excepciones.CajaException;
import ej6.excepciones.SupermercadoException;

import java.util.*;

public class Caja implements Comparable<Caja> {
    public final int NUM_DE_CAJA;
    private int contador = 1;
    Queue<Integer> clientes;
    boolean abierta;

    public Caja() {
        this.NUM_DE_CAJA = contador++;
        this.clientes = new LinkedList<>();
        this.abierta = false;
    }

    public boolean isAbierta() {
        return abierta;
    }

    public int getNUM_DE_CAJA() {
        return NUM_DE_CAJA;
    }

    public Queue<Integer> getClientes() {
        return clientes;
    }

    public void setAbierta(boolean abierta) {
        this.abierta = abierta;
    }

    public void cajaAbierta() {
        if (abierta) {
            throw new CajaException("La caja está cerrada");
        }
        abierta = true;
    }

    public void cajaCerrada() {
        if (!abierta || !clientes.isEmpty()) {
            throw new CajaException("La caja está abierta");
        }
        abierta = false;
    }

    public void annadirCliente(int cliente) {
        clientes.add(cliente);
    }

    public int comprobarnumeroClientes() {
        return clientes.size();
    }
    public void  atenderCliente(){
        if (abierta|| clientes.isEmpty()){
            clientes.remove();
        }else {
            throw new SupermercadoException("No se puede atender");
        }
    }
    @Override
    public int compareTo(Caja o) {
        if (comprobarnumeroClientes() == o.comprobarnumeroClientes()) {
            return NUM_DE_CAJA - o.NUM_DE_CAJA;
        }
        return comprobarnumeroClientes() - o.comprobarnumeroClientes();
    }
}
