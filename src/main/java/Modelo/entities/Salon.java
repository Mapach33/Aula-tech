package Modelo.entities;

public class Salon {
    private int id;
    private String nombre;
    private String seccion;
    private String grado;
    private String capacidad;

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGrado() {
        return grado;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }
}
