package renfe.com.dto;

import java.util.List;

public class ParamCountGetTramos {
	
	private List<Integer> listaExpedientes;
	private String codLinea;
	private String codEstacOrigen;
	private String codEstacDestino;
	
	public List<Integer> getListaExpedientes() {
		return listaExpedientes;
	}
	public void setListaExpedientes(List<Integer> listaExpedientes) {
		this.listaExpedientes = listaExpedientes;
	}
	public String getCodLinea() {
		return codLinea;
	}
	public void setCodLinea(String codLinea) {
		this.codLinea = codLinea;
	}
	public String getCodEstacOrigen() {
		return codEstacOrigen;
	}
	public void setCodEstacOrigen(String codEstacOrigen) {
		this.codEstacOrigen = codEstacOrigen;
	}
	public String getCodEstacDestino() {
		return codEstacDestino;
	}
	public void setCodEstacDestino(String codEstacDestino) {
		this.codEstacDestino = codEstacDestino;
	}
	
	
}
