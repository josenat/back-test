package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG019_RECHAB")
public class Tbasg019Rechab {

	@Id
	@Column(name = "T019_IDRECHAB")
	private Long t019Idrechab;

	@Column(name = "T019_BLACTIVO")
	private String t019Blactivo;

	@Column(name = "T019_FECULTACT")
	private Date t019Fecultact;

	@NotNull
	@Column(name = "T019_IDHABILI")
	private Integer t019Idhabili;

	@NotNull
	@Column(name = "T019_IDREC")
	private Integer t019Idrec;

	@Column(name = "T019_USUULTACT")
	private String t019Usuultact;

	public Long getT019Idrechab() {
		return this.t019Idrechab;
	}

	public void setT019Idrechab(Long t019Idrechab) {
		this.t019Idrechab = t019Idrechab;
	}

	public String getT019Blactivo() {
		return this.t019Blactivo;
	}

	public Date getT019Fecultact() {
		return this.t019Fecultact;
	}

	public Integer getT019Idhabili() {
		return this.t019Idhabili;
	}

	public Integer getT019Idrec() {
		return this.t019Idrec;
	}

	public String getT019Usuultact() {
		return this.t019Usuultact;
	}

	public void setT019Blactivo(String t019Blactivo) {
		this.t019Blactivo = t019Blactivo;
	}

	public void setT019Fecultact(Date t019Fecultact) {
		this.t019Fecultact = t019Fecultact;
	}

	public void setT019Idhabili(Integer t019Idhabili) {
		this.t019Idhabili = t019Idhabili;
	}

	public void setT019Idrec(Integer t019Idrec) {
		this.t019Idrec = t019Idrec;
	}

	public void setT019Usuultact(String t019Usuultact) {
		this.t019Usuultact = t019Usuultact;
	}

}