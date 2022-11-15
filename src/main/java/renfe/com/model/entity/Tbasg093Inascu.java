package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBASG093_INASCU")
public class Tbasg093Inascu {

	@Id
	@Column(name = "T093_IDHABILI")
	private Long t093Idhabili;

	@Column(name = "T093_CODCUR")
	private String t093Codcur;

	@Column(name = "T093_FECCARGA")
	private Date t093Feccarga;

	@Column(name = "T093_NOMBRE")
	private String t093Nombre;

	@Column(name = "T093_NOMCUR")
	private String t093Nomcur;

	@Column(name = "T093_USUCARGA")
	private String t093Usucarga;

	public Long getT093Idhabili() {
		return this.t093Idhabili;
	}

	public void setT093Idhabili(Long t093Idhabili) {
		this.t093Idhabili = t093Idhabili;
	}

	public String getT093Codcur() {
		return this.t093Codcur;
	}

	public Date getT093Feccarga() {
		return this.t093Feccarga;
	}

	public String getT093Nombre() {
		return this.t093Nombre;
	}

	public String getT093Nomcur() {
		return this.t093Nomcur;
	}

	public String getT093Usucarga() {
		return this.t093Usucarga;
	}

	public void setT093Codcur(String t093Codcur) {
		this.t093Codcur = t093Codcur;
	}

	public void setT093Feccarga(Date t093Feccarga) {
		this.t093Feccarga = t093Feccarga;
	}

	public void setT093Nombre(String t093Nombre) {
		this.t093Nombre = t093Nombre;
	}

	public void setT093Nomcur(String t093Nomcur) {
		this.t093Nomcur = t093Nomcur;
	}

	public void setT093Usucarga(String t093Usucarga) {
		this.t093Usucarga = t093Usucarga;
	}

}