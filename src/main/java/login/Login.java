/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;
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

    public static void main(String[] args) {
        String filePath = "usuarios.txt";  // Archivo donde se guardarán los datos

        // Registrar admin si no existe ya en el archivo
        if (!existeUsuarioAdmin(filePath)) {
            // Crear un usuario admin por defecto (user: "admin", pass: "12345678")
            Admin adminDefault = new Admin("0001", "Admin", "Principal", "admin@email.com");
            adminDefault.setUser("admin");   // Usuario predefinido
            adminDefault.setPass("admin"); // Contraseña predefinida
            adminDefault.registrarPersona(adminDefault, filePath);
        }

        // Crear una instancia de la clase Login
        Login login = new Login(filePath);

        // Iniciar sesión
        User usuarioLogueado;
        do {
            usuarioLogueado = login.iniciarSesion();  // Intentar login
        } while (usuarioLogueado == null);  // Repetir si el login es incorrecto

        // Mostrar el menú dependiendo del tipo de usuario
        login.mostrarMenu(usuarioLogueado);
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
        if (user instanceof Admin) {
            ((Admin) user).mostrarMenuAdmin();
        } else if (user instanceof Profesor) {
            mostrarMenuProfesor();
        } else if (user instanceof Alumno) {
            mostrarMenuAlumno();
        }
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
