package Modelo;

import java.util.Scanner;

public class Profesor extends User {
    private AsistenciaManager asistenciaManager; // Instancia de AsistenciaManager
    private Notas notas; // Instancia de Notas para manejar notas
    private String tipo;

    public Profesor(String dni, String nombre, String apellido, String email, String tipo) {
        super(dni, nombre, apellido, email, "PROFESOR");
        this.asistenciaManager = new AsistenciaManager(); // Inicializar AsistenciaManager
        this.notas = new Notas(); // Inicializar Notas
        this.tipo = tipo;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void infoPersonal() {
        ConsoleUtils.clearConsole();
        System.out.printf("DNI: %s, Nombre: %s %s, Email: %s, Tipo: %s%n", getDni(), getNombre(), getApellido(), getEmail(), getTipo());
        ConsoleUtils.pauseConsole();
    }

    // Menú específico para Profesor con bucle persistente
    public void mostrarMenuProfesor() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            ConsoleUtils.clearConsole();
            System.out.println("---- Menu Profesor ----");
            System.out.println("1. Informacion personal");
            System.out.println("2. Modificar notas");
            System.out.println("3. Tomar asistencia");
            System.out.println("4. Publicar comunicado");
            System.out.println("5. Modificar horario");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1 -> infoPersonal(); // Ver información personal
                case 2 -> Notas.modificarNota(); // Llamar al método para modificar notas
                case 3 -> {
                    ConsoleUtils.clearConsole();
                    System.out.print("Ingrese el codigo del alumno: ");
                    String codigoAlumno = scanner.nextLine();
                    System.out.print("¿Esta presente? (true/false): ");
                    boolean presente = scanner.nextBoolean(); // Leer si el alumno está presente
                    asistenciaManager.registrarAsistencia(codigoAlumno, presente); // Llama al método para registrar asistencia
                }
                case 4 -> ComunicadosManager.main(null);
                case 5 -> modificarHorario(); // Llamar al método para modificar horario
                case 6 -> System.out.println("Saliendo del menu Profesor...");
                default -> System.out.println("Opcion no valida.");
            }
        } while (opcion != 6);  // Repetir el menú hasta que se elija la opción de salir
    }

    // Método para modificar horario (se puede implementar según sea necesario)
    private void modificarHorario() {
        System.out.println("Funcionalidad de modificar horario.");
        
    }
}
