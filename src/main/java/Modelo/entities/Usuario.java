package Modelo.entities;

public class Usuario {
    private String nombre;
    private String apellido;
    private String email;
    private String contraseña;
    private String dni;
    private String username;
    private String tipo;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getDni() {
        return dni;
    }

    public String getUsername() {
        return username;
    }
    
}
//cambio//