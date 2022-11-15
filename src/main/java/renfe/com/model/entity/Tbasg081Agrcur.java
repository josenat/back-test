package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG081_AGRCUR")
public class Tbasg081Agrcur {

	@Id
	@Column(name = "T081_IDAGRCUR")
	private Long t081Idagrcur;

	@Column(name = "T081_BLACTIVO")
	private String t081Blactivo;

	@Column(name = "T081_FECULTACT")
	private Date t081Fecultact;

	@NotNull
	@Column(name = "T081_IDAGRUPA")
	private Integer t081Idagrupa;

	@NotNull
	@Column(name = "T081_IDCURSO")
	private Integer t081Idcurso;

	@Column(name = "T081_USUULTACT")
	private String t081Usuultact;

	public Long getT081Idagrcur() {
		return this.t081Idagrcur;
	}

	public void setT081Idagrcur(Long t081Idagrcur) {
		this.t081Idagrcur = t081Idagrcur;
	}

	public String getT081Blactivo() {
		return this.t081Blactivo;
	}

	public Date getT081Fecultact() {
		return this.t081Fecultact;
	}

	public Integer getT081Idagrupa() {
		return this.t081Idagrupa;
	}

	public Integer getT081Idcurso() {
		return this.t081Idcurso;
	}

	public String getT081Usuultact() {
		return this.t081Usuultact;
	}

	public void setT081Blactivo(String t081Blactivo) {
		this.t081Blactivo = t081Blactivo;
	}

	public void setT081Fecultact(Date t081Fecultact) {
		this.t081Fecultact = t081Fecultact;
	}

	public void setT081Idagrupa(Integer t081Idagrupa) {
		this.t081Idagrupa = t081Idagrupa;
	}

	public void setT081Idcurso(Integer t081Idcurso) {
		this.t081Idcurso = t081Idcurso;
	}

	public void setT081Usuultact(String t081Usuultact) {
		this.t081Usuultact = t081Usuultact;
	}

}