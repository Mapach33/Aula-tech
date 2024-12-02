package Modelo;
import Modelo.dao.AlumnoDAO;
import Modelo.dao.CursoNotaDAO;
import Modelo.entities.Alumno;
import Modelo.entities.CursoNota;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ReporteNotasPDF {

    public static void main(String[] args) {
        ReporteNotasPDF reporte = new ReporteNotasPDF();
        reporte.generarReporteExcel(4);;
        System.out.println("Reporte generado exitosamente.");
    }

    public void generarReporteExcel(int id) {
        Alumno alumno = AlumnoDAO.getAlumnoPorID(id);
        List<CursoNota> notas = CursoNotaDAO.getCursoNotaPorID(id);

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Reporte de Notas");

        // Crear estilo para el encabezado
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(new XSSFColor(new java.awt.Color(148, 220, 248), null));
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerStyle.setBorderBottom(BorderStyle.THIN);
        headerStyle.setBorderTop(BorderStyle.THIN);
        headerStyle.setBorderRight(BorderStyle.THIN);
        headerStyle.setBorderLeft(BorderStyle.THIN);

        // Crear estilo para las celdas de datos
        CellStyle dataStyle = workbook.createCellStyle();
        dataStyle.setBorderBottom(BorderStyle.THIN);
        dataStyle.setBorderTop(BorderStyle.THIN);
        dataStyle.setBorderRight(BorderStyle.THIN);
        dataStyle.setBorderLeft(BorderStyle.THIN);

        // Crear encabezados
        Row headerRow = sheet.createRow(0);
        String[] headers = {"Nombre del Curso", "Nota Bimestre 1", "Nota Bimestre 2", "Nota Bimestre 3", "Nota Bimestre 4", "Nota Final"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }

        // Ajustar la anchura de las columnas al tamaño del contenido del encabezado
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Llenar datos
        int rowNum = 1;
        for (CursoNota nota : notas) {
            Row row = sheet.createRow(rowNum++);
            Cell cell0 = row.createCell(0);
            cell0.setCellValue(nota.getNombreCurso());
            cell0.setCellStyle(dataStyle);

            Cell cell1 = row.createCell(1);
            cell1.setCellValue(Double.parseDouble(nota.getNotaBimestre1()));
            cell1.setCellStyle(dataStyle);

            Cell cell2 = row.createCell(2);
            cell2.setCellValue(Double.parseDouble(nota.getNotaBimestre2()));
            cell2.setCellStyle(dataStyle);

            Cell cell3 = row.createCell(3);
            cell3.setCellValue(Double.parseDouble(nota.getNotaBimestre3()));
            cell3.setCellStyle(dataStyle);

            Cell cell4 = row.createCell(4);
            cell4.setCellValue(Double.parseDouble(nota.getNotaBimestre4()));
            cell4.setCellStyle(dataStyle);

            Cell cell5 = row.createCell(5);
            cell5.setCellValue(Double.parseDouble(nota.getNotaFinal()));
            cell5.setCellStyle(dataStyle);
        }

        // Agregar información del alumno dos filas abajo de los cursos
        rowNum += 2;
        String[][] studentInfo = {
                {"Nombre", alumno.getNombreCompleto()},
                {"Grado", alumno.getGrado()},
                {"Seccion", alumno.getSeccion()},
        };

        for (String[] info : studentInfo) {
            Row row = sheet.createRow(rowNum++);
            Cell cell0 = row.createCell(0);
            cell0.setCellValue(info[0]);
            cell0.setCellStyle(dataStyle);

            Cell cell1 = row.createCell(1);
            cell1.setCellValue(info[1]);
            cell1.setCellStyle(dataStyle);
        }

        // Escribir el archivo
        try (FileOutputStream fileOut = new FileOutputStream("Reporte Notas " + alumno.getNombreCompleto() + ".xlsx")) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Cerrar el workbook
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
