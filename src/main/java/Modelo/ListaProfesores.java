/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListaProfesores {

    private final String archivoPersonas = "data/usuarios.txt";

    // Método para obtener solo los profesores del archivo
    public List<Profesor> obtenerProfesores() {
        List<Profesor> profesores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoPersonas))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length >= 7 && "PROFESOR".equals(datos[6])) {
                    // Crear un profesor basado en los datos del archivo
                    String dni = datos[0];
                    String nombre = datos[1];
                    String apellido = datos[2];
                    String email = datos[3];
                    Profesor profesor = new Profesor(dni, nombre, apellido, email);
                    profesores.add(profesor);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return profesores;
    }

    // Método para mostrar los profesores registrados
    public void mostrarProfesoresRegistrados() {
        ConsoleUtils.clearConsole();
        List<Profesor> profesores = obtenerProfesores();
        System.out.println("---- Profesores Registrados ----");
        if (profesores.isEmpty()) {
            System.out.println("No hay profesores registrados.");
        } else {
            // Encabezados de la tabla
            System.out.printf("%-15s %-15s %-15s %-30s\n", "DNI", "Nombre", "Apellido", "Email");
            System.out.println("----------------------------------------------------------------------");

            // Iterar por cada profesor y mostrar sus datos en formato tabla
            for (Profesor profesor : profesores) {
                System.out.printf("%-15s %-15s %-15s %-30s\n",
                        profesor.getDni(),
                        profesor.getNombre(),
                        profesor.getApellido(),
                        profesor.getEmail());
            }
        }
        System.out.println("----------------------------------------------------------------------");
        ConsoleUtils.pauseConsole();
    }

}
