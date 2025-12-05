package ej1;

public class Cadena {
    private String cadena;
    Character caracter;

    public Cadena(Character caracter, String cadena) {
        this.caracter = caracter;
        this.cadena = cadena;
    }

    public String getCadena() {
        return cadena;
    }

    public Character getCaracter() {
        return caracter;
    }

    public int caracter() {
        String cadenaMinuscula = cadena.toLowerCase();
        char caracterMinuscula = Character.toLowerCase(caracter);

        int contador = 0; // Inicializamos el contador

        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == caracter) {
                contador++;
            }
        }
        return contador;

    }
}
