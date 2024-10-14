package Controlador;

import java.util.ArrayList;
import java.util.Scanner;

class Salon {
    private final String codigo;
    private String nombre;
    private int capacidad;

    public Salon(String codigo, String nombre, int capacidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.capacidad = capacidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return String.format("| %-10s | %-20s | %-10d |", codigo, nombre, capacidad);
    }
}

public class CrearSalones {
    private static final ArrayList<Salon> salones = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = obtenerOpcion();

            switch (opcion) {
                case 1:
                    añadirSalon();
                    break;
                case 2:
                    eliminarSalon();
                    break;
                case 3:
                    modificarSalon();
                    break;
                case 4:
                    mostrarSalones();
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
        System.out.println("\n--- Gestión de Salones ---");
        System.out.println("1. Añadir salón");
        System.out.println("2. Eliminar salón");
        System.out.println("3. Modificar salón");
        System.out.println("4. Mostrar salones");
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

    private static void añadirSalon() {
        int grado = obtenerGrado();
        int numeroSeccion = obtenerNumeroSeccion();
        String codigo = generarCodigo(grado, numeroSeccion);
        
        System.out.print("Ingrese el nombre del salón: ");
        String nombre = scanner.nextLine();
        int capacidad = obtenerCapacidad();

        salones.add(new Salon(codigo, nombre, capacidad));
        System.out.println("Salón añadido exitosamente.");
    }

    private static int obtenerGrado() {
        int grado;
        do {
            System.out.print("Ingrese el grado (1-6): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada no válida. Por favor ingrese un número entre 1 y 6.");
                scanner.next(); // Limpiar la entrada incorrecta
            }
            grado = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
        } while (grado < 1 || grado > 6);
        return grado;
    }

    private static int obtenerNumeroSeccion() {
        int numeroSeccion;
        do {
            System.out.print("Ingrese el número de sección (01-99): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada no válida. Por favor ingrese un número entre 1 y 99.");
                scanner.next(); // Limpiar la entrada incorrecta
            }
            numeroSeccion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
        } while (numeroSeccion < 1 || numeroSeccion > 99);
        return numeroSeccion;
    }

    private static String generarCodigo(int grado, int numeroSeccion) {
        return String.format("%d%02d", grado, numeroSeccion); // Formato XYY
    }

    private static int obtenerCapacidad() {
        System.out.print("Ingrese la capacidad del salón: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada no válida. Por favor ingrese un número.");
            scanner.next(); // Limpiar la entrada incorrecta
        }
        int capacidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        return capacidad;
    }

    private static void eliminarSalon() {
        System.out.print("Ingrese el código del salón a eliminar: ");
        String codigo = scanner.nextLine();

        Salon salonEliminar = buscarSalon(codigo);
        if (salonEliminar != null) {
            salones.remove(salonEliminar);
            System.out.println("Salón eliminado exitosamente.");
        } else {
            System.out.println("Salón no encontrado.");
        }
    }

    private static void modificarSalon() {
        System.out.print("Ingrese el código del salón a modificar: ");
        String codigo = scanner.nextLine();

        Salon salonModificar = buscarSalon(codigo);
        if (salonModificar != null) {
            System.out.print("Ingrese el nuevo nombre del salón: ");
            String nombre = scanner.nextLine();
            int capacidad = obtenerCapacidad();

            salonModificar.setNombre(nombre);
            salonModificar.setCapacidad(capacidad);
            System.out.println("Salón modificado exitosamente.");
        } else {
            System.out.println("Salón no encontrado.");
        }
    }

    private static void mostrarSalones() {
        if (salones.isEmpty()) {
            System.out.println("No hay salones registrados.");
        } else {
            System.out.println(String.format("| %-10s | %-20s | %-10s |", "Código", "Nombre", "Capacidad"));
            System.out.println("-----------------------------------------------");
            for (Salon salon : salones) {
                System.out.println(salon);
            }
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
        }
    }

    private static Salon buscarSalon(String codigo) {
        return salones.stream()
                .filter(salon -> salon.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }
}
