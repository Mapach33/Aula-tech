package Modelo;
import java.sql.*;


public class DatabaseUtils {
    private static final String URL = "jdbc:mysql://root:sOPFgGLQYUcSwemsWaIovRCoiiDdMvpd@junction.proxy.rlwy.net:24182/aula_tech";
    private static final String USER = "root";
    private static final String PASSWORD = "sOPFgGLQYUcSwemsWaIovRCoiiDdMvpd";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            System.out.println("Error al conectar a la base de datos: " + ex.getMessage());
        }
        return connection;
    }

    public static boolean verifyLogin(String usuario, String password) {
        String query = "SELECT * FROM Usuarios WHERE username = ? AND contraseña = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
           if (resultSet.next()){
               return true;
           } else {
               return false;
           }
        } catch (SQLException ex) {
            System.out.println("Error al verificar el login: " + ex.getMessage());
        }
        return false;
    }
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexión: " + ex.getMessage());
        }
    }
}
//    public static void main(String[] args) {
//        // Test the connection
//        Connection connection = DatabaseUtils.getConnection();
//    }



