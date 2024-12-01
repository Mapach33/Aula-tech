package Modelo.entities;

public class Profesor extends Usuario{
    private int profesor_id;
    private String nombre_curso;

    public int getProfesor_id() {
        return profesor_id;
    }

    public String getNombre_curso() {
        return nombre_curso;
    }

    public void setProfesor_id(int profesor_id) {
        this.profesor_id = profesor_id;
    }

    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }
}
