package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG079_REHAPE")
public class Tbasg079Rehape {

	@Id
	@Column(name = "T079_IDREHAPE")
	private Long t079Idrehape;

	@Column(name = "T079_BLACTIVO")
	private String t079Blactivo;

	@Column(name = "T079_FECULTACT")
	private Date t079Fecultact;

	@NotNull
	@Column(name = "T079_IDPERHAB")
	private Integer t079Idperhab;

	@NotNull
	@Column(name = "T079_IDRECPER")
	private Integer t079Idrecper;

	@Column(name = "T079_USUULTACT")
	private String t079Usuultact;

	public Long getT079Idrehape() {
		return this.t079Idrehape;
	}

	public void setT079Idrehape(Long t079Idrehape) {
		this.t079Idrehape = t079Idrehape;
	}

	public String getT079Blactivo() {
		return this.t079Blactivo;
	}

	public Date getT079Fecultact() {
		return this.t079Fecultact;
	}

	public Integer getT079Idperhab() {
		return this.t079Idperhab;
	}

	public Integer getT079Idrecper() {
		return this.t079Idrecper;
	}

	public String getT079Usuultact() {
		return this.t079Usuultact;
	}

	public void setT079Blactivo(String t079Blactivo) {
		this.t079Blactivo = t079Blactivo;
	}

	public void setT079Fecultact(Date t079Fecultact) {
		this.t079Fecultact = t079Fecultact;
	}

	public void setT079Idperhab(Integer t079Idperhab) {
		this.t079Idperhab = t079Idperhab;
	}

	public void setT079Idrecper(Integer t079Idrecper) {
		this.t079Idrecper = t079Idrecper;
	}

	public void setT079Usuultact(String t079Usuultact) {
		this.t079Usuultact = t079Usuultact;
	}

}