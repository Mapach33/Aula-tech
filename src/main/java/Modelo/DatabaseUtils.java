package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseUtils {
    private static final String URL = "jdbc:mysql://root:xtaELGOEinOzRrWRNdkUDyJjGuWaWWqp@junction.proxy.rlwy.net:32950/railway";
    private static final String USER = "root";
    private static final String PASSWORD = "xtaELGOEinOzRrWRNdkUDyJjGuWaWWqp";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            System.out.println("Error al conectar a la base de datos: " + ex.getMessage());
        }
        return connection;
    }
}
//    public static void closeConnection(Connection connection) {
//        try {
//            if (connection != null) {
//                connection.close();
//            }
//        } catch (SQLException ex) {
//            System.out.println("Error al cerrar la conexión: " + ex.getMessage());
//        }
//    }
//}
