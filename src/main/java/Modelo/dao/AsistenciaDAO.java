package Modelo.dao;

import Modelo.entities.Asistencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Modelo.DatabaseUtils;

public class AsistenciaDAO {
    public static List<Asistencia> getAsistenciaPorBimestre(String bimestre) {
        List<Asistencia> asistencias = new ArrayList<>();
        String query = "SELECT c.nombre AS curso, " +
                "MAX(CASE WHEN a.semana = '1' THEN a.estado END) AS sem1, " +
                "MAX(CASE WHEN a.semana = '2' THEN a.estado END) AS sem2, " +
                "MAX(CASE WHEN a.semana = '3' THEN a.estado END) AS sem3, " +
                "MAX(CASE WHEN a.semana = '4' THEN a.estado END) AS sem4, " +
                "MAX(CASE WHEN a.semana = '5' THEN a.estado END) AS sem5, " +
                "MAX(CASE WHEN a.semana = '6' THEN a.estado END) AS sem6, " +
                "MAX(CASE WHEN a.semana = '7' THEN a.estado END) AS sem7, " +
                "MAX(CASE WHEN a.semana = '8' THEN a.estado END) AS sem8 " +
                "FROM Asistencia a " +
                "JOIN Cursos c ON a.curso_id = c.curso_id " +
                "JOIN Bimestres b ON a.bimestre_id = b.ciclo_id " +
                "WHERE b.bimestre = ? " +
                "GROUP BY c.nombre";

        try (Connection conn = DatabaseUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, bimestre);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Asistencia asistencia = new Asistencia();
                asistencia.setCurso(rs.getString("curso"));
                asistencia.setSem1(rs.getString("sem1"));
                asistencia.setSem2(rs.getString("sem2"));
                asistencia.setSem3(rs.getString("sem3"));
                asistencia.setSem4(rs.getString("sem4"));
                asistencia.setSem5(rs.getString("sem5"));
                asistencia.setSem6(rs.getString("sem6"));
                asistencia.setSem7(rs.getString("sem7"));
                asistencia.setSem8(rs.getString("sem8"));
                asistencias.add(asistencia);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return asistencias;
    }

}
