package Modelo;
import java.sql.*;
import java.util.*;
import java.util.Date;


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
        StringBuilder query = new StringBuilder("SELECT u.usuario_id, u.apellido, u.nombre, s.grado, s.seccion " +
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
                    row.put("id", resultSet.getString("usuario_id"));
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

    public static void eliminarAlumnoPorId(String id) {
        String query = "DELETE FROM Usuarios WHERE usuario_id = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar alumno: " + ex.getMessage());
        }
    }

    public static void eliminarProfesorPorId(String id){
        String query = "DELETE FROM Usuarios WHERE usuario_id = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex){
            System.out.println("Error al eliminar profesor: " + ex.getMessage());
        }
    }

    // para extraer profesores
    public static List<Map<String, String>> buscarProfesores(String apellido, String nombre, String curso) {
        StringBuilder query = new StringBuilder("SELECT u.usuario_id, u.apellido, u.nombre, c.nombre AS curso, p.tipo " +
                "FROM Usuarios u " +
                "JOIN Profesores p ON u.usuario_id = p.profesor_id " +
                "JOIN Cursos c ON p.curso_id = c.curso_id " +
                "WHERE u.tipo = 'profesor'");

        if (apellido != null && !apellido.isEmpty()) {
            query.append(" AND u.apellido LIKE ?");
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
            if (apellido != null && !apellido.isEmpty()) {
                preparedStatement.setString(paramIndex++, "%" + apellido + "%");
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
                    row.put("id", resultSet.getString("usuario_id"));
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

    public static List<Map<String, String>> obtenerComunicados() {
        String query = "SELECT * FROM Comunicados";
        List<Map<String, String>> comunicados = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Map<String, String> comunicado = new HashMap<>();
                comunicado.put("id", resultSet.getString("comunicado_id"));
                comunicado.put("asunto", resultSet.getString("titulo"));
                comunicado.put("contenido", resultSet.getString("contenido"));
                comunicado.put("fecha", resultSet.getString("fecha_publicacion"));
                comunicado.put("emisor", resultSet.getString("emisor"));
                comunicados.add(comunicado);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener comunicados: " + ex.getMessage());
        }
        return comunicados;
    }

    //insertar en la tabla de usuarios un alumno con los siguientes datos DNI, nombre apellido y correo
    public static Boolean insertarAlumno(String dni, String nombre, String apellido, String correo) {
        String query = "INSERT INTO Usuarios (dni, nombre, apellido, email, tipo) VALUES (?, ?, ?, ?, 'alumno')";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, dni);
            preparedStatement.setString(2, nombre);
            preparedStatement.setString(3, apellido);
            preparedStatement.setString(4, correo);
            preparedStatement.executeUpdate();

            connection.commit();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al insertar alumno: " + ex.getMessage());
            return false;
        }
    }

    //Insertar en la tabla de usuarios un profesor con los siguientes datos DNI, nombre, apellido y correo
    public static Boolean insertarProfesor(String dni, String nombre, String apellido, String correo, String tipo) {
        String queryUsuario = "INSERT INTO Usuarios (dni, nombre, apellido, email, tipo) VALUES (?, ?, ?, ?, 'profesor')";
        String queryProfesor = "INSERT INTO Profesores (profesor_id, tipo, curso_id) VALUES (?, ?, ?)";
        Random random = new Random();
        int cursoId = random.nextInt(9) + 1; // Generates a random number between 1 and 9

        try (Connection connection = getConnection();
             PreparedStatement preparedStatementUsuario = connection.prepareStatement(queryUsuario, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement preparedStatementProfesor = connection.prepareStatement(queryProfesor)) {
            connection.setAutoCommit(false);

            // Insert into Usuarios table
            preparedStatementUsuario.setString(1, dni);
            preparedStatementUsuario.setString(2, nombre);
            preparedStatementUsuario.setString(3, apellido);
            preparedStatementUsuario.setString(4, correo);
            preparedStatementUsuario.executeUpdate();

            // Get the generated professor_id
            ResultSet generatedKeys = preparedStatementUsuario.getGeneratedKeys();
            if (generatedKeys.next()) {
                int profesorId = generatedKeys.getInt(1);

                // Insert into Profesores table
                preparedStatementProfesor.setInt(1, profesorId);
                preparedStatementProfesor.setString(2, tipo);
                preparedStatementProfesor.setInt(3, cursoId);
                preparedStatementProfesor.executeUpdate();
            }

            connection.commit();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al insertar profesor: " + ex.getMessage());
            return false;
        }
    }

    public static Boolean redactarComunicado(String titulo, String contenido) {
        String query = "INSERT INTO Comunicados (titulo, contenido, fecha_publicacion, emisor) VALUES (?, ?, ?, 'admin')";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, titulo);
            preparedStatement.setString(2, contenido);
            preparedStatement.setDate(3, new java.sql.Date(System.currentTimeMillis()));
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al redactar comunicado: " + ex.getMessage());
            return false;
        }
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




