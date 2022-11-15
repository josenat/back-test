package renfe.com.dto;

import java.io.Serializable;
import java.sql.Date;

public class GetActaFormaDTO implements Serializable {

    private String cdgoCurso;
    private String descCurso;
    private String observa;
    private String centroFor;
    private String tipoCurso;
    private String califi;
    private String instructor;
    private Date fecCurso;
    private Integer titulo;

    public String getCdgoCurso() {
        return cdgoCurso;
    }

    public void setCdgoCurso(String cdgoCurso) {
        this.cdgoCurso = cdgoCurso;
    }

    public String getDescCurso() {
        return descCurso;
    }

    public void setDescCurso(String descCurso) {
        this.descCurso = descCurso;
    }

    public String getObserva() {
        return observa;
    }

    public void setObserva(String observa) {
        this.observa = observa;
    }

    public String getCentroFor() {
        return centroFor;
    }

    public void setCentroFor(String centroFor) {
        this.centroFor = centroFor;
    }

    public String getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(String tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

    public String getCalifi() {
        return califi;
    }

    public void setCalifi(String califi) {
        this.califi = califi;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public Date getFecCurso() {
        return fecCurso;
    }

    public void setFecCurso(Date fecCurso) {
        this.fecCurso = fecCurso;
    }

    public Integer getTitulo() {
        return titulo;
    }

    public void setTitulo(Integer titulo) {
        this.titulo = titulo;
    }
}
