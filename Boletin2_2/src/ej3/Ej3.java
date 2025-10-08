package ej3;

import mientradasalida.MiEntradaSalida;

public class Ej3 {
    public static final int M = 1000;
    public static final int D = 500;
    public static final int C = 100;
    public static final int L = 50;
    public static final int X = 10;
    public static final int V = 5;
    public static final int I = 1;

    static void main(String[] args) {
        String letra = MiEntradaSalida.leerCadena("Introduce un digito romano");

    }

    private int numeroRomanos(char numero) {
        switch (numero) {
            case 'M':
                return M;
            case 'D':
                return D;
            case 'C':
                return C;
            case 'L':
                return L;
            case 'X':
                return X;
            case 'V':
                return V;
            case 'I':
                return I;
        }
        return 0;
    }
}
