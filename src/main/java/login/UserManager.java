/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ALEJANDRO
 */
public class UserManager {
    private static final String ARCHIVO = "usuarios.dat";
    private List<User> usuarios;

    public UserManager() {
        usuarios = new ArrayList<>();
        cargarUsuarios();
        
        // Si no hay usuarios en el archivo, crear uno por defecto
        if (usuarios.isEmpty()) {
            // Crear un usuario por defecto (DNI: 12345678, pass: 12345678)
            User usuarioPorDefecto = new User("12345678", "Admin", "Default", true);
            usuarios.add(usuarioPorDefecto);
            guardarUsuarios();
            //System.out.println("Usuario por defecto creado: DNI: 12345678, Pass: 12345678");
        }
    }

    // Método para agregar un usuario a la lista
    public void agregarUsuario(User user) {
        usuarios.add(user);
        guardarUsuarios();
    }

    // Método para obtener todos los usuarios
    public List<User> obtenerUsuarios() {
        return usuarios;
    }

    // Método para guardar la lista de usuarios en un archivo
    public void guardarUsuarios() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(usuarios);
            System.out.println("Usuarios guardados correctamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar los usuarios: " + e.getMessage());
        }
    }

    // Método para cargar la lista de usuarios desde un archivo
    public void cargarUsuarios() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            usuarios = (List<User>) ois.readObject();
            System.out.println("Usuarios cargados correctamente.");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado, iniciando con lista vacía.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar los usuarios: " + e.getMessage());
        }
    }

    // Método para buscar un usuario por DNI
    public User buscarUsuarioPorDni(String dni) {
        for (User user : usuarios) {
            if (user.getDni().equals(dni)) {
                return user;
            }
        }
        return null;
    }

    // Método para editar un usuario
    public void editarUsuario(String dni, String nuevoTelefono) {
        User user = buscarUsuarioPorDni(dni);
        if (user != null) {
            user.setTelefono(nuevoTelefono);
            guardarUsuarios(); // Guardar los cambios en el archivo
            System.out.println("Usuario editado correctamente.");
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }
    
    
    public User validarLogin(String usuario, String contraseña) {
        for (User user : usuarios) {
            if (user.validarCredenciales(usuario, contraseña)) {
                return user;
            }
        }
        return null;
    }
}