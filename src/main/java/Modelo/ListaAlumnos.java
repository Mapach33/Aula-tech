package Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para manejar la lista de alumnos.
 * Autor: MATHIAS
 */
public class ListaAlumnos {

    private final String archivoPersonas = "data/usuarios.txt";

    // Método para obtener solo los alumnos del archivo
    public List<Alumno> obtenerAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoPersonas))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length >= 7 && "ALUMNO".equals(datos[6])) {
                    // Crear un alumno basado en los datos del archivo
                    String dni = datos[0];
                    String nombre = datos[1];
                    String apellido = datos[2];
                    String email = datos[3];
                    Alumno alumno = new Alumno(dni, nombre, apellido, email);
                    alumnos.add(alumno);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return alumnos;
    }

    // Método para obtener un alumno por su DNI
    public Alumno obtenerAlumnoPorDni(String dni) {
        for (Alumno alumno : obtenerAlumnos()) {
            if (alumno.getDni().equals(dni)) {
                return alumno;
            }
        }
        return null; // Retorna null si no se encuentra el alumno
    }

    // Método para mostrar los alumnos registrados
    public void mostrarAlumnosRegistrados() {
        List<Alumno> alumnos = obtenerAlumnos();
        System.out.println("---- Alumnos Registrados ----");
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
        } else {
            // Encabezados de la tabla
            System.out.printf("%-15s %-15s %-15s %-30s\n", "DNI", "Nombre", "Apellido", "Email");
            System.out.println("----------------------------------------------------------------------");

            // Iterar por cada alumno y mostrar sus datos en formato tabla
            for (Alumno alumno : alumnos) {
                System.out.printf("%-15s %-15s %-15s %-30s\n",
                    alumno.getDni(),
                    alumno.getNombre(),
                    alumno.getApellido(),
                    alumno.getEmail());
            }
        }
        System.out.println("----------------------------------------------------------------------");
    }
}
