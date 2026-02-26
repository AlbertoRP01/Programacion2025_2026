package ej6.model;

import ej6.excepciones.CajaException;
import ej6.excepciones.SupermercadoException;

import java.util.*;

public class Caja implements Comparable<Caja> {
    /**
     * Constante del número de caja
     */
    public final int NUM_DE_CAJA;
    /**
     * Atributo del contador de clientes
     */
    private static int contador = 1;
    /**
     * La cola de clientes
     */
    Queue<Integer> clientes;
    /**
     * Atributo para saber si está abierta la caja
     */
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

    /**
     * Este metodo comprueba que este cerrada la caja
     */
    public void cajaCerrada() {
        if (!abierta || !clientes.isEmpty()) {
            throw new CajaException("La caja está abierta");
        }
        abierta = false;
    }

    /**
     *Este metodo añade clientes a la cola
     * @param cliente
     */
    public void annadirCliente(int cliente) {
        if (!abierta){
            throw new CajaException("La caja está cerrada");
        }
        clientes.add(cliente);
    }

    /**
     * Muestra el total de elementos en la cola
     * @return devuelve el total de elementos de la cola
     */
    public int comprobarnumeroClientes() {

        return clientes.size();
    }

    /**
     * Comprueba que el cliete es atendido, una vez atendido se elimina de la cola
     */
    public void  atenderCliente(){
        if (!abierta|| clientes.isEmpty()){
            throw new CajaException("No se puede atender en esta caja");
        }else {
            clientes.poll();

        }
    }

    /**
     * Metodo compara los numeros de clientes que hay en la cola para saber si
     * es 0 o >1 O < 0 de esta manera se comprueba el numero de clientes en la cola para llevarlos
     * a la caja correspondiente
     * @param o the object to be compared.
     * @return Lleva al cliente a la caja correspondiente
     */
    @Override
    public int compareTo(Caja o) {
        if (comprobarnumeroClientes() == o.comprobarnumeroClientes()) {
            return NUM_DE_CAJA - o.NUM_DE_CAJA;
        }
        return comprobarnumeroClientes() - o.comprobarnumeroClientes();
    }
}
