package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG084_HABCUR")
public class Tbasg084Habcur {

	@Id
	@Column(name = "T084_IDHABCUR")
	private Long t084Idhabcur;

	@Column(name = "T084_BLACTIVO")
	private String t084Blactivo;

	@Column(name = "T084_FECULTACT")
	private Date t084Fecultact;

	@NotNull
	@Column(name = "T084_IDCURSO")
	private Integer t084Idcurso;

	@NotNull
	@Column(name = "T084_IDHAB")
	private Integer t084Idhab;

	@Column(name = "T084_USUULTACT")
	private String t084Usuultact;

	public Long getT084Idhabcur() {
		return this.t084Idhabcur;
	}

	public void setT084Idhabcur(Long t084Idhabcur) {
		this.t084Idhabcur = t084Idhabcur;
	}

	public String getT084Blactivo() {
		return this.t084Blactivo;
	}

	public Date getT084Fecultact() {
		return this.t084Fecultact;
	}

	public Integer getT084Idcurso() {
		return this.t084Idcurso;
	}

	public Integer getT084Idhab() {
		return this.t084Idhab;
	}

	public String getT084Usuultact() {
		return this.t084Usuultact;
	}

	public void setT084Blactivo(String t084Blactivo) {
		this.t084Blactivo = t084Blactivo;
	}

	public void setT084Fecultact(Date t084Fecultact) {
		this.t084Fecultact = t084Fecultact;
	}

	public void setT084Idcurso(Integer t084Idcurso) {
		this.t084Idcurso = t084Idcurso;
	}

	public void setT084Idhab(Integer t084Idhab) {
		this.t084Idhab = t084Idhab;
	}

	public void setT084Usuultact(String t084Usuultact) {
		this.t084Usuultact = t084Usuultact;
	}

}