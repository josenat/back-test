package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG173_DATO_PLANT_DOC")
public class Tbasg173DatoPlantDoc {

	@EmbeddedId
	private Tbasg173DatoPlantDocPK tbasg173datoplantdocpk;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@NotNull
	@Column(name = "DESG_VALOR")
	private String desgValor;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	public Tbasg173DatoPlantDocPK getTbasg173datoplantdocpk() {
		return this.tbasg173datoplantdocpk;
	}

	public void setTbasg173datoplantdocpk(Tbasg173DatoPlantDocPK tbasg173datoplantdocpk) {
		this.tbasg173datoplantdocpk = tbasg173datoplantdocpk;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public String getDesgValor() {
		return this.desgValor;
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

	public void setDesgValor(String desgValor) {
		this.desgValor = desgValor;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

}