package ej1;

public class Ej1 {
    static void main() {
        for (int i = 1 ; i < 100; i ++){
            if (i % 7 == 0 && i % 13 == 0){
                System.out.println(i + " Es multiplo de 7 y de 13 ");
            } else if (i % 7 == 0) {
                System.out.println(i + " Es multiplo de 7 ");
            } else if (i % 13 == 0) {
                System.out.println(i + " Es multiplo de 13");
            }else {
                System.out.println(i + " No es multiplo de 7 y  de 13 ");
            }
        }
    }
}
