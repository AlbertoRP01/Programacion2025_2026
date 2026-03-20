package ej3;

import java.io.*;

public class Ej3Io {
    static void main(String[] args) {
        File f = new File("./src/ej3/salidaEj3.txt");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter  pw  = new PrintWriter(new FileWriter(f, true))){
            String linea;
            while((linea = br.readLine())!=null && !linea.equalsIgnoreCase("fin")) {
                //pw.println(linea);
                pw.write(linea);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
