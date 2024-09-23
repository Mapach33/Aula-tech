/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;
import java.util.Scanner;
/**
 *
 * @author Alejandro
 */

public class Login {
    public static void main(String[] args){
        UserManager gestorUsuarios = new UserManager();
        Scanner scanner = new Scanner(System.in);

        // LOGIN
        boolean autenticado = false;
        User usuarioActual = null;

        while (!autenticado) {
            System.out.println("=== LOGIN ===");
            System.out.print("Usuario (DNI): ");
            String usuario = scanner.nextLine();
            System.out.print("Contraseña (DNI): ");
            String contraseña = scanner.nextLine();

            usuarioActual = gestorUsuarios.validarLogin(usuario, contraseña);
            if (usuarioActual != null) {
                System.out.println("Login exitoso. Bienvenido, " + usuarioActual.getNombre());
                autenticado = true;
            } else {
                System.out.println("Usuario o contraseña incorrectos. Intenta nuevamente.");
            }
        }

        // MENÚ UNA VEZ LOGUEADO
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n=== Menú Principal ===");
            System.out.println("1. Agregar usuario");
            System.out.println("2. Ver usuarios");
            System.out.println("3. Editar usuario");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Agregar un nuevo usuario
                    System.out.print("DNI: ");
                    scanner.nextLine();  // limpiar el buffer
                    String dni = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Es administrador (true/false): ");
                    boolean esAdmin = scanner.nextBoolean();

                    User nuevoUsuario = new User(dni, nombre, apellido, esAdmin);
                    gestorUsuarios.agregarUsuario(nuevoUsuario);
                    break;

                case 2:
                    // Ver todos los usuarios
                    for (User user : gestorUsuarios.obtenerUsuarios()) {
                        System.out.println("DNI: " + user.getDni() + ", Nombre: " + user.getNombre() + ", Admin: " + user.isAdministrador());
                    }
                    break;

                case 3:
                    // Editar un usuario
                    System.out.print("DNI del usuario a editar: ");
                    scanner.nextLine();  // limpiar el buffer
                    String dniEditar = scanner.nextLine();
                    System.out.print("Nuevo teléfono: ");
                    String nuevoTelefono = scanner.nextLine();
                    gestorUsuarios.buscarUsuarioPorDni(dniEditar).setTelefono(nuevoTelefono);
                    gestorUsuarios.guardarUsuarios();
                    System.out.println("Usuario editado correctamente.");
                    break;

                case 4:
                    // Salir
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }
}
