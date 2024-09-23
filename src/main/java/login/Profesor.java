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
public class Profesor extends User{
    
    public Profesor(String dni, String nombre, String apellido, String email) {
        super(dni, nombre, apellido, email,"PROFESOR");
    }
    
    public void infoPersonal(){
        //
    }
    
       // Menú específico para Profesor con bucle persistente
    public void mostrarMenuProfesor() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("---- Menu Profesor ----");
            System.out.println("1. Informacion personal");
            System.out.println("2. Modificar notas");
            System.out.println("3. Tomar asistencia");
            System.out.println("4. Publicar comunicado");
            System.out.println("5. Modificar horario");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1 -> System.out.println("Funcionalidad de ver clases.");
                case 2 -> System.out.println("Funcionalidad de evaluar alumnos.");
                case 3 -> System.out.println("Funcionalidad de evaluar alumnos.");
                case 4 -> System.out.println("Funcionalidad de evaluar alumnos.");
                case 5 -> System.out.println("Funcionalidad de evaluar alumnos.");
                case 6 -> System.out.println("Saliendo del menú Profesor...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 6);  // Repetir el menú hasta que se elija la opción de salir
    }
    
    public void modificarNotas(){
        //
    }
    
    public void asistencia(){
        //
    }
    
    public void postComunicado(){
        //
    }
    
    public void modificarHorario(){
        //
    }
}
