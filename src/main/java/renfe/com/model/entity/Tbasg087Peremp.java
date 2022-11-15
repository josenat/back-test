package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG087_PEREMP")
public class Tbasg087Peremp {

	@Id
	@Column(name = "T087_IDPEREMP")
	private Long t087Idperemp;

	@Column(name = "T087_BLACTIVO")
	private String t087Blactivo;

	@Column(name = "T087_FECULTACT")
	private Date t087Fecultact;

	@NotNull
	@Column(name = "T087_IDEMPRES")
	private Integer t087Idempres;

	@NotNull
	@Column(name = "T087_IDPERSON")
	private Integer t087Idperson;

	@Column(name = "T087_USUULTACT")
	private String t087Usuultact;

	public Long getT087Idperemp() {
		return this.t087Idperemp;
	}

	public void setT087Idperemp(Long t087Idperemp) {
		this.t087Idperemp = t087Idperemp;
	}

	public String getT087Blactivo() {
		return this.t087Blactivo;
	}

	public Date getT087Fecultact() {
		return this.t087Fecultact;
	}

	public Integer getT087Idempres() {
		return this.t087Idempres;
	}

	public Integer getT087Idperson() {
		return this.t087Idperson;
	}

	public String getT087Usuultact() {
		return this.t087Usuultact;
	}

	public void setT087Blactivo(String t087Blactivo) {
		this.t087Blactivo = t087Blactivo;
	}

	public void setT087Fecultact(Date t087Fecultact) {
		this.t087Fecultact = t087Fecultact;
	}

	public void setT087Idempres(Integer t087Idempres) {
		this.t087Idempres = t087Idempres;
	}

	public void setT087Idperson(Integer t087Idperson) {
		this.t087Idperson = t087Idperson;
	}

	public void setT087Usuultact(String t087Usuultact) {
		this.t087Usuultact = t087Usuultact;
	}

}