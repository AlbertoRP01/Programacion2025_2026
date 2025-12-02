package ej7.principal;

import ej7.clase.Jarra;
import mientradasalida.MiEntradaSalida;


public class Main {
    static void main(String[] args) {
        int capA = MiEntradaSalida.leerEnteroPositivo("Introduzca la capacidad de la JarraA");
        int capB = MiEntradaSalida.leerEnteroPositivo("Introduzca la capacidad de la JarraB");
        Jarra jarraA = new Jarra(capA);
        Jarra jarraB = new Jarra(capB);
        boolean salir = false;
        int opcion = 0;
         do {
             menu();
             opcion = MiEntradaSalida.leerEnteroPositivo("Elige una opcion");
            switch (opcion){
                case 1 -> {
                    String jarraAlLlenar = MiEntradaSalida.solicitarCadena("¿Que jarra desea llenar?");
                   if (jarraAlLlenar.equalsIgnoreCase("a")){
                       jarraA.llenarJarra();
                   } else if (jarraAlLlenar.equalsIgnoreCase("b")) {
                       jarraB.llenarJarra();
                   }else {
                       System.out.println("Opcion de jarra no valida");
                   }

                }
                case 2 -> {
                    String jarraAlVaciar = MiEntradaSalida.solicitarCadena("¿Que jarra quieres vaciar?");
                    if (jarraAlVaciar.equalsIgnoreCase("a")){
                        jarraA.vaciarJarra();
                    } else if (jarraAlVaciar.equalsIgnoreCase("b")) {
                        jarraB.vaciarJarra();
                    }else {
                        System.out.println("Opcion no válida");
                    }
                }
                case 3 ->{
                    jarraA.volcarJarra(jarraB);
                }
                case 4 ->{
                    jarraB.volcarJarra(jarraA);
                }
                case  5-> {
                    System.out.println("Estado de las Jarras");
                    System.out.println("Jarra A" + jarraA.toString());
                    System.out.println("Jarra B"+ jarraB.toString());

                }
                case 6-> {
                    System.out.println("Hasta la proxima");
                    salir = true;
                }
                default -> {
                    System.out.println("No es una opcion correcta. Vuelve a introducir  1-6");
                }
            }
         }while (!salir);
        System.out.println(Jarra.getTotalAguaConsumida());
    }
    public static void menu(){
        System.out.println("----------Bienvenido al juego de la Jarra----------");
        System.out.println("1.Llenar jarra");
        System.out.println("2.Vaciar jarra");
        System.out.println("3.volcar jarra A en B");
        System.out.println("4.Volcar jarra B en A");
        System.out.println("5.ver estado de las jarras");
        System.out.println("6.Salir");
    }

}
