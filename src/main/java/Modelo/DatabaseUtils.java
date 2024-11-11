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
        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query); 
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException ex) {
            System.out.println("Error al verificar el login: " + ex.getMessage());
        }
        return false;
    }

    public static ResultSet notasBuscar(String salon, String bimestre, String curso) {
        String query = "SELECT u.nombre AS nombre, u.apellido AS apellido, n.nota_mensual AS nota_mensual, " +
                "n.nota_bimestral AS nota_bimestral, n.promedio AS promedio " +
                "FROM Alumnos a " +
                "JOIN Usuarios u ON a.alumno_id = u.usuario_id " +
                "JOIN Notas n ON a.alumno_id = n.alumno_id " +
                "JOIN Salones s ON a.salon_id = s.salon_id " +
                "JOIN Bimestres b ON n.bimestre_id = b.ciclo_id " +
                "JOIN Cursos c ON n.curso_id = c.curso_id " +
                "WHERE s.nombre = ? AND c.nombre = ? AND b.bimestre = ?";

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, salon);
            preparedStatement.setString(2, curso);
            preparedStatement.setInt(3, Integer.parseInt(bimestre));
            return preparedStatement.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la consulta: " + ex.getMessage());
        }
        return null;
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
    
//    public static ResultSet notasBuscar(String salon, String bimestre, String curso){
//        //
//    }
}
//    public static void main(String[] args) {
//        // Test the connection
//        Connection connection = DatabaseUtils.getConnection();
//    }



