package Modelo.dao;

import Modelo.DatabaseUtils;
import Modelo.entities.CursoNota;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CursoNotaDAO {
    public static List<CursoNota> getCursoNotaPorID(int alumno_id) {
        String query = "SELECT c.nombre AS curso, " +
                "ROUND(AVG(CASE WHEN b.bimestre = 1 THEN n.promedio END)) AS nota_bimestre1, " +
                "ROUND(AVG(CASE WHEN b.bimestre = 2 THEN n.promedio END)) AS nota_bimestre2, " +
                "ROUND(AVG(CASE WHEN b.bimestre = 3 THEN n.promedio END)) AS nota_bimestre3, " +
                "ROUND(AVG(CASE WHEN b.bimestre = 4 THEN n.promedio END)) AS nota_bimestre4, " +
                "ROUND(AVG(n.promedio)) AS nota_final " +
                "FROM Notas n " +
                "JOIN Cursos c ON n.curso_id = c.curso_id " +
                "JOIN Bimestres b ON n.bimestre_id = b.ciclo_id " +
                "WHERE n.alumno_id = ? " +
                "GROUP BY c.nombre " +
                "ORDER BY c.nombre";
        List<CursoNota> notas = new ArrayList<>();
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, alumno_id);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    CursoNota cursoNota = new CursoNota();
                    cursoNota.setNombreCurso(rs.getString("curso"));
                    cursoNota.setNotaBimestre1(rs.getString("nota_bimestre1"));
                    cursoNota.setNotaBimestre2(rs.getString("nota_bimestre2"));
                    cursoNota.setNotaBimestre3(rs.getString("nota_bimestre3"));
                    cursoNota.setNotaBimestre4(rs.getString("nota_bimestre4"));
                    cursoNota.setNotaFinal(rs.getString("nota_final"));
                    notas.add(cursoNota);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return notas;
    }
}