package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG128_ESTACLINE", schema = "PASG")
public class Tbasg128Estacline {

	@EmbeddedId
	private Tbasg128EstaclinePK tbasg128estaclinepk;

	@NotNull
	@Column(name = "CDGO_ORDEN")
	private Integer cdgoOrden;

	@NotNull
	@Column(name = "CDGO_PK")
	private String cdgoPk;

	@NotNull
	@Column(name = "DESG_NOMCORTO")
	private String desgNomcorto;

	@NotNull
	@Column(name = "DESG_NOMLARGO")
	private String desgNomlargo;

	@Column(name = "DESG_SOPORTEDOC")
	private String desgSoportedoc;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	public Tbasg128EstaclinePK getTbasg128estaclinepk() {
		return this.tbasg128estaclinepk;
	}

	public void setTbasg128estaclinepk(Tbasg128EstaclinePK tbasg128estaclinepk) {
		this.tbasg128estaclinepk = tbasg128estaclinepk;
	}

	public Integer getCdgoOrden() {
		return this.cdgoOrden;
	}

	public String getCdgoPk() {
		return this.cdgoPk;
	}

	public String getDesgNomcorto() {
		return this.desgNomcorto;
	}

	public String getDesgNomlargo() {
		return this.desgNomlargo;
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

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setCdgoOrden(Integer cdgoOrden) {
		this.cdgoOrden = cdgoOrden;
	}

	public void setCdgoPk(String cdgoPk) {
		this.cdgoPk = cdgoPk;
	}

	public void setDesgNomcorto(String desgNomcorto) {
		this.desgNomcorto = desgNomcorto;
	}

	public void setDesgNomlargo(String desgNomlargo) {
		this.desgNomlargo = desgNomlargo;
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

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

}