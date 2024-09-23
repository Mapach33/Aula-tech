/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

import java.util.Scanner;

/**
 *
 * @author janom
 */
public class Alumno extends User {
    
    public Alumno(String dni, String nombre, String apellido, String email) {
        super(dni, nombre, apellido, email,"ALUMNO");
    }
    
    public void verNotas(){
           //
    }
    
        // Menú específico para Alumno con bucle persistente
    public void mostrarMenuAlumno() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("---- Menu Alumno ----");
            System.out.println("1. Informacion Personal");
            System.out.println("2. Ver notas");
            System.out.println("3. Ver asistencias");
            System.out.println("4. Ver pagos");
            System.out.println("5. Ver comunicados");
            System.out.println("6. Ver horarios");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1 -> System.out.println("Funcionalidad de ver informacion personal.");
                case 2 -> System.out.println("Funcionalidad de ver notas.");
                case 3 -> System.out.println("Funcionalidad de ver asistencias.");
                case 4 -> System.out.println("Funcionalidad de ver pagos");
                case 5 -> System.out.println("Funcionalidad de ver comunicados");
                case 6 -> System.out.println("Funcionalidad de horarios");
                case 7 -> System.out.println("Saliendo del menú Alumno...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 7);  // Repetir el menú hasta que se elija la opción de salir
    }
    
    public void verPagos(){
        //
    }
    
    public void verHorarios(){
        //
    }
    
    public void mostrarInfo(){
        //
    }
    
    public void verAsistencia(){
        //
    }
    
    public void verComunicados(){
        //
    }
    
    
    
    
}
