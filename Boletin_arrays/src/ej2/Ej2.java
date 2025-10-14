package ej2;

public class Ej2 {
    static void main(String[] args) {
        int[] numeros = {7, -3, 234, 56, 7, 2, -4, 62, 78, -225};
        int contarNegativos = 0;
        for (int numero : numeros) {
            if (numero < 0) {
                contarNegativos++;
                System.out.println("El numero " + numero + " Negativo");
            } else {
                System.out.println("El numero " + numero + " Es positivo");
            }
        }
        System.out.println("La cantidad de negativos es de " + contarNegativos);
    }
}
