package ej2;

import mientradasalida.MiEntradaSalida;

public class CuentaCorriente {
    private int saldo;
    private int numeroRetiro;
    private int numeroIngreso;

    public CuentaCorriente(int saldoInicial) {
        this.numeroRetiro = 0;
        this.saldo =  Math.max(0, saldoInicial );
        this.numeroIngreso = 0;
    }

    public int getSaldo() {
        return saldo;
    }

    public int getNumeroRetiro() {
        return numeroRetiro;
    }

    public int getNumeroIngreso() {
        return numeroIngreso;
    }

    public int hacerReintegro(int cantidadRetirar) throws CuentaCorrienteException {
        if (cantidadRetirar <= 0) {
            throw new CuentaCorrienteException("No se puedes retirar numeros negativos en su cuenta");

        }
        if (cantidadRetirar > this.saldo) {
            throw new CuentaCorrienteException("No puedes retirar una cantidad mayor que el saldo actual de su cuenta");
        }
        this.saldo -= cantidadRetirar;
        numeroRetiro++;
        return this.saldo;
    }

    public int hacerIngreso(int cantidadIngresar) throws CuentaCorrienteException {
        if (cantidadIngresar <= 0) {
            throw new CuentaCorrienteException("No se puedes ingresar numeros negativos en su cuenta");

        }
        this.saldo += cantidadIngresar;
        numeroIngreso++;
        return this.saldo;
    }
    public void consultar(){
        System.out.printf("El saldo actual  es de: %d €\n ", getSaldo());

        System.out.printf("Los reintegros realizados es de: %d\n ",getNumeroRetiro());

        System.out.printf("Los Ingresos realizados es de: %d\n",  getNumeroIngreso());
    }

}
