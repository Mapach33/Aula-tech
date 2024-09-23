/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Alejandro
 */
public class Admin extends User {
    
    public Admin(String _dni, String _nombre, String _apellido, String _email) {
        super(_dni, _nombre, _apellido, _email,"ADMIN");
        
    }
    
    public void registrarPersona(String filePath) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---- Registro de Nueva Persona ----");
        System.out.println("Seleccione el tipo de usuario a registrar:");
        System.out.println("1. Alumno");
        System.out.println("2. Profesor");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea

        // Datos comunes para cualquier usuario
        System.out.print("Ingrese el DNI: ");
        String dni = scanner.nextLine();
        System.out.print("Ingrese el Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese el Email: ");
        String email = scanner.nextLine();

        User nuevoUsuario;

        switch (opcion) {
            case 1 -> // Registro de un Alumno
                nuevoUsuario = new Alumno(dni, nombre, apellido, email);
            case 2 -> // Registro de un Profesor
                nuevoUsuario = new Profesor(dni, nombre, apellido, email);
            default -> {
                System.out.println("Opción no válida.");
                return;  // Salir si la opción es incorrecta
            }
        }

        // Guardar el nuevo usuario en el archivo
        guardarEnArchivo(nuevoUsuario, filePath);
        System.out.println("Usuario registrado exitosamente.");
    }
    public void registrarPersona(Admin admin,String filepath){
        guardarEnArchivo(admin,filepath);
    }
    
    private void guardarEnArchivo(User usuario, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            // Escribir los datos del usuario en el archivo
            writer.write(usuario.getDni() + "," +
                         usuario.getNombre() + "," +
                         usuario.getApellido() + "," +
                         usuario.getEmail() + "," +
                         usuario.getUser() + "," +
                         usuario.getPass() + "," +
                         usuario.getRol() + "\n");
        } catch (IOException e) {
            System.out.println("Error al guardar el usuario en el archivo: " + e.getMessage());
        }
    }
    
    public void asignarAula(){
        //
    }
    
    public void modificarPago(){
        //
    }
    
    public void publicarComunicado(){
        //
    }
}
