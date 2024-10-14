package Modelo;

import java.util.ArrayList;
import java.util.Scanner;

class Nota {
    private final String codigo;
    private String descripcion;
    private double calificacion;

    public Nota(String codigo, String descripcion, double calificacion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.calificacion = calificacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return String.format("| %-10s | %-20s | %-10.2f |", codigo, descripcion, calificacion);
    }
}

public class Notas {
    private static final ArrayList<Nota> notas = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = obtenerOpcion();

            switch (opcion) {
                case 1:
                    añadirNota();
                    break;
                case 2:
                    eliminarNota();
                    break;
                case 3:
                    modificarNota();
                    break;
                case 4:
                    mostrarNotas();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        } while (opcion != 5);
    }

    public static void mostrarMenu() {
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
        System.out.print("Ingrese el código de la nota: ");
        String codigo = scanner.nextLine();

        System.out.print("Ingrese la descripción de la nota: ");
        String descripcion = scanner.nextLine();

        double calificacion = obtenerCalificacion();

        notas.add(new Nota(codigo, descripcion, calificacion));
        System.out.println("Nota añadida exitosamente.");
    }

    private static double obtenerCalificacion() {
        System.out.print("Ingrese la calificación: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Entrada no válida. Por favor ingrese un número.");
            scanner.next(); // Limpiar la entrada incorrecta
        }
        double calificacion = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer
        return calificacion;
    }

    private static void eliminarNota() {
        System.out.print("Ingrese el código de la nota a eliminar: ");
        String codigo = scanner.nextLine();

        Nota notaEliminar = buscarNota(codigo);
        if (notaEliminar != null) {
            notas.remove(notaEliminar);
            System.out.println("Nota eliminada exitosamente.");
        } else {
            System.out.println("Nota no encontrada.");
        }
    }

    private static void modificarNota() {
        System.out.print("Ingrese el código de la nota a modificar: ");
        String codigo = scanner.nextLine();

        Nota notaModificar = buscarNota(codigo);
        if (notaModificar != null) {
            System.out.print("Ingrese la nueva descripción de la nota: ");
            String descripcion = scanner.nextLine();
            double calificacion = obtenerCalificacion();

            notaModificar.setDescripcion(descripcion);
            notaModificar.setCalificacion(calificacion);
            System.out.println("Nota modificada exitosamente.");
        } else {
            System.out.println("Nota no encontrada.");
        }
    }

    private static void mostrarNotas() {
        if (notas.isEmpty()) {
            System.out.println("No hay notas registradas.");
        } else {
            System.out.println(String.format("| %-10s | %-20s | %-10s |", "Código", "Descripción", "Calificación"));
            System.out.println("-----------------------------------------------");
            for (Nota nota : notas) {
                System.out.println(nota);
            }
        }
    }

    private static Nota buscarNota(String codigo) {
        return notas.stream()
                .filter(nota -> nota.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }
}
