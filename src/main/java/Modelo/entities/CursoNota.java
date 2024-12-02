package Modelo.entities;

public class CursoNota {
    private String nombreCurso;
    private String notaBimestre1;
    private String notaBimestre2;
    private String notaBimestre3;
    private String notaBimestre4;
    private String notaFinal;

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public void setNotaBimestre1(String notaBimestre1) {
        this.notaBimestre1 = notaBimestre1;
    }

    public void setNotaBimestre2(String notaBimestre2) {
        this.notaBimestre2 = notaBimestre2;
    }

    public void setNotaBimestre3(String notaBimestre3) {
        this.notaBimestre3 = notaBimestre3;
    }

    public void setNotaBimestre4(String notaBimestre4) {
        this.notaBimestre4 = notaBimestre4;
    }

    public void setNotaFinal(String notaFinal) {
        this.notaFinal = notaFinal;
    }

    // Getters y setters
    public String getNombreCurso() { return nombreCurso; }
    public String getNotaBimestre1() { return notaBimestre1; }
    public String getNotaBimestre2() { return notaBimestre2; }
    public String getNotaBimestre3() { return notaBimestre3; }
    public String getNotaBimestre4() { return notaBimestre4; }
    public String getNotaFinal() { return notaFinal; }

}
