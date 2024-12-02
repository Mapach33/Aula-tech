package Modelo.dao;

import Modelo.entities.Alumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Modelo.DatabaseUtils.getConnection;

public class AlumnoDAO {

    public static List<Alumno> getAllAlumnos() throws SQLException {
        String query = "SELECT u.usuario_id, u.apellido, u.nombre, s.grado, s.seccion " +
                "FROM Usuarios u " +
                "JOIN Alumnos a ON u.usuario_id = a.alumno_id " +
                "JOIN Salones s ON a.salon_id = s.salon_id " +
                "WHERE u.tipo = 'alumno'";
        List<Alumno> alumnos = new ArrayList<>();

        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery()){
                while(resultSet.next()){
                    Alumno alumno = new Alumno();
                    alumno.setAlumno_id(resultSet.getInt("usuario_id"));
                    alumno.setApellido(resultSet.getString("apellido"));
                    alumno.setNombre(resultSet.getString("nombre"));
                    alumno.setGrado(resultSet.getString("grado"));
                    alumno.setSeccion(resultSet.getString("seccion"));
                    alumnos.add(alumno);
                }

        }catch (Exception e){
            System.out.println("Error al obtener alumnos: " + e.getMessage());
        }
        return alumnos;
    }

    public static List<Alumno> getAlumnosPorFiltros(String apellido,String nombre,String grado){
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

        List<Alumno> results = new ArrayList<>();

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
                    Alumno alumno = new Alumno();
                    alumno.setAlumno_id(resultSet.getInt("usuario_id"));
                    alumno.setApellido(resultSet.getString("apellido"));
                    alumno.setNombre(resultSet.getString("nombre"));
                    alumno.setGrado(resultSet.getString("grado"));
                    alumno.setSeccion(resultSet.getString("seccion"));
                    results.add(alumno);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar alumnos: " + ex.getMessage());
        }
        return results;
    }

    public static Alumno getAlumnoPorID(int id){
        String query = "SELECT u.usuario_id, u.apellido, u.nombre, s.grado, s.seccion " +
                "FROM Usuarios u " +
                "JOIN Alumnos a ON u.usuario_id = a.alumno_id " +
                "JOIN Salones s ON a.salon_id = s.salon_id " +
                "WHERE u.tipo = 'alumno' AND u.usuario_id = ?";
        Alumno alumno = new Alumno();
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,id);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while(resultSet.next()){
                    alumno.setAlumno_id(resultSet.getInt("usuario_id"));
                    alumno.setApellido(resultSet.getString("apellido"));
                    alumno.setNombre(resultSet.getString("nombre"));
                    alumno.setGrado(resultSet.getString("grado"));
                    alumno.setSeccion(resultSet.getString("seccion"));
                }
            }
        }catch (Exception e){
            System.out.println("Error al obtener alumno: " + e.getMessage());
        }
        return alumno;
    }



}
