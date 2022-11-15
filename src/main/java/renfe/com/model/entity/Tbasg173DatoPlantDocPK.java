package renfe.com.model.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides({ @AttributeOverride(name = "cdgoClave", column = @Column(name = "CDGO_CLAVE")),
		@AttributeOverride(name = "cdgoDocumento", column = @Column(name = "CDGO_DOCUMENTO")) })
public class Tbasg173DatoPlantDocPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cdgoClave;
	private Integer cdgoDocumento;

	public String getCdgoClave() {
		return this.cdgoClave;
	}

	public Integer getCdgoDocumento() {
		return this.cdgoDocumento;
	}

	public void setCdgoClave(String cdgoClave) {
		this.cdgoClave = cdgoClave;
	}

	public void setCdgoDocumento(Integer cdgoDocumento) {
		this.cdgoDocumento = cdgoDocumento;
	}

}