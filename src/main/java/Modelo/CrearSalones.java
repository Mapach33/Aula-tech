package Modelo;

import java.io.*;
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

    public String toFileString() {
        return codigo + "," + nombre + "," + capacidad;
    }
}

public class CrearSalones {
    private static final ArrayList<Salon> salones = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static final String FILE_NAME = "data/salones.txt";

    public void gestionarSalones(String archivoSalones) {

        cargarSalonesDesdeArchivo(); // Cargar los salones al iniciar
        int opcion;
        do {
            ConsoleUtils.clearConsole();
            mostrarMenu();
            opcion = obtenerOpcion();

            switch (opcion) {
                case 1 -> añadirSalon();
                case 2 -> eliminarSalon();
                case 3 -> modificarSalon();
                case 4 -> mostrarSalones();
                case 5 -> {
                    guardarSalonesEnArchivo(); // Guardar al salir
                    System.out.println("Saliendo de la gestion de salones...");
                }
                default -> System.out.println("Opcion no valida, intente nuevamente.");
            }
        } while (opcion != 5);
    }

    public static void mostrarMenu() {
        System.out.println("\n--- Gestion de Salones ---");
        System.out.println("1. Anadir salon");
        System.out.println("2. Eliminar salon");
        System.out.println("3. Modificar salon");
        System.out.println("4. Mostrar salones");
        System.out.println("5. Salir");
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

    private static void añadirSalon() {
        ConsoleUtils.clearConsole();
        int grado = obtenerGrado();
        int numeroSeccion = obtenerNumeroSeccion();
        String codigo = generarCodigo(grado, numeroSeccion);

        System.out.print("Ingrese el nombre del salon: ");
        String nombre = scanner.nextLine();
        int capacidad = obtenerCapacidad();

        salones.add(new Salon(codigo, nombre, capacidad));
        System.out.println("Salon anadido exitosamente.");
    }

    private static int obtenerGrado() {
        int grado;
        do {
            System.out.print("Ingrese el grado (1-6): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada no valida. Por favor ingrese un numero entre 1 y 6.");
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
            System.out.print("Ingrese el numero de seccion (01-27): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada no valida. Por favor ingrese un numero entre 1 y 27.");
                scanner.next(); // Limpiar la entrada incorrecta
            }
            numeroSeccion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
        } while (numeroSeccion < 1 || numeroSeccion > 27);
        return numeroSeccion;
    }

    private static String generarCodigo(int grado, int numeroSeccion) {
        return String.format("%d%02d", grado, numeroSeccion); // Formato XYY
    }

    private static int obtenerCapacidad() {
        System.out.print("Ingrese la capacidad del salon: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada no valida. Por favor ingrese un numero.");
            scanner.next(); // Limpiar la entrada incorrecta
        }
        int capacidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        return capacidad;
    }

    private static void eliminarSalon() {
        ConsoleUtils.clearConsole();
        System.out.print("Ingrese el codigo del salon a eliminar: ");
        String codigo = scanner.nextLine();

        Salon salonEliminar = buscarSalon(codigo);
        if (salonEliminar != null) {
            salones.remove(salonEliminar);
            System.out.println("Salon eliminado exitosamente.");
        } else {
            System.out.println("Salon no encontrado.");
        }
    }

    private static void modificarSalon() {
        ConsoleUtils.clearConsole();
        System.out.print("Ingrese el codigo del salon a modificar: ");
        String codigo = scanner.nextLine();

        Salon salonModificar = buscarSalon(codigo);
        if (salonModificar != null) {
            System.out.print("Ingrese el nuevo nombre del salon: ");
            String nombre = scanner.nextLine();
            int capacidad = obtenerCapacidad();

            salonModificar.setNombre(nombre);
            salonModificar.setCapacidad(capacidad);
            System.out.println("Salon modificado exitosamente.");
        } else {
            System.out.println("Salon no encontrado.");
        }
    }

    private static void mostrarSalones() {
        ConsoleUtils.clearConsole();
        if (salones.isEmpty()) {
            System.out.println("No hay salones registrados.");
        } else {
            System.out.println(String.format("| %-10s | %-20s | %-10s |", "Codigo", "Nombre", "Capacidad"));
            System.out.println("-----------------------------------------------");
            for (Salon salon : salones) {
                System.out.println(salon);
            }
           ConsoleUtils.pauseConsole(); // Esperar que el usuario presione Enter
        }
    }

    private static Salon buscarSalon(String codigo) {
        return salones.stream()
                .filter(salon -> salon.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }

    private static void guardarSalonesEnArchivo() {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(FILE_NAME)))) {
            for (Salon salon : salones) {
                writer.println(salon.toFileString()); // Guardar cada salón en una línea
            }
            System.out.println("Salones guardados.");
        } catch (IOException e) {
            System.out.println("Error al guardar los salones: " + e.getMessage());
        }
    }

    private static void cargarSalonesDesdeArchivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 3) {
                    String codigo = datos[0];
                    String nombre = datos[1];
                    int capacidad = Integer.parseInt(datos[2]);
                    salones.add(new Salon(codigo, nombre, capacidad));
                }
            }
            //System.out.println("Salones cargados desde el archivo " + FILE_NAME);
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado. Comenzando con lista vacía.");
        } catch (IOException e) {
            System.out.println("Error al cargar los salones: " + e.getMessage());
        }
    }
}
