package Ej3.maquina;

import Ej3.excepciones.MaquinaException;
import mientradasalida.MiEntradaSalida;

import java.lang.classfile.constantpool.InterfaceMethodRefEntry;

public class Maquina {
    // Constantes
    public final int MAX_CAFE = 50;
    public final int MAX_LECHE = 50;
    public final int MAX_VASO = 80;
    public final double PRECIO_CAFE = 1;
    public final double PRECIO_LECHE = 0.8;
    public final double PRECIO_CAFE_LECHE = 1.5;

    //Atributos
    private int dosisCafe;
    private int dosisLeche;
    private int vaso;
    private double monedero;

    //Constructor
    public Maquina() {
        this.dosisCafe = MAX_CAFE;
        this.dosisLeche = MAX_LECHE;
        this.vaso = MAX_VASO;
    }

    public Maquina(double monederoInicial) {
        monedero = Math.max(1.50, monederoInicial);
    }

    public int getDosisCafe() {
        return dosisCafe;
    }

    public int getDosisLeche() {
        return dosisLeche;
    }

    public int getVaso() {
        return vaso;
    }

    public double getMonedero() {
        return monedero;
    }

    /**
     * En el caso de que introduzca la cantidad inicial en el monederos lanzara una excepcion cuando sea 0
     *
     * @param monedero
     * @throws MaquinaException
     */
    public void setMonedero(double monedero) throws MaquinaException {
        if (monedero < 0) {
            throw new MaquinaException("La maquina no puede contener numeros negativos");
        }
        this.monedero = monedero;
    }

    /**
     * Implemeta en este metodo pedimos nuestro cafe y en el caso de que nos pasemos de cantidad  nos da la vuelta
     *
     * @throws MaquinaException
     */
    public void servirCafe() throws MaquinaException {
        double cambio = 0;
        double importe = MiEntradaSalida.leerDecimales("Introduce el importe del cafe");
        if (importe < PRECIO_CAFE) {
            throw new MaquinaException("El importe debe ser: " + PRECIO_CAFE);
        }
        if (importe > PRECIO_CAFE) {
            cambio = monedero - importe;
            if (monedero < cambio) {
                throw new MaquinaException("No puede devolver el cambio no hay  monedas en el monedero");
            }
            monedero += PRECIO_CAFE;
            monedero -= cambio;
            System.out.printf("cambio devuelto: %.2f" + cambio + "€");
            System.out.println("Disfrute de su cafe");
        } else {
            monedero += PRECIO_CAFE;
            System.out.printf("Disfrute de su cafe");
        }
        dosisCafe--;
        vaso--;

    }
    /**
     * Implemeta en este metodo pedimos nuestro cafe y en el caso de que nos pasemos de cantidad  nos da la vuelta
     *
     * @throws MaquinaException
     */
    public void servirLeche() throws MaquinaException {
        double cambio = 0;
        double importe = MiEntradaSalida.leerDecimales("Introduce el importe de su leche");
        if (importe < PRECIO_LECHE) {
            throw new MaquinaException("El importe debe ser: " + PRECIO_LECHE);
        }
        if (importe > PRECIO_LECHE) {
            cambio = monedero - importe;
            if (monedero < cambio) {
                throw new MaquinaException("No puede devolver el cambio no hay  monedas en el monedero");
            }
            monedero += PRECIO_LECHE;
            monedero -= cambio;
            System.out.printf("cambio devuelto: %.2f" + cambio + "€");
            System.out.println("disfrute de su leche ");
        } else {
            monedero += PRECIO_LECHE;
            System.out.printf("Disfrute de su leche");
        }
        dosisLeche--;
        vaso--;

    }
    /**
     * Implemeta en este metodo pedimos nuestro cafe y en el caso de que nos pasemos de cantidad  nos da la vuelta
     *
     * @throws MaquinaException
     */
    public void servirCafeLeche() throws MaquinaException {
        double cambio = 0;
        double importe = MiEntradaSalida.leerDecimales("Introduce el importe del cafe con leche");
        if (importe < PRECIO_CAFE_LECHE) {
            throw new MaquinaException("El importe debe ser: " + PRECIO_CAFE_LECHE);
        }

        if (importe > PRECIO_CAFE_LECHE) {
            cambio = monedero - importe;
            if (monedero < cambio) {
                throw new MaquinaException("No puede devolver el cambio no hay  monedas en el monedero");
            }
            monedero += PRECIO_CAFE_LECHE;
            monedero -= cambio;
            System.out.printf("cambio devuelto: %.2f" + cambio + "€");
            System.out.printf("Disfrute de su cafe con leche");
        } else {
            monedero += PRECIO_CAFE_LECHE;
            System.out.printf("Disfrute de su cafe con leche");
        }
        dosisCafe--;
        dosisLeche--;
        vaso--;

    }

    public void LlenarDepositos(){

    }

    @Override
    public String toString() {
        return "Maquina{" +
                String.format("deposito de cafe: %d\n" + dosisCafe) +
                String.format(", deposito de leche: %d\n" + dosisLeche) +
                String.format(", deposito de vaso:%d\n" + vaso) +
                String.format(", monedero actual de la maquina: %.2f\n" + monedero) +
                '}';
    }
}
