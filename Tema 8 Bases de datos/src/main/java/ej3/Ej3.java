package ej3;

import mientradasalida.MiEntradaSalida;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.Properties;

public class Ej3 {
    static void main(String[] args) {
        PropertiesReader pop;
        try {
            pop = PropertiesReader.getInstance();

            double precio = MiEntradaSalida.solicitarDouble("Introduce el precio");
            char letra = MiEntradaSalida.solicitarCaracter("Introduce la letra ");
            String patron = letra + "%";
            String url = "jdbc:mysql://localhost:3306/classicmodels?serverTimezone=UTC";
            String usuario = "classicmodelsUser";
            String password = "root";
            Properties properties = new Properties();
            Path ruta = Path.of("Config.properties");
            if (!Files.exists(ruta)) {
                throw new Exception("Error: El archivo config.properties no se encuentra en la ruta: " + ruta.toString() + ruta.toAbsolutePath());

            }
            String sql = "SELECT productCode, productName, buyPrice FROM products where buyPrice <? AND productName LIKE ? ORDER BY buyPrice ";
            try (Connection connection = DriverManager.getConnection(url, usuario, password);
                 PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setDouble(1, precio);
                pstmt.setString(2, patron);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    String codigo = rs.getString("productCode");
                    String nombre = rs.getString("productName");
                    double price = rs.getDouble("buyPrice");
                    System.out.printf("Código: %s | Nombre: %s | Precio: %.2f€%n",
                            codigo, nombre, price);
                }
            } catch (SQLException e) {
                System.err.println("Error durante la operación con la base de datos ");
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
