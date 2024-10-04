
package Controlador;

import Modelo.Admin;
import Modelo.Login;
import static Modelo.Login.existeUsuarioAdmin;
import Modelo.User;
/**
 *
 * @author MATHIAS
 */
public class Main {
    
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
}
