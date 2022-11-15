package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG266_ESTADO_ACRE")
public class Tbasg266EstadoAcre {

	@EmbeddedId
	private Tbasg266EstadoAcrePK tbasg266estadoacrepk;

	@NotNull
	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@NotNull
	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@NotNull
	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	public Tbasg266EstadoAcrePK getTbasg266estadoacrepk() {
		return this.tbasg266estadoacrepk;
	}

	public void setTbasg266estadoacrepk(Tbasg266EstadoAcrePK tbasg266estadoacrepk) {
		this.tbasg266estadoacrepk = tbasg266estadoacrepk;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

}