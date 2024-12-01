package Modelo.dao;

import Modelo.entities.Salon;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static Modelo.DatabaseUtils.getConnection;

public class SalonDAO {
    public List<Salon> getAllSalones() {
        String query = "SELECT * FROM Salones order by nombre";
        List<Salon> salones = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()) {
                Salon salon = new Salon();
                salon.setId(resultSet.getInt("salon_id"));
                salon.setNombre(resultSet.getString("nombre"));
                salon.setSeccion(resultSet.getString("seccion"));
                salon.setGrado(resultSet.getString("grado"));
                salon.setCapacidad(resultSet.getString("capacidad"));
                salones.add(salon);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar salones: " + e.getMessage());
        }
        return salones;
    }



}
