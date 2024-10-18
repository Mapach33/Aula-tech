package Modelo;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AsistenciaManager {

    // Método para ver la asistencia de un alumno
    public void verAsistencia(String codigoAlumno) {
        List<String> asistencias = leerAsistenciasDesdeArchivo(codigoAlumno);

        if (asistencias.isEmpty()) {
            System.out.println("No hay registros de asistencia para el alumno con DNI: " + codigoAlumno);
        } else {
            System.out.println("---- Registro de Asistencias (Ultima Semana) ----");
            LocalDate hoy = LocalDate.now();
            LocalDate unaSemanaAtras = hoy.minusWeeks(1);

            for (String asistencia : asistencias) {
                String[] datos = asistencia.split(",");
                LocalDate fecha = LocalDate.parse(datos[1], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                if (!fecha.isBefore(unaSemanaAtras) && !fecha.isAfter(hoy)) {
                    System.out.println("DNI: " + datos[0] + ", Fecha: " + datos[1] + ", Asistencia: " + datos[2]);
                }
            }
        }
    }

    // Método para leer las asistencias desde un archivo
    private List<String> leerAsistenciasDesdeArchivo(String codigoAlumno) {
        List<String> asistencias = new ArrayList<>();
        String archivoAsistencias = "data/asistencias.txt"; // Ruta del archivo de asistencias

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoAsistencias))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos[0].equals(codigoAlumno)) {
                    asistencias.add(linea); // Agregar la línea completa si coincide con el código
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer las asistencias: " + e.getMessage());
        }
        return asistencias;
    }

    // Método para registrar la asistencia de un alumno
    public void registrarAsistencia(String codigoAlumno, boolean presente) {
        String estado = presente ? "Presente" : "Ausente";
        String fecha = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        guardarAsistenciaEnArchivo(codigoAlumno, fecha, estado);
    }

    // Método para guardar la asistencia en un archivo
    private void guardarAsistenciaEnArchivo(String codigoAlumno, String fecha, String estado) {
        String archivoAsistencias = "data/asistencias.txt"; // Ruta del archivo de asistencias
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoAsistencias, true))) {
            writer.write(codigoAlumno + "," + fecha + "," + estado + "\n");
        } catch (IOException e) {
            System.out.println("Error al guardar la asistencia: " + e.getMessage());
        }
    }
}


