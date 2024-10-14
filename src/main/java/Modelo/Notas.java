package Modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Notas {
    private static final String archivoNotas = "data/notas.txt";
    private static final List<Alumno> alumnos = new ListaAlumnos().obtenerAlumnos();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = obtenerOpcion();

            switch (opcion) {
                case 1 -> añadirNota();
                case 2 -> eliminarNota();
                case 3 -> modificarNota();
                case 4 -> mostrarNotas();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida, intente nuevamente.");
            }
        } while (opcion != 5);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Gestión de Notas ---");
        System.out.println("1. Añadir nota");
        System.out.println("2. Eliminar nota");
        System.out.println("3. Modificar nota");
        System.out.println("4. Mostrar notas");
        System.out.println("5. Salir");
    }

    private static int obtenerOpcion() {
        System.out.print("Seleccione una opción: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada no válida. Por favor ingrese un número.");
            scanner.next(); // Limpiar la entrada incorrecta
        }
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        return opcion;
    }

    private static void añadirNota() {
        System.out.print("Ingrese el código del alumno: ");
        String codigoAlumno = scanner.nextLine();

        Alumno alumno = buscarAlumno(codigoAlumno);
        if (alumno == null) {
            System.out.println("Alumno no encontrado.");
            return;
        }

        System.out.print("Ingrese la nota: ");
        String nota = scanner.nextLine();

        guardarNotaEnArchivo(codigoAlumno, nota);
        System.out.println("Nota añadida exitosamente.");
    }

    private static void eliminarNota() {
        System.out.print("Ingrese el código del alumno: ");
        String codigoAlumno = scanner.nextLine();

        List<String> notas = leerNotasDesdeArchivo();
        boolean notaEliminada = false;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoNotas))) {
            for (String linea : notas) {
                String[] datos = linea.split(",");
                if (!datos[0].equals(codigoAlumno)) {
                    writer.write(linea + "\n");
                } else {
                    notaEliminada = true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al eliminar la nota: " + e.getMessage());
        }

        if (notaEliminada) {
            System.out.println("Nota eliminada exitosamente.");
        } else {
            System.out.println("Nota no encontrada.");
        }
    }

    private static void modificarNota() {
        System.out.print("Ingrese el código del alumno: ");
        String codigoAlumno = scanner.nextLine();

        List<String> notas = leerNotasDesdeArchivo();
        boolean notaModificada = false;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoNotas))) {
            for (String linea : notas) {
                String[] datos = linea.split(",");
                if (datos[0].equals(codigoAlumno)) {
                    System.out.print("Ingrese la nueva nota: ");
                    String nuevaNota = scanner.nextLine();
                    writer.write(codigoAlumno + "," + nuevaNota + "\n");
                    notaModificada = true;
                } else {
                    writer.write(linea + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Error al modificar la nota: " + e.getMessage());
        }

        if (notaModificada) {
            System.out.println("Nota modificada exitosamente.");
        } else {
            System.out.println("Nota no encontrada.");
        }
    }

    private static void mostrarNotas() {
        List<String> notas = leerNotasDesdeArchivo();
        if (notas.isEmpty()) {
            System.out.println("No hay notas registradas.");
        } else {
            System.out.println("---- Notas Registradas ----");
            for (String linea : notas) {
                String[] datos = linea.split(",");
                System.out.printf("Alumno ID: %s, Nota: %s\n", datos[0], datos[1]);
            }
        }
    }

    private static Alumno buscarAlumno(String codigo) {
        return alumnos.stream()
                .filter(alumno -> alumno.getDni().equals(codigo))
                .findFirst()
                .orElse(null);
    }

    private static void guardarNotaEnArchivo(String codigoAlumno, String nota) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoNotas, true))) {
            writer.write(codigoAlumno + "," + nota + "\n");
        } catch (IOException e) {
            System.out.println("Error al guardar la nota: " + e.getMessage());
        }
    }

    private static List<String> leerNotasDesdeArchivo() {
        List<String> notas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoNotas))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                notas.add(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer las notas: " + e.getMessage());
        }
        return notas;
    }
}
