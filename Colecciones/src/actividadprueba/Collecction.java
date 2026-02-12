package actividadprueba;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

public class Collecction {
    static void main(String[] args) {
        Collection<String> lista = new ArrayList<>();
        lista.add("juan");
        lista.add("Paco");
        lista.add("Carlos");
        for (String n : lista) {
            System.out.println(n);
        }
        if (lista.contains("juan")){
            System.out.println("si, pero lo borro");
            lista.remove("juan");
        }else {
            System.out.println("No, lo contiene");
        }
    }
}
