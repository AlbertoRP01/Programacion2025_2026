package Ej3.principal;
import Ej3.excepciones.MaquinaException;
import Ej3.maquina.Maquina;
import mientradasalida.MiEntradaSalida;

public class Main {
    static void main(String[] args) {
        Maquina maquina = new Maquina();
        int opcion = 0;
        boolean salir = false;
        do {
           Menu();
           opcion = MiEntradaSalida.leerEntero("Introduce una opcion");
           switch (opcion){
                case 1 -> {
                    try {
                        maquina.servirCafe();
                    }catch (MaquinaException e){
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> {
                    try{
                        maquina.servirLeche();
                    }catch (MaquinaException e){
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    try {
                        maquina.servirCafeLeche();
                    }catch (MaquinaException e ){
                        System.out.println(e.getMessage());
                    }

                }
                case 4 -> {
                    System.out.println(maquina.toString());

                }
                case 5 ->{
                    maquina.LlenarDepositos();
                }
                case 6 ->{
                    String confirmacion = String.valueOf(MiEntradaSalida.solicitarCaracterSN("Quieres salir S/N"));
                    if (confirmacion.equalsIgnoreCase("S")){
                        System.out.println("operacion finalizada, gracias por su compra");
                        salir = true;
                    }else {
                        System.out.println("Operacion cancelada. Volviendo al menú");
                    }
                }
               default -> {
                   System.out.println("Opcion no valida introduce de nuevo  1-6");
               }
           }

        }while (salir);
    }
    public static void Menu(){
        System.out.println("-----------Bienvenido a la máquina de expreso-----------");
        System.out.println("1. Servir café");
        System.out.println("2. Servir leche");
        System.out.println("3. Servir Café leche");
        System.out.println("4. Consultar estado de la maquina");
        System.out.println("5. Llenar depositos");
        System.out.println("6. Apagar máquina y salir");
    }
}
