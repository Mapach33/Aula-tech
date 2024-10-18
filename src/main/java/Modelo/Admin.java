/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Alejandro
 */
public class Admin extends User {
    private List<User> usuarios;
    private final String archivoPersonas = "data/usuarios.txt";
    private final String archivoSalones = "data/salones.txt";
    private final CrearSalones crearSalones;

    public Admin(String _dni, String _nombre, String _apellido, String _email) {
        super(_dni, _nombre, _apellido, _email,"ADMIN");
        usuarios = new ArrayList<>();  // Inicializamos la lista de usuarios
        cargarUsuariosDesdeArchivo();  // Cargamos los usuarios del archivo al iniciar
        crearSalones = new CrearSalones();
    }

    public void registrarPersona(String filePath) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---- Registro de Nueva Persona ----");
        System.out.println("Seleccione el tipo de usuario a registrar:");
        System.out.println("1. Alumno");
        System.out.println("2. Profesor");
        System.out.print("Opcion: ");
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
                System.out.println("Opcion no valida.");
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

    public void mostrarMenuAdmin() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        ListaAlumnos listaAlumnos = new ListaAlumnos();
        ListaProfesores listaProfesores = new ListaProfesores();
        do {

            System.out.println("---- Menu Admin ----");
            System.out.println("1. Gestonar Salones");
            System.out.println("2. Registrar Persona");
            System.out.println("3. Ver usuarios registrados");
            System.out.println("4. Modificar Pagos");
            System.out.println("5. Comunicados");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1 -> crearSalones.gestionarSalones(archivoSalones);
                case 2 -> registrarPersona("data/usuarios.txt");
                case 3 -> {
                    // Mostrar el submenú para elegir entre lista de alumnos o profesores
                    System.out.println("Seleccione la lista que desea ver:");
                    System.out.println("1. Lista de Alumnos");
                    System.out.println("2. Lista de Profesores");
                    System.out.print("Opcion: ");
                    int opcionLista = scanner.nextInt();
                    scanner.nextLine();  // Consumir el salto de línea
                    switch (opcionLista) {
                        case 1 -> listaAlumnos.mostrarAlumnosRegistrados(); // Llamar a la lista de alumnos
                        case 2 -> listaProfesores.mostrarProfesoresRegistrados();// Llamar a la lista de profesores
                        default -> System.out.println("Opcion no valida.");
                    }
                }
                case 4 -> System.out.println("Funcionalidad Modificar Pagos");
                case 5 -> ComunicadosManager.main(null);
                case 6 -> System.out.println("Saliendo de Aula-Tech");
                default -> System.out.println("Opcion no valida.");
            }
        } while (opcion != 6);  // Repetir el menú hasta que se elija la opción de salir
    }

    // Método para cargar los usuarios desde el archivo a la lista
    private void cargarUsuariosDesdeArchivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoPersonas))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length >= 7) {
                    //Crear un nuevo usuario basado en los datos del archivo
                    String dni = datos[0];
                    String nombre = datos[1];
                    String apellido = datos[2];
                    String email = datos[3];
                    String user = datos[4];
                    String pass = datos[5];
                    String rol = datos[6];

                    User usuario;
                    if (rol.equals("ALUMNO")) {
                        usuario = new Alumno(dni, nombre, apellido, email);
                    } else if (rol.equals("PROFESOR")) {
                        usuario = new Profesor(dni, nombre, apellido, email);
                    } else {
                        usuario = new User(dni, nombre, apellido, email, rol);
                    }

                    // Añadir el usuario a la lista
                    usuarios.add(usuario);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado, se creará uno nuevo al registrar usuarios.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }


    // Método para mostrar los usuarios registrados
    public void verUsuariosRegistrados() {
        System.out.println("---- Usuarios Registrados ----");
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            // Encabezados de la tabla
            System.out.printf("%-15s %-15s %-15s %-30s %-10s\n", "DNI", "Nombre", "Apellido", "Email", "Rol");
            System.out.println("--------------------------------------------------------------------------------------------");

            // Iterar por cada usuario y mostrar sus datos en formato tabla
            for (User usuario : usuarios) {
                System.out.printf("%-15s %-15s %-15s %-30s %-10s\n",
                        usuario.getDni(),
                        usuario.getNombre(),
                        usuario.getApellido(),
                        usuario.getEmail(),
                        usuario.getRol());
            }
        }

        // Esperar a que el usuario presione Enter para continuar
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("Presione 'Enter' para continuar...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();  // Leer la entrada del usuario (espera hasta que presione Enter)
    }

    public void modificarPago(){
        //
    }

    public void publicarComunicado(){
        //
    }
}
