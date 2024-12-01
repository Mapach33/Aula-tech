package Modelo.entities;

public class Comunicado {
    private int cominacado_id;
    private String titulo;
    private String contenido;
    private String fecha;
    private String emisor;

    public int getCominacado_id() {
        return cominacado_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public String getFecha() {
        return fecha;
    }
    public String getEmisor() {
        return emisor;
    }
    public void setCominacado_id(int cominacado_id) {
        this.cominacado_id = cominacado_id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }
}
