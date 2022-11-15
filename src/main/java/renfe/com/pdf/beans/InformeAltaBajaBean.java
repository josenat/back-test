package renfe.com.pdf.beans;

import java.util.List;

import renfe.com.dto.GetFindPersonaAltasBajasDTO;

public class InformeAltaBajaBean {
	private List<GetFindPersonaAltasBajasDTO> personas;
	private String fDesde;
	private String fHasta;
	
	//Nivel de usuario generador del informa 
	private boolean RefMercancias;
	private boolean RefOperadora;
	private boolean RefViajeros;
	
	//Multiselección usuario renfe operadora
	private boolean viajeros;
	private boolean fabric;
	private boolean alquiler;
	private boolean operadora;
	private boolean mercancias;
	
	public InformeAltaBajaBean() {
	}
	
	

	/**
	 * @return Devuelve personas.
	 */
	public List<GetFindPersonaAltasBajasDTO> getPersonas() {
		return personas;
	}
	/**
	 * @param personas El personas a establecer.
	 */
	public void setPersonas(List<GetFindPersonaAltasBajasDTO> personas) {
		this.personas = personas;
	}



	public void setfDesde(String fDesde) {
		this.fDesde = fDesde;
	}



	public String getfDesde() {
		return fDesde;
	}



	public void setfHasta(String fHasta) {
		this.fHasta = fHasta;
	}



	public String getfHasta() {
		return fHasta;
	}



	public void setRefMercancias(boolean refMercancias) {
		RefMercancias = refMercancias;
	}



	public boolean isRefMercancias() {
		return RefMercancias;
	}



	public void setViajeros(boolean viajeros) {
		this.viajeros = viajeros;
	}



	public boolean isViajeros() {
		return viajeros;
	}



	public void setFabric(boolean fabric) {
		this.fabric = fabric;
	}



	public boolean isFabric() {
		return fabric;
	}



	public void setAlquiler(boolean alquiler) {
		this.alquiler = alquiler;
	}



	public boolean isAlquiler() {
		return alquiler;
	}



	public void setOperadora(boolean operadora) {
		this.operadora = operadora;
	}



	public boolean isOperadora() {
		return operadora;
	}



	public void setRefOperadora(boolean refOperadora) {
		RefOperadora = refOperadora;
	}



	public boolean isRefOperadora() {
		return RefOperadora;
	}



	public void setRefViajeros(boolean refViajeros) {
		RefViajeros = refViajeros;
	}



	public boolean isRefViajeros() {
		return RefViajeros;
	}



	public void setMercancias(boolean mercancias) {
		this.mercancias = mercancias;
	}



	public boolean isMercancias() {
		return mercancias;
	}
}
