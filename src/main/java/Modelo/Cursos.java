package Controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cursos {
    private static final Scanner scanner = new Scanner(System.in);
    
    // List to hold the courses per section
    private static final List<Course> courses = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenuCursos();
            opcion = obtenerOpcion();

            switch (opcion) {
                case 1:
                    agregarCurso();
                    break;
                case 2:
                    mostrarCursosPorSeccion();
                    break;
                case 3:
                    System.out.println("Saliendo del menú de cursos...");
                    break;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        } while (opcion != 3);
    }

    private static void mostrarMenuCursos() {
        System.out.println("\n--- Gestión de Cursos ---");
        System.out.println("1. Agregar curso");
        System.out.println("2. Mostrar cursos por sección");
        System.out.println("3. Salir");
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

    private static void agregarCurso() {
        System.out.print("Ingrese el código del curso: ");
        String codigoCurso = scanner.nextLine();

        System.out.print("Ingrese el nombre del curso: ");
        String nombreCurso = scanner.nextLine();

        System.out.print("Ingrese el número de sección (ejemplo: 301): ");
        String seccion = scanner.nextLine();

        // Guardar el curso
        courses.add(new Course(codigoCurso, nombreCurso, seccion));
        System.out.println("Curso agregado exitosamente.");
    }

    private static void mostrarCursosPorSeccion() {
        System.out.println("Selecciona una sección:");
        List<String> secciones = new ArrayList<>();
        for (Course course : courses) {
            if (!secciones.contains(course.getSeccion())) {
                secciones.add(course.getSeccion());
            }
        }

        for (int i = 0; i < secciones.size(); i++) {
            System.out.println((i + 1) + ". " + secciones.get(i));
        }

        int seccionSeleccionada = obtenerOpcion();
        if (seccionSeleccionada > 0 && seccionSeleccionada <= secciones.size()) {
            String selectedSection = secciones.get(seccionSeleccionada - 1);
            System.out.println("Cursos para la sección " + selectedSection + ":");
            boolean found = false;

            for (Course course : courses) {
                if (course.getSeccion().equals(selectedSection)) {
                    System.out.println("- " + course.getNombreCurso() + " (Código: " + course.getCodigoCurso() + ")");
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No hay cursos disponibles para esta sección.");
            }
        } else {
            System.out.println("Selección inválida.");
        }
    }

    // Inner class to represent a Course
    private static class Course {
        private final String codigoCurso;
        private final String nombreCurso;
        private final String seccion;

        public Course(String codigoCurso, String nombreCurso, String seccion) {
            this.codigoCurso = codigoCurso;
            this.nombreCurso = nombreCurso;
            this.seccion = seccion;
        }

        public String getCodigoCurso() {
            return codigoCurso;
        }

        public String getNombreCurso() {
            return nombreCurso;
        }

        public String getSeccion() {
            return seccion;
        }
    }
}

