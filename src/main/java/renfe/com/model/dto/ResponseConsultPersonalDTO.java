package renfe.com.model.dto;

import java.util.List;

import renfe.com.dto.DataGetExpedientesPersonaListDTO;
import renfe.com.dto.GetActasActivasPersonaDTO;
import renfe.com.dto.GetActasNoActivasPersonaDTO;
import renfe.com.dto.GetCertPsicPersonaInactivosListDTO;
import renfe.com.dto.GetDatosAcreditacionesDTO;
import renfe.com.dto.GetFormacionComplementariaPersonaListResultDTO;

import renfe.com.dto.GetTituloConPersonaUltimoDTO;


public class ResponseConsultPersonalDTO {

	private List<Tbasg100PersonaDto> getpersona;
	private List<Tbasg100PersonaDto> getDiasILT;
	private List<Tbasg102TituloconDto> getTituloConPersonaUltimo;
	private List<Tbasg101CertpsicDto> getCertPsicWithMaxFchaRec;
	private List<Tbasg152PersempDto> getPersonaEmpresa;
	private List<GetCertPsicPersonaInactivosListDTO> getCertPsicPersonaInactivosList;
	private List<GetDatosAcreditacionesDTO> getDatosAcreditaciones;
	private List<GetFormacionComplementariaPersonaListResultDTO> getFormacionComplementariaPersonaListResult;
	private List<GetActasActivasPersonaDTO> getActasActivasPersona;
	private List<GetActasNoActivasPersonaDTO> getActasNoActivasPersona;
	private List<DataGetExpedientesPersonaListDTO> getExpedientesPersonaList;
	private ResponseLoadCombosDTO responseLoadCombosDTO;

	public List<Tbasg100PersonaDto> getGetpersona() {
		return getpersona;
	}

	public void setGetpersona(List<Tbasg100PersonaDto> getpersona) {
		this.getpersona = getpersona;
	}

	public List<Tbasg100PersonaDto> getGetDiasILT() {
		return getDiasILT;
	}

	public void setGetDiasILT(List<Tbasg100PersonaDto> getDiasILT) {
		this.getDiasILT = getDiasILT;
	}

	public List<Tbasg102TituloconDto> getGetTituloConPersonaUltimo() {
		return getTituloConPersonaUltimo;
	}

	public void setGetTituloConPersonaUltimo(List<Tbasg102TituloconDto> getTituloConPersonaUltimo) {
		this.getTituloConPersonaUltimo = getTituloConPersonaUltimo;
	}

	public List<Tbasg101CertpsicDto> getGetCertPsicWithMaxFchaRec() {
		return getCertPsicWithMaxFchaRec;
	}

	public void setGetCertPsicWithMaxFchaRec(List<Tbasg101CertpsicDto> getCertPsicWithMaxFchaRec) {
		this.getCertPsicWithMaxFchaRec = getCertPsicWithMaxFchaRec;
	}

	public List<Tbasg152PersempDto> getGetPersonaEmpresa() {
		return getPersonaEmpresa;
	}

	public void setGetPersonaEmpresa(List<Tbasg152PersempDto> getPersonaEmpresa) {
		this.getPersonaEmpresa = getPersonaEmpresa;
	}

	public ResponseLoadCombosDTO getResponseLoadCombosDTO() {
		return responseLoadCombosDTO;
	}

	public void setResponseLoadCombosDTO(ResponseLoadCombosDTO responseLoadCombosDTO) {
		this.responseLoadCombosDTO = responseLoadCombosDTO;
	}

	public List<GetCertPsicPersonaInactivosListDTO> getGetCertPsicPersonaInactivosList() {
		return getCertPsicPersonaInactivosList;
	}

	public void setGetCertPsicPersonaInactivosList(
			List<GetCertPsicPersonaInactivosListDTO> getCertPsicPersonaInactivosList) {
		this.getCertPsicPersonaInactivosList = getCertPsicPersonaInactivosList;
	}

	public List<GetDatosAcreditacionesDTO> getGetDatosAcreditaciones() {
		return getDatosAcreditaciones;
	}

	public void setGetDatosAcreditaciones(List<GetDatosAcreditacionesDTO> getDatosAcreditaciones) {
		this.getDatosAcreditaciones = getDatosAcreditaciones;
	}

	public List<GetFormacionComplementariaPersonaListResultDTO> getGetFormacionComplementariaPersonaListResult() {
		return getFormacionComplementariaPersonaListResult;
	}

	public void setGetFormacionComplementariaPersonaListResult(
			List<GetFormacionComplementariaPersonaListResultDTO> getFormacionComplementariaPersonaListResult) {
		this.getFormacionComplementariaPersonaListResult = getFormacionComplementariaPersonaListResult;
	}

	public List<GetActasActivasPersonaDTO> getGetActasActivasPersona() {
		return getActasActivasPersona;
	}

	public void setGetActasActivasPersona(List<GetActasActivasPersonaDTO> getActasActivasPersona) {
		this.getActasActivasPersona = getActasActivasPersona;
	}

	public List<GetActasNoActivasPersonaDTO> getGetActasNoActivasPersona() {
		return getActasNoActivasPersona;
	}

	public void setGetActasNoActivasPersona(List<GetActasNoActivasPersonaDTO> getActasNoActivasPersona) {
		this.getActasNoActivasPersona = getActasNoActivasPersona;
	}

	public List<DataGetExpedientesPersonaListDTO> getGetExpedientesPersonaList() {
		return getExpedientesPersonaList;
	}

	public void setGetExpedientesPersonaList(List<DataGetExpedientesPersonaListDTO> getExpedientesPersonaList) {
		this.getExpedientesPersonaList = getExpedientesPersonaList;
	}

}
