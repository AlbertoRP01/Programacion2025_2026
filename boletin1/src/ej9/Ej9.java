package ej9;

import java.util.Scanner;

public class Ej9 {
    static void main() {
        Scanner sc = new Scanner(System.in);
            double precioProducto;
            char tipoDescuento;
                System.out.println("Introduce el precio del producto");
                precioProducto = sc.nextDouble();
                System.out.println("Introduce el tipo de descuento");
                tipoDescuento = sc.next().charAt(0);
                if (tipoDescuento == 'A'){
                  double resultado =   precioProducto * 0.7 /1000;
                    System.out.println("La rebaja es de un 7 % por lo  tanto el precio del producto es de " + resultado );
                } else if (tipoDescuento == 'C') {
                    double resultado = precioProducto * 1.12 /100;
                    System.out.println("La rebaja es de un 12 % por lo tanto el precio del producto es de " + resultado);
                }else{
                    double resultado = precioProducto * 0.9 /100;
                    System.out.println("La rebaja del producto es de 9% por lo tanto el precio del producto es de " +resultado);
                }
            }
        }
