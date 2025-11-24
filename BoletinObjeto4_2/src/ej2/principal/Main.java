package ej2.principal;

import ej2.clases.DiscoDuro;
import ej2.clases.Microprocesador;
import ej2.clases.PlacaBase;
import ej2.clases.TarjetaGrafica;

public class Main {
    static void main(String[] args) {
        PlacaBase placaBase = new PlacaBase("", "", "");
        Microprocesador  microprocesador = new Microprocesador("", "", 8, 3000, "");
        DiscoDuro discoDuro = new DiscoDuro("", "", 2000);
        TarjetaGrafica tarjetaGrafica = new TarjetaGrafica("", "", 18, 7000, 12);


    }

}
