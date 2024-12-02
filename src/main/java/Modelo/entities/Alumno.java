package Modelo.entities;
public class Alumno extends Usuario{
    private String grado;
    private String seccion;
    private int salon_id;
    private int alumno_id;

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public void setSalon_id(int salon_id) {
        this.salon_id = salon_id;
    }

    public int getSalon_id() {
        return salon_id;
    }

    public String getGrado() {
        return grado;
    }

    public int getAlumno_id() {
        return alumno_id;
    }

    public void setAlumno_id(int alumno_id) {
        this.alumno_id = alumno_id;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }
    public String getNombreCompleto(){
        return this.getNombre() + " " + this.getApellido();
    }
}
