package renfe.com.dto;

public class GetDocOrdenSuspDatoDTO {

	private Object cdgoReferenciaDoc;
	private Object cdgoClave;
	private Object valor;
	private Object usuAct;
	private Object fchaAct;
	private Object activo;

	public Object getCdgoReferenciaDoc() {
		return cdgoReferenciaDoc;
	}

	public void setCdgoReferenciaDoc(Object cdgoReferenciaDoc) {
		this.cdgoReferenciaDoc = cdgoReferenciaDoc;
	}

	public Object getCdgoClave() {
		return cdgoClave;
	}

	public void setCdgoClave(Object cdgoClave) {
		this.cdgoClave = cdgoClave;
	}

	public Object getValor() {
		return valor;
	}

	public void setValor(Object valor) {
		this.valor = valor;
	}

	public Object getUsuAct() {
		return usuAct;
	}

	public void setUsuAct(Object usuAct) {
		this.usuAct = usuAct;
	}

	public Object getFchaAct() {
		return fchaAct;
	}

	public void setFchaAct(Object fchaAct) {
		this.fchaAct = fchaAct;
	}

	public Object getActivo() {
		return activo;
	}

	public void setActivo(Object activo) {
		this.activo = activo;
	}

}
