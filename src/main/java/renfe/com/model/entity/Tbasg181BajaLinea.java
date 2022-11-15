package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG181_BAJA_LINEA")
public class Tbasg181BajaLinea {

	@Id
	@Column(name = "CDGO_LINEA")
	private Long cdgoLinea;

	@NotNull
	@Column(name = "DESG_SOPORTEDOC")
	private String desgSoportedoc;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	public Long getCdgoLinea() {
		return this.cdgoLinea;
	}

	public void setCdgoLinea(Long cdgoLinea) {
		this.cdgoLinea = cdgoLinea;
	}

	public String getDesgSoportedoc() {
		return this.desgSoportedoc;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public void setDesgSoportedoc(String desgSoportedoc) {
		this.desgSoportedoc = desgSoportedoc;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

}