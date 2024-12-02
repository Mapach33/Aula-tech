package Modelo.dao;

import Modelo.entities.Pago;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static Modelo.DatabaseUtils.getConnection;

public class PagoDAO {

    public static Pago buscarPagosPorDni(String dni) {
        String query = "SELECT CONCAT(u.nombre, ' ', u.apellido) AS nombre, u.dni, " +
                "MAX(CASE WHEN p.mes = 'enero' THEN p.estado END) AS enero, " +
                "MAX(CASE WHEN p.mes = 'febrero' THEN p.estado END) AS febrero, " +
                "MAX(CASE WHEN p.mes = 'marzo' THEN p.estado END) AS marzo, " +
                "MAX(CASE WHEN p.mes = 'abril' THEN p.estado END) AS abril, " +
                "MAX(CASE WHEN p.mes = 'mayo' THEN p.estado END) AS mayo, " +
                "MAX(CASE WHEN p.mes = 'junio' THEN p.estado END) AS junio, " +
                "MAX(CASE WHEN p.mes = 'julio' THEN p.estado END) AS julio, " +
                "MAX(CASE WHEN p.mes = 'agosto' THEN p.estado END) AS agosto, " +
                "MAX(CASE WHEN p.mes = 'septiembre' THEN p.estado END) AS septiembre, " +
                "MAX(CASE WHEN p.mes = 'octubre' THEN p.estado END) AS octubre, " +
                "MAX(CASE WHEN p.mes = 'noviembre' THEN p.estado END) AS noviembre, " +
                "MAX(CASE WHEN p.mes = 'diciembre' THEN p.estado END) AS diciembre " +
                "FROM Usuarios u " +
                "JOIN Alumnos a ON u.usuario_id = a.alumno_id " +
                "JOIN Pagos p ON a.alumno_id = p.alumno_id " +
                "WHERE u.dni = ? " +
                "GROUP BY u.nombre, u.apellido, u.dni";

        Pago pagos = new Pago();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, dni);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                pagos.setNombre_alumno(resultSet.getString("nombre"));
                pagos.setDNI(resultSet.getString("dni"));
                pagos.setMarzo(resultSet.getString("marzo"));
                pagos.setAbril(resultSet.getString("abril"));
                pagos.setMayo(resultSet.getString("mayo"));
                pagos.setJunio(resultSet.getString("junio"));
                pagos.setJulio(resultSet.getString("julio"));
                pagos.setAgosto(resultSet.getString("agosto"));
                pagos.setSeptiembre(resultSet.getString("septiembre"));
                pagos.setOctubre(resultSet.getString("octubre"));
                pagos.setNoviembre(resultSet.getString("noviembre"));
                pagos.setDiciembre(resultSet.getString("diciembre"));
            }

        } catch (SQLException ex) {
            System.out.println("Error al buscar pagos: " + ex.getMessage());
        }
        return pagos;
    }
}
