package ej6.domain;

import ej6.excepciones.SupermercadoException;
import ej6.model.Almacen;
import mientradasalida.MiEntradaSalida;
import mientradasalida.MiEntradaSalidaException;

public class Main {
    static void main(String[] args) {
        Almacen almacen = new Almacen();
        int opcion = 0;
        System.out.println("==========================================");
        System.out.println("Bienvenido al supermercad de confianza");
        System.out.println("==========================================");
        do {
            try {
                menu();
                 opcion = MiEntradaSalida.leeEnteroRango("¿Que quieres hacer?", 1, 5);
                switch (opcion) {
                    case 1 -> {
                        almacen.abrirCaja();
                    }
                    case 2 -> {
                        almacen.cerrarCaja();
                    }
                    case 3 -> {
                        almacen.nuevoCliente();
                    }
                    case 4 -> {
                        almacen.atenderCliente();
                    }
                    case 5 -> {
                        break;
                    }
                }


            } catch (MiEntradaSalidaException | SupermercadoException e){
                System.out.println(e.getMessage());
            }
        }while (opcion != 5) ;
    }
        public static void menu () {
            System.out.println("Elige una de estas opciones: ");
            System.out.println("1. Abrir caja");
            System.out.println("2. Cerrar caja");
            System.out.println("3. Nuevo cliente");
            System.out.println("4. Atender cliente");
            System.out.println("5. Salir");
        }
    }
