package Modelo.dao;
import Modelo.entities.Comunicado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static Modelo.DatabaseUtils.getConnection;

public class ComunicadoDAO {

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

    public static List<Comunicado> obtenerComunicados() {
        String query = "SELECT * FROM Comunicados";
        List<Comunicado> comunicados = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Comunicado comunicado = new Comunicado();
                comunicado.setCominacado_id(resultSet.getInt("comunicado_id"));
                comunicado.setTitulo(resultSet.getString("titulo"));
                comunicado.setContenido(resultSet.getString("contenido"));
                comunicado.setFecha(resultSet.getString("fecha_publicacion"));
                comunicado.setEmisor(resultSet.getString("emisor"));
                comunicados.add(comunicado);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener comunicados: " + ex.getMessage());
        }
        return comunicados;
    }

}
