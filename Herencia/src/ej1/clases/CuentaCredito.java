package ej1.clases;

import ej1.exceptiones.CuentaException;

public class CuentaCredito extends Cuenta{
    private static final double SALDO_INICIAL = 0;
    private static final double CREDITO_POR_DEFECTO = 100;
    private static final double CREDITO_MAX = 300;
    private final double CREDITO_INICIAL;
    private double credito;

    public CuentaCredito(double saldoInicial, double credito) throws CuentaException {
        super(saldoInicial);
        CREDITO_INICIAL = credito;
        setCredito(CREDITO_INICIAL);
    }

    public CuentaCredito(double saldoInicial) throws CuentaException {
        super(saldoInicial);
        this.credito = CREDITO_POR_DEFECTO;
        CREDITO_INICIAL = CREDITO_POR_DEFECTO;
    }

    public CuentaCredito() throws CuentaException {
        super(SALDO_INICIAL);
        this.credito = CREDITO_POR_DEFECTO;
        CREDITO_INICIAL = CREDITO_POR_DEFECTO;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) throws CuentaException {
        if (credito > CREDITO_MAX ) {
            throw new CuentaException("Crédito máximo excedido");
        }
        this.credito = credito;
    }

    @Override
    public void reintegro(double dineroASacar) throws CuentaException {
        if (dineroASacar <= 0){
            throw new CuentaException("Introduzca una cantidad positiva");
        }
        if (getSaldo()+credito<dineroASacar){
            throw new CuentaException("No tienes fondos suficientes");
        }
        if (dineroASacar > getSaldo()){
            double cantidadRestante = dineroASacar - getSaldo();
            super.reintegro(getSaldo());
            credito -= cantidadRestante;
        }
        else super.reintegro(dineroASacar);

    }

    @Override
    public void ingreso(double dineroAIngresar) throws CuentaException {
        if (dineroAIngresar < 0){
            throw new CuentaException("No puedes ingresar cantidades negativas");
        }
        if (credito < CREDITO_INICIAL){
            double dineroDeCredito = CREDITO_INICIAL - credito;
        }
    }
}