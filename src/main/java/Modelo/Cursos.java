package Modelo;

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
                    System.out.println("Saliendo del menu de cursos...");
                    break;
                default:
                    System.out.println("Opción no valida, intente nuevamente.");
            }
        } while (opcion != 3);
    }

    private static void mostrarMenuCursos() {
        System.out.println("\n--- Gestión de Cursos ---");
        System.out.println("1. Agregar curso");
        System.out.println("2. Mostrar cursos por seccion");
        System.out.println("3. Salir");
    }

    private static int obtenerOpcion() {
        System.out.print("Seleccione una opcion: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada no valida. Por favor ingrese un numero.");
            scanner.next(); // Limpiar la entrada incorrecta
        }
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        return opcion;
    }

    private static void agregarCurso() {
        System.out.print("Ingrese el codigo del curso: ");
        String codigoCurso = scanner.nextLine();

        System.out.print("Ingrese el nombre del curso: ");
        String nombreCurso = scanner.nextLine();

        System.out.print("Ingrese el numero de seccion (ejemplo: 301): ");
        String seccion = scanner.nextLine();

        // Guardar el curso
        courses.add(new Course(codigoCurso, nombreCurso, seccion));
        System.out.println("Curso agregado exitosamente.");
    }

    private static void mostrarCursosPorSeccion() {
        System.out.println("Selecciona una seccion:");
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
            System.out.println("Cursos para la seccion " + selectedSection + ":");
            boolean found = false;

            for (Course course : courses) {
                if (course.getSeccion().equals(selectedSection)) {
                    System.out.println("- " + course.getNombreCurso() + " (Codigo: " + course.getCodigoCurso() + ")");
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No hay cursos disponibles para esta seccion.");
            }
        } else {
            System.out.println("Seleccion invalida.");
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

