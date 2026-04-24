package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.Properties;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TestConetion {
    static void main() throws Exception {

        String url = "jdbc:mysql://localhost:3306/classicmodels?serverTimezone=UTC";
        String usuario = "classicmodelsUser";
        String password = "root";
        Properties properties = new Properties();
        Path ruta = Path.of("Config.properties");
        if (!Files.exists(ruta)) {
            throw new Exception("Error: El archivo config.properties no se encuentra en la ruta: " + ruta.toString() + ruta.toAbsolutePath());
        }
        String sql = "SELECT productCode, productName, buyPrice FROM products WHERE productLine = ? ORDER BY productName";
        String prodductLinesBuscada = "planes";
        System.out.println("Buscando productos de la linea:" + prodductLinesBuscada);
        try (Connection conexion = DriverManager.getConnection(url, usuario, password);
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, prodductLinesBuscada);
            System.out.println("¡conexión establecida con éxito! (se cerrará automáticamente) ");
            try (ResultSet rs = pstmt.executeQuery()) {
                boolean encontrado = false;
                while (rs.next()) {
                    encontrado = true;
                    String codigo = rs.getString("productCode");
                    String nombre = rs.getString("productname");
                    double precio = rs.getDouble("buyPrice");
                    System.out.printf("- codigo: %s, Nombre: %s, Precio: %.2f%n",
                            codigo, nombre, precio);
                }
                if (!encontrado) {
                    System.out.println("No se ha encontrado productos para esa categoria");

                }
            }
        } catch (SQLException e) {
            System.err.println("Error durante la operación con la base de datos ");
            e.printStackTrace();
        }
    }
}
