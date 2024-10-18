package Modelo;

import java.util.Scanner;
import java.util.List; // Importar la clase List

public class Alumno extends User {
    private AsistenciaManager asistenciaManager;

    public Alumno(String dni, String nombre, String apellido, String email) {
        super(dni, nombre, apellido, email, "ALUMNO");
        this.asistenciaManager = new AsistenciaManager(); // Instanciar AsistenciaManager
    }

    // Menú específico para Alumno con bucle persistente
    public void mostrarMenuAlumno() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        ComunicadosManager manager = new ComunicadosManager(); // Instanciar ComunicadosManager

        do {
            System.out.println("---- Menu Alumno ----");
            System.out.println("1. Informacion Personal");
            System.out.println("2. Ver Notas");
            System.out.println("3. Ver Asistencias");
            System.out.println("4. Ver Pagos");
            System.out.println("5. Ver Comunicados");
            System.out.println("6. Ver Horarios");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1 -> mostrarInfo();
                case 2 -> verNotas();
                case 3 -> asistenciaManager.verAsistencia(getDni()); // Asegúrate de que getDni() está definido
                case 4 -> verPagos();
                case 5 -> manager.mostrarComunicados(); // Mostrar comunicados
                case 6 -> verHorarios();
                case 7 -> System.out.println("Saliendo del menu Alumno...");
                default -> System.out.println("Opcion no valida.");
            }
        } while (opcion != 7);  // Repetir el menú hasta que se elija la opción de salir
    }

    public void verNotas() {
        // Lógica para ver notas
        List<String> notas = Notas.leerNotasDesdeArchivo(); // Método estático para leer notas

        if (notas.isEmpty()) {
            System.out.println("No hay notas registradas.");
            return;
        }

        System.out.println("---- Notas Registradas ----");
        boolean notasEncontradas = false; // Bandera para saber si hay notas para el alumno
        for (String linea : notas) {
            String[] datos = linea.split(",");
            if (datos[0].equals(getDni())) { // Comparar con el DNI del alumno
                System.out.printf("Nota: %s\n", datos[1]);
                notasEncontradas = true; // Se encontró una nota
            }
        }

        if (!notasEncontradas) {
            System.out.println("No se encontraron notas para este alumno.");
        }
    }

    public void verPagos() {
        // Implementar lógica para ver pagos
        System.out.println("---- Pagos ----");
        // Aquí podrías integrar una clase de gestión de pagos
        // Por ejemplo, obtener la información de pagos desde un archivo o base de datos
        // y mostrar los detalles al alumno.
    }

    public void verHorarios() {
        // Implementar lógica para ver horarios
        System.out.println("---- Horarios ----");
        // Similar a los pagos, puedes obtener horarios desde un archivo o base de datos.
    }

    public void mostrarInfo() {
        System.out.printf("Informacion Personal:\nNombre: %s %s\nDNI: %s\nEmail: %s\n",
                          getNombre(), getApellido(), getDni(), getEmail());
    }

    public void verComunicados() {
        // Implementar lógica para ver comunicados (si fuese necesario)
        // Esto ya se está manejando en el menú.
    }
}
