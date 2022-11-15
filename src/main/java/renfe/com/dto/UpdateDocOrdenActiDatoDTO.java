package renfe.com.dto;

public class UpdateDocOrdenActiDatoDTO {

	private String valor;
	private String usuAct;
	private Boolean activo;
	private Integer cdgoReferenciaDoc;
	private Integer cdgoClave;

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getUsuAct() {
		return usuAct;
	}

	public void setUsuAct(String usuAct) {
		this.usuAct = usuAct;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Integer getCdgoReferenciaDoc() {
		return cdgoReferenciaDoc;
	}

	public void setCdgoReferenciaDoc(Integer cdgoReferenciaDoc) {
		this.cdgoReferenciaDoc = cdgoReferenciaDoc;
	}

	public Integer getCdgoClave() {
		return cdgoClave;
	}

	public void setCdgoClave(Integer cdgoClave) {
		this.cdgoClave = cdgoClave;
	}

}
