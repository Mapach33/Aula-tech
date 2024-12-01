package Modelo.entities;
public class Alumno extends Usuario{
    private String nombre_salon;
    private int id_alumno;

    public String getNombre_salon() {
        return nombre_salon;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public void setNombre_salon(String nombre_salon) {
        this.nombre_salon = nombre_salon;
    }
}
