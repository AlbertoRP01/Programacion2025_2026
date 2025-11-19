package ej2.cuenta;

import ej2.exceptions.CuentaCorrienteException;

public class CuentaCorriente {
    //Atributos
    private int saldo;
    private int numeroRetiro;
    private int numeroIngreso;

    //Constructor
    public CuentaCorriente(int saldoInicial) {
        this.numeroRetiro = 0;
        this.saldo = Math.max(0, saldoInicial);
        this.numeroIngreso = 0;
    }
    //Getter y Setters
    public int getSaldo() {
        return saldo;
    }

    public int getNumeroRetiro() {
        return numeroRetiro;
    }

    public int getNumeroIngreso() {
        return numeroIngreso;
    }

    /**
     * Creamos la forma de retirar el dinero y saber cuantas veces has retirado dinero del saldo
     * @param cantidadRetirar la variable que está en el  parámetro del método
     * @return devuelve el saldo
     * @throws CuentaCorrienteException lanza una excepcion en este método
     */
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

    /**
     * TODO: Creamos la opción de hacer el ingreso cuando se haga ese ingreso se cuenta las veces que se ingresa
     * @param cantidadIngresar tipo de variable dentro del parámetro
     * @return devuelve el saldo
     * @throws CuentaCorrienteException lanza una excepcion dentro del método
     */
    public int hacerIngreso(int cantidadIngresar) throws CuentaCorrienteException {
        if (cantidadIngresar <= 0) {
            throw new CuentaCorrienteException("No se puedes ingresar numeros negativos o 0 en su cuenta");

        }
        this.saldo += cantidadIngresar;
        numeroIngreso++;
        return this.saldo;
    }

    /**
     * Muestra el saldo, las veces que retiras el dinero de la cuenta  y las veces que igresas dinero a la cuenta
     */
    public void consultar() {
        System.out.printf("El saldo actual  es de: %d €\n ", getSaldo());

        System.out.printf("Los reintegros realizados es de: %d\n ", getNumeroRetiro());

        System.out.printf("Los Ingresos realizados es de: %d\n", getNumeroIngreso());
    }

}
