package ej5;

import mientradasalida.MiEntradaSalida;

import javax.sound.midi.MidiChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.Properties;

public class Ej5 {
    static void main(String[] args) {
        PropertiesReader pop;
        try {
            pop = PropertiesReader.getInstance();
            String nombreProducto = MiEntradaSalida.solicitarCadena("Introduce el nombre del producto");
            String url = "jdbc:mysql://localhost:3306/classicmodels?serverTimezone=UTC";
            String usuario = "classicmodelsUser";
            String password = "root";
            Properties properties = new Properties();
            Path ruta = Path.of("config.properties");

            if (!Files.exists(ruta)) {
                throw new Exception("Error: El archivo config.properties no se encuentra en la ruta: ");
            }
            String sql = "SELECT productCode, productName,  BuyPrice, productVendor FROM products where productName = ?  ";
            try (Connection conexion = DriverManager.getConnection(url, usuario, password);
                 PreparedStatement pstmt = conexion.prepareStatement(sql)) {
                pstmt.setString(1, nombreProducto);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    String code = rs.getString("productCode");
                    String nombre = rs.getString("productName");
                    double precio = rs.getDouble("buyPrice");
                    String proveedor = rs.getString("productVendor");
                    System.out.printf("Código: %s | Nombre: %s | Precio: %.2f€ | Proveedor: %s%n",
                            code, nombre, precio, proveedor);
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
