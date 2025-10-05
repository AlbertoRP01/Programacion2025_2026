package ej9;

public class Ej9 {
   public static void main(String[] args) {
        for (int i = 0; i  <= 10; i ++){
            System.out.println("Tabla del " + i);
            for (int j = 0 ; j <= 10;  j ++){
                 int operacion  = (i *j);
                System.out.println(i +  " x " + j + " = " + operacion );
            }
        }
    }
}
