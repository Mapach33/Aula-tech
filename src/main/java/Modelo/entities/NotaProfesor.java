package Modelo.entities;

public class NotaProfesor {
    String Apellidos;
    String Nombres;
    String notaMensual;
    String notaBimestral;
    String Promedio;

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public void setNotaMensual(String notaMensual) {
        this.notaMensual = notaMensual;
    }

    public void setNotaBimestral(String notaBimestral) {
        this.notaBimestral = notaBimestral;
    }

    public void setPromedio(String Promedio) {
        this.Promedio = Promedio;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public String getNombres() {
        return Nombres;
    }

    public String getNotaMensual() {
        return notaMensual;
    }

    public String getNotaBimestral() {
        return notaBimestral;
    }

    public String getPromedio() {
        return Promedio;
    }
    
}
