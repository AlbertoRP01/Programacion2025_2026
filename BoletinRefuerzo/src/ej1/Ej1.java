package ej1;

import mientradasalida.MiEntradaSalida;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class Ej1 {
    static void main() {
        int a = MiEntradaSalida.leerEntero("introduce un numero");
        int b = MiEntradaSalida.leerEntero("Introduce otro numero");
        int solucion = a + b;
        System.out.println("La solucion es " + solucion);
    }
}
