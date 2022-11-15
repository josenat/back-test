package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG200_ERR_FICH", schema = "PASG")
public class Tbasg200ErrFich {

	@Id
	@Column(name = "CDGO_ERROR")
	private Long cdgoError;
	
	@NotNull
	@Column(name = "DESG_PROCESO")
	private String desgProceso;
	
	@NotNull
	@Column(name = "DESG_FICHERO")
	private String desgFichero;
	
	@NotNull
	@Column(name = "FCHA_ERROR")
	private Date fchaError;
	
	@Column(name = "CDGO_LINEA")
	private Integer cdgoLinea;
	
	@NotNull
	@Column(name = "DESG_ERROR")
	private String desgError;
	
	@NotNull
	@Column(name = "DESG_VALOR")
	private String desgValor;

	public Long getCdgoError() {
		return cdgoError;
	}

	public void setCdgoError(Long cdgoError) {
		this.cdgoError = cdgoError;
	}

	public String getDesgProceso() {
		return desgProceso;
	}

	public void setDesgProceso(String desgProceso) {
		this.desgProceso = desgProceso;
	}

	public String getDesgFichero() {
		return desgFichero;
	}

	public void setDesgFichero(String desgFichero) {
		this.desgFichero = desgFichero;
	}

	public Date getFchaError() {
		return fchaError;
	}

	public void setFchaError(Date fchaError) {
		this.fchaError = fchaError;
	}

	public Integer getCdgoLinea() {
		return cdgoLinea;
	}

	public void setCdgoLinea(Integer cdgoLinea) {
		this.cdgoLinea = cdgoLinea;
	}

	public String getDesgError() {
		return desgError;
	}

	public void setDesgError(String desgError) {
		this.desgError = desgError;
	}

	public String getDesgValor() {
		return desgValor;
	}

	public void setDesgValor(String desgValor) {
		this.desgValor = desgValor;
	}
	
}
