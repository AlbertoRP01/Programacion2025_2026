package ej6;

import mientradasalida.MiEntradaSalida;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.Properties;

public class Ej6 {
  public   static void main() {
        PropertiesReader pop;
        try {
            pop = PropertiesReader.getInstance();
            String nombreEmpleado = MiEntradaSalida.solicitarCadena("Introduce el nombre del emleado");
            String url = "jdbc:mysql://localhost:3306/classicmodels?serverTimezone=UTC";
            String usuario = "classicmodelsUser";
            String password = "root";
            Properties properties = new Properties();
            Path ruta = Path.of("config.properties");

            if (!Files.exists(ruta)) {
                throw new Exception("Error: El archivo config.properties no se encuentra en la ruta: ");
            }
            String sql = """
                SELECT e.employeeNumber, e.firstName, e.lastName,
                       c.customerName,
                       p.amount
                FROM employees e
                JOIN customers c ON e.employeeNumber = c.salesRepEmployeeNumber
                JOIN payments p ON c.customerNumber = p.customerNumber
                WHERE CONCAT(e.firstName, ' ', e.lastName) = ?
            """;
            try(Connection conexion = DriverManager.getConnection(url, usuario, password);
                PreparedStatement pstmt= conexion.prepareStatement(sql)) {
                pstmt.setString(1, nombreEmpleado);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()){
                   int numeroEmpleado = rs.getInt("employeeNumber");
                   String firstName = rs.getString("firstName");
                   String lastName = rs.getString("lastName");
                   String customerName = rs.getString("customerName");
                   double amount = rs.getDouble("amount");
                    System.out.printf(
                            "numeroEmpleado: %d | apellido1: %s | apellido2: %s | Cliente: %s | importe: %.2f€%n",
                            numeroEmpleado, firstName, lastName, customerName, amount
                    );
                }
            }catch (SQLException e){
                System.err.println("Error durante la operación con la base de datos ");

                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
