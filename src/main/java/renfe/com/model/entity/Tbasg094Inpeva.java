package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBASG094_INPEVA")
public class Tbasg094Inpeva {

	@Id
	@Column(name = "T094_IDPERSON")
	private Long t094Idperson;

	@Column(name = "T094_CALIFI")
	private String t094Califi;

	@Column(name = "T094_CODCUR")
	private String t094Codcur;

	@Column(name = "T094_FECCARGA")
	private Date t094Feccarga;

	@Column(name = "T094_FHCUR")
	private Date t094Fhcur;

	@Column(name = "T094_NIF")
	private String t094Nif;

	@Column(name = "T094_USUCARGA")
	private String t094Usucarga;

	public Long getT094Idperson() {
		return this.t094Idperson;
	}

	public void setT094Idperson(Long t094Idperson) {
		this.t094Idperson = t094Idperson;
	}

	public String getT094Califi() {
		return this.t094Califi;
	}

	public String getT094Codcur() {
		return this.t094Codcur;
	}

	public Date getT094Feccarga() {
		return this.t094Feccarga;
	}

	public Date getT094Fhcur() {
		return this.t094Fhcur;
	}

	public String getT094Nif() {
		return this.t094Nif;
	}

	public String getT094Usucarga() {
		return this.t094Usucarga;
	}

	public void setT094Califi(String t094Califi) {
		this.t094Califi = t094Califi;
	}

	public void setT094Codcur(String t094Codcur) {
		this.t094Codcur = t094Codcur;
	}

	public void setT094Feccarga(Date t094Feccarga) {
		this.t094Feccarga = t094Feccarga;
	}

	public void setT094Fhcur(Date t094Fhcur) {
		this.t094Fhcur = t094Fhcur;
	}

	public void setT094Nif(String t094Nif) {
		this.t094Nif = t094Nif;
	}

	public void setT094Usucarga(String t094Usucarga) {
		this.t094Usucarga = t094Usucarga;
	}

}