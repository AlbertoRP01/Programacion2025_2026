package ej6.principal;

import ej6.clases.Producto;
import ej6.excepciones.ProductoException;
import mientradasalida.MiEntradaSalida;

import java.util.function.Predicate;

public class Main {
    static void main(String[] args) {
        System.out.println("----------Bienvenido al supermecados Riv----------");
        Producto producto2 = crearProducto();
        Producto producto =  crearProducto();
        System.out.println("----------Aqui tienes el ticket de sus productos----------");
        System.out.println(producto2.toString());
        System.out.println( producto.toString());

    }
    public static Producto crearProducto(){
        Producto producto = new Producto();
        String descripcion = MiEntradaSalida.solicitarCadena("Introduce la descripcion del producto");
        double precio;
        boolean validarEntrada = false  ;
        do {
            precio = MiEntradaSalida.solicitarDouble("Introduce el precio del producto");
            try {
                producto.setPrecio(precio);
                validarEntrada = true;
            } catch (ProductoException e) {
                System.out.println(e.getMessage());
            }
        }while (!validarEntrada);
        return  new Producto(descripcion, precio);
    }
}
