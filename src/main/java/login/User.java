/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;
import java.io.Serializable;
/**
 *
 * @author Alejandro
 */
public class User implements Serializable {
    private String nombre;
    private String apellido;
    private String dni;
    private String user;
    private String pass;
    private String telefono;
    private boolean administrador;
    
    //Constructor
    public User(String _dni, String _nombre, String _apellido, boolean esAdministrador) {
        this.dni = _dni;
        user =  dni;
        pass = dni;
        nombre = _nombre;
        apellido = _apellido;
        administrador = esAdministrador;
    }
    
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
   

    
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getTelefono() {
        return telefono;
    }

    public boolean isAdministrador() {
        return administrador;
    }
    public boolean validarCredenciales(String usuario, String contraseña) {
        return this.user.equals(usuario) && this.pass.equals(contraseña);
    }
    
}
