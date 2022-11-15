package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG183_BAJA_ESTACION")
public class Tbasg183BajaEstacion {

	@EmbeddedId
	private Tbasg183BajaEstacionPK tbasg183bajaestacionpk;

	@NotNull
	@Column(name = "DESG_SOPORTEDOC")
	private String desgSoportedoc;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	public Tbasg183BajaEstacionPK getTbasg183bajaestacionpk() {
		return this.tbasg183bajaestacionpk;
	}

	public void setTbasg183bajaestacionpk(Tbasg183BajaEstacionPK tbasg183bajaestacionpk) {
		this.tbasg183bajaestacionpk = tbasg183bajaestacionpk;
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