package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG082_HACUPE")
public class Tbasg082Hacupe {

	@Id
	@Column(name = "T082_IDHACUPE")
	private Long t082Idhacupe;

	@Column(name = "T082_BLACTIVO")
	private String t082Blactivo;

	@Column(name = "T082_FECULTACT")
	private Date t082Fecultact;

	@NotNull
	@Column(name = "T082_IDCURPER")
	private Integer t082Idcurper;

	@NotNull
	@Column(name = "T082_IDPERHAB")
	private Integer t082Idperhab;

	@Column(name = "T082_USUULTACT")
	private String t082Usuultact;

	public Long getT082Idhacupe() {
		return this.t082Idhacupe;
	}

	public void setT082Idhacupe(Long t082Idhacupe) {
		this.t082Idhacupe = t082Idhacupe;
	}

	public String getT082Blactivo() {
		return this.t082Blactivo;
	}

	public Date getT082Fecultact() {
		return this.t082Fecultact;
	}

	public Integer getT082Idcurper() {
		return this.t082Idcurper;
	}

	public Integer getT082Idperhab() {
		return this.t082Idperhab;
	}

	public String getT082Usuultact() {
		return this.t082Usuultact;
	}

	public void setT082Blactivo(String t082Blactivo) {
		this.t082Blactivo = t082Blactivo;
	}

	public void setT082Fecultact(Date t082Fecultact) {
		this.t082Fecultact = t082Fecultact;
	}

	public void setT082Idcurper(Integer t082Idcurper) {
		this.t082Idcurper = t082Idcurper;
	}

	public void setT082Idperhab(Integer t082Idperhab) {
		this.t082Idperhab = t082Idperhab;
	}

	public void setT082Usuultact(String t082Usuultact) {
		this.t082Usuultact = t082Usuultact;
	}

}