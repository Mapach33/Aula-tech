/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Alejandro
 */

public class Login {
     
    private String filePath;  // Ruta del archivo que contiene los usuarios

    public Login(String filePath) {
        this.filePath = filePath;
    }

    // Método para iniciar sesión con bucle persistente
    public User iniciarSesion() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Solicitar credenciales
            System.out.println("B I E N V E N I D O  A  A U L A - T E C H");
            System.out.print("Ingrese su usuario: ");
            String userInput = scanner.nextLine();
            System.out.print("Ingrese su contraseña: ");
            String passwordInput = scanner.nextLine();

            // Validar credenciales
            User usuario = validarCredenciales(userInput, passwordInput);
            if (usuario != null) {
                return usuario;  // Si es exitoso, retornar el usuario logueado
            }

            // Si las credenciales no son correctas, preguntar si desea reintentar o salir
            System.out.println("Usuario o contraseña incorrectos.");
            System.out.print("¿Desea intentar de nuevo? (s/n): ");
            String opcion = scanner.nextLine();

            if (opcion.equalsIgnoreCase("n")) {
                System.out.println("Saliendo...");
                return null;  // Salir del programa si elige "n"
            }
        }
    }

    // Método para validar las credenciales y devolver el objeto User correspondiente
    private User validarCredenciales(String userInput, String passwordInput) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Separar los campos por coma
                String[] fields = line.split(",");

                // Extraer el user y pass desde el archivo
                String user = fields[4];  // Campo del user
                String pass = fields[5];  // Campo del pass
                String rol = fields[6];   // Campo del rol (Admin, Profesor, Alumno)

                // Validar credenciales
                if (user.equals(userInput) && pass.equals(passwordInput)) {
                    // Según el rol, devolver la instancia correcta
                    switch (rol) {
                        case "ADMIN" -> {
                            return new Admin(fields[0], fields[1], fields[2], fields[3]); // DNI, Nombre, Apellido, Email
                        }
                        case "PROFESOR" -> {
                            return new Profesor(fields[0], fields[1], fields[2], fields[3]); // Campo vacío para Materia, puede llenarse según lo necesites
                        }
                        case "ALUMNO" -> {
                            return new Alumno(fields[0], fields[1], fields[2], fields[3]); // Campo vacío para Curso, puede llenarse según lo necesites
                        }
                        default -> {
                            System.out.println("Rol no reconocido.");
                            return null;
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        // Si no se encontraron credenciales válidas
        return null;
    }

    // Método para mostrar el menú según el rol del usuario logueado
    public void mostrarMenu(User user) {
        if (user instanceof Admin admin) {
            admin.mostrarMenuAdmin();
        } else if (user instanceof Profesor profesor) {
            profesor.mostrarMenuProfesor();
        } else if (user instanceof Alumno alumno) {
            alumno.mostrarMenuAlumno();
        }
    }


    // Método para verificar si el usuario administrador ya está registrado
    public static boolean existeUsuarioAdmin(String filePath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] fields = line.split(",");
                String user = fields[4];  // Campo del user

                if (user.equals("admin")) {
                    return true;  // Usuario admin ya existe
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return false;
    }

}
