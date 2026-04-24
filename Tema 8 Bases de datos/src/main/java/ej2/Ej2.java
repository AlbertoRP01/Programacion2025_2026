package ej2;

import mientradasalida.MiEntradaSalida;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.Properties;

public class Ej2 {
    static void main(String[] args) throws Exception {
        PropertiesReader pop;
        try {
            pop = PropertiesReader.getInstance();
            double precio = MiEntradaSalida.solicitarDouble("Introduce el precio maximo");
            String url = "jdbc:mysql://localhost:3306/classicmodels?serverTimezone=UTC";
            String usuario = "classicmodelsUser";
            String password = "root";

            Properties properties = new Properties();
            Path ruta = Path.of("Config.properties");
            if (!Files.exists(ruta)) {
                throw new Exception("Error: El archivo config.properties no se encuentra en la ruta: " + ruta.toString() + ruta.toAbsolutePath());
            }
            String sql  = "SELECT productCode, productName, buyPrice FROM products WHERE buyPrice <? order by buyPrice";

            try (Connection conexion = DriverManager.getConnection(url, usuario, password);
                 PreparedStatement pstmt = conexion.prepareStatement(sql)) {
                pstmt.setInt(1, (int) precio);
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()){
                    String codigo = rs.getString("productCode");
                    String nombre = rs.getString("productName");
                    double precio1 = rs.getDouble("buyPrice");
                    System.out.printf("- codigo: %s, Nombre: %s, Precio: %.2f%n",
                            codigo, nombre, precio1);
                }

                System.out.println("Resultado con prepareStatement");
            } catch (SQLException e){
                System.err.println("Error durante la operación con la base de datos ");
                e.printStackTrace();
            }

        }catch (Exception e ){
            e.printStackTrace();
        }
    }
}
