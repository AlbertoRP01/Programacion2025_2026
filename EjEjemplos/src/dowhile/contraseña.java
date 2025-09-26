package dowhile;

import java.util.Scanner;

public class contraseña {
    static void main() {
        Scanner sc = new Scanner(System.in);
        String contrasena;

        do {
            System.out.println("Introduce una contraseña como minimo 8 caracteres");
            contrasena = sc.nextLine();
        }while (contrasena.length() < 8);
        System.out.println("Has iniciado sesion");
    }
}
