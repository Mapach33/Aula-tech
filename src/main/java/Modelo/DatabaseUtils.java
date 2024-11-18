package Modelo;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    public static String verifyLogin(String usuario, String password) {
        String query = "SELECT * FROM Usuarios WHERE username = ? AND contraseña = ?";
        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query); 
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return resultSet.getString("tipo");
            }
        } catch (SQLException ex) {
            System.out.println("Error al verificar el login: " + ex.getMessage());
        }
        return null;
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

    //para extraer alumnos
    public static List<Map<String, String>> buscarAlumnos(String apellido, String nombre, String grado) {
        StringBuilder query = new StringBuilder("SELECT u.apellido, u.nombre, s.grado, s.seccion " +
                "FROM Usuarios u " +
                "JOIN Alumnos a ON u.usuario_id = a.alumno_id " +
                "JOIN Salones s ON a.salon_id = s.salon_id " +
                "WHERE u.tipo = 'alumno'");

        if (apellido != null && !apellido.isEmpty()) {
            query.append(" AND u.apellido LIKE ?");
        }
        if (nombre != null && !nombre.isEmpty()) {
            query.append(" AND u.nombre LIKE ?");
        }
        if (grado != null && !grado.isEmpty()) {
            query.append(" AND s.grado = ?");
        }

        List<Map<String, String>> results = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query.toString())) {

            int paramIndex = 1;
            if (apellido != null && !apellido.isEmpty()) {
                preparedStatement.setString(paramIndex++, "%" + apellido + "%");
            }
            if (nombre != null && !nombre.isEmpty()) {
                preparedStatement.setString(paramIndex++, "%" + nombre + "%");
            }
            if (grado != null && !grado.isEmpty()) {
                preparedStatement.setString(paramIndex++, grado);
            }

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Map<String, String> row = new HashMap<>();
                    row.put("apellido", resultSet.getString("apellido"));
                    row.put("nombre", resultSet.getString("nombre"));
                    row.put("grado", resultSet.getString("grado"));
                    row.put("seccion", resultSet.getString("seccion"));
                    results.add(row);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar alumnos: " + ex.getMessage());
        }
        return results;
    }

    // para extraer profesores
    public static List<Map<String, String>> buscarProfesores(String nombre, String curso, String tipo) {
        StringBuilder query = new StringBuilder("SELECT u.apellido, u.nombre, c.nombre AS curso, p.tipo " +
                "FROM Usuarios u " +
                "JOIN Profesores p ON u.usuario_id = p.profesor_id " +
                "JOIN Cursos c ON p.curso_id = c.curso_id " +
                "WHERE u.tipo = 'profesor'");

        if (tipo != null && !tipo.isEmpty()) {
            query.append(" AND p.tipo LIKE ?");
        }
        if (nombre != null && !nombre.isEmpty()) {
            query.append(" AND u.nombre LIKE ?");
        }
        if (curso != null && !curso.isEmpty()) {
            query.append(" AND c.nombre LIKE ?");
        }

        List<Map<String, String>> results = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query.toString())) {

            int paramIndex = 1;
            if (tipo != null && !tipo.isEmpty()) {
                preparedStatement.setString(paramIndex++, "%" + tipo + "%");
            }
            if (nombre != null && !nombre.isEmpty()) {
                preparedStatement.setString(paramIndex++, "%" + nombre + "%");
            }
            if (curso != null && !curso.isEmpty()) {
                preparedStatement.setString(paramIndex++, "%" + curso + "%");
            }

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Map<String, String> row = new HashMap<>();
                    row.put("apellido", resultSet.getString("apellido"));
                    row.put("nombre", resultSet.getString("nombre"));
                    row.put("curso", resultSet.getString("curso"));
                    row.put("tipo", resultSet.getString("tipo"));
                    results.add(row);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar profesores: " + ex.getMessage());
        }
        return results;
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




