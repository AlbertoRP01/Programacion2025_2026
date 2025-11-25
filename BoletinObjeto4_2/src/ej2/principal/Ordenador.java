package ej2.principal;

import ej1.excepciones.PlacaBaseException;
import ej2.clases.DiscoDuro;
import ej2.clases.Microprocesador;
import ej2.clases.PlacaBase;
import ej2.clases.TarjetaGrafica;

public class Ordenador {
    static void main(String[] args) {
        PlacaBase placaBase = new PlacaBase("MSI", "Intel® Z370 Chipset", "LGA1151");
        Microprocesador microprocesador = new Microprocesador("Intel", "i7-10700K", 8, 3.803F, "LGA1200");
        DiscoDuro discoDuro = new DiscoDuro("Samsung", "SSD", 2000);
        TarjetaGrafica tarjetaGrafica = new TarjetaGrafica("AMD", "6700xt", 12, 16, 40);
        // con excepcion
        try {
            placaBase.compatible2(microprocesador);
            System.out.println(placaBase.toString());
            System.out.println();
            System.out.println(microprocesador.toString());
            System.out.println();
            System.out.println(discoDuro.toString());
            System.out.println();
            System.out.println(tarjetaGrafica.toString());
        }catch (
                PlacaBaseException e){
            System.out.println(e.getMessage());
        }
    }
}
