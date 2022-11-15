package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG205_ERR_CENT")
public class Tbasg205ErrCent {

	@Id
	@Column(name = "CDGO_ERROR")
	private Long cdgoError;

	@Column(name = "CDGO_ARETER")
	private Integer cdgoAreter;

	@Column(name = "CDGO_CENTCONT")
	private Integer cdgoCentcont;

	@Column(name = "DESG_ERROR")
	private String desgError;

	@Column(name = "DESG_FICHERO")
	private String desgFichero;

	@Column(name = "DESG_NOMBRE")
	private String desgNombre;

	@Column(name = "DESG_USUACT")
	private String desgUsuact;

	@Column(name = "FCHA_ACT")
	private Date fchaAct;

	@NotNull
	@Column(name = "FCHA_ERROR")
	private Date fchaError;

	@Column(name = "MRCA_ACTIVO")
	private String mrcaActivo;

	public Long getCdgoError() {
		return this.cdgoError;
	}

	public void setCdgoError(Long cdgoError) {
		this.cdgoError = cdgoError;
	}

	public Integer getCdgoAreter() {
		return this.cdgoAreter;
	}

	public Integer getCdgoCentcont() {
		return this.cdgoCentcont;
	}

	public String getDesgError() {
		return this.desgError;
	}

	public String getDesgFichero() {
		return this.desgFichero;
	}

	public String getDesgNombre() {
		return this.desgNombre;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public Date getFchaError() {
		return this.fchaError;
	}

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setCdgoAreter(Integer cdgoAreter) {
		this.cdgoAreter = cdgoAreter;
	}

	public void setCdgoCentcont(Integer cdgoCentcont) {
		this.cdgoCentcont = cdgoCentcont;
	}

	public void setDesgError(String desgError) {
		this.desgError = desgError;
	}

	public void setDesgFichero(String desgFichero) {
		this.desgFichero = desgFichero;
	}

	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public void setFchaError(Date fchaError) {
		this.fchaError = fchaError;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

}