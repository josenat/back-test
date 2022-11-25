package renfe.com.repository;

import java.sql.Date;
import java.util.List;

import org.json.simple.JSONObject;

import renfe.com.dto.GetMaxEstadoHabilitaListDTO;
import renfe.com.dto.GetMaxEstadoProxRevListDTO;

import renfe.com.dto.GetActasActivasPersonaDTO;
import renfe.com.dto.GetActasNoActivasPersonaDTO;
import renfe.com.dto.GetDatosPersonaAcreditaDTO;
import renfe.com.dto.GetExpStatusFilterParametersDTO;
import renfe.com.dto.GetMaxEstadoExpListDTO;

import renfe.com.dto.GetFechaProxRecicTitConDTO;
import renfe.com.dto.GetFechaProxRecicTitConNoMarcaDTO;
import renfe.com.dto.GetFindPersonaAltasBajasDTO;

import renfe.com.dto.GetPerByEstadoListResultDTO;

import renfe.com.dto.SetExpedientesPersonaListDTO;


import renfe.com.dto.GetPersonaCertificadosIdiomasListDTO;
import renfe.com.dto.GetPersonaEmpresaInformeDTO;
import renfe.com.dto.GetPersonaEstadoListDTO;

import renfe.com.dto.GetTituloConListAuxDTO;
import renfe.com.dto.SetMaxEstadoHabilitaList;
import renfe.com.dto.SetPersonaCertificadosIdiomasList;
import renfe.com.dto.SetPersonaEstadoList;
import renfe.com.dto.setMaxEstadoProxRevList;
import renfe.com.model.dto.ActasPersonaDto;
import renfe.com.model.dto.RequisitosMinimosDto;
import renfe.com.model.dto.Tbasg100PersonaDto;
import renfe.com.model.dto.Tbasg905OrganizationChartDto;
import renfe.com.model.entity.Tbasg100Persona;

public interface Tbasg100PersonaRepositoryCustom {

	public List<Tbasg100Persona> getAcreditacionesCaducadas();

	public List<ActasPersonaDto> getActasPersona(String cdgoPersona);

	public List<Tbasg100Persona> getActasPersonaOrderByCdgoActaForm(String cdgoPersona);

	public List<GetActasActivasPersonaDTO> getActasActivasPersona(String cdgoPersona);

	public List<GetActasNoActivasPersonaDTO> getActasNoActivasPersona(String cdgoPersona);

	public List<Tbasg100Persona> getExaminForName(String desgApell1);

	public List<Tbasg100Persona> getReportList();

	public List<GetPerByEstadoListResultDTO> getPerByEstadoList();

	public List<Tbasg100Persona> getReportHistoricoList();

	public List<Tbasg100Persona> getMaqByTramosList();

	public List<GetTituloConListAuxDTO> getTituloConListAux(Integer cdgoPersona);

	public List<GetFechaProxRecicTitConDTO> getFechaProxRecicTitCon(String cdgoPersona);

	public List<GetFechaProxRecicTitConDTO> getFechaProxRecicTitConByMatricula(String idMatricula);

	public List<GetFechaProxRecicTitConNoMarcaDTO> getFechaProxRecicTitConNoMarca(String cdgoPersona);

	public List<GetFechaProxRecicTitConNoMarcaDTO> getFechaProxRecicTitConNoMarcaS(String cdgoPersona);

	public List<Tbasg100Persona> getPersonaExaminador(String cdgoNif);

	public List<Tbasg100Persona> getPersonaInstructor(String cdgoNif);

	public List<GetPersonaEstadoListDTO> getPersonaEstadoList(SetPersonaEstadoList mapPending);
	
	public List<GetMaxEstadoHabilitaListDTO> getMaxEstadoHabilitaList(SetMaxEstadoHabilitaList mapPending);

	public List<Tbasg100Persona> getMaxEstadoHabilitaCount();

	public List<Tbasg100Persona> getMaxEstadoProxRevListCount();
	
	public List<GetMaxEstadoProxRevListDTO> getMaxEstadoProxRevList(setMaxEstadoProxRevList mapPending);

	public List<GetPersonaCertificadosIdiomasListDTO> getPersonaCertificadosIdiomasList(SetPersonaCertificadosIdiomasList mapPending);

	public List<Tbasg100Persona> getPersonaAllList(SetExpedientesPersonaListDTO filter);

	public List<Tbasg100Persona> getPersonaBySociedadesList();

	public List<Tbasg100Persona> getPersona(String cdgoPersona);

	public List<Tbasg100Persona> findPersonaByMatricula(String desgMatricula);

	public List<Tbasg100Persona> findPersonaByNifPas(String desgNifpas);

	public List<Tbasg100Persona> getPersonaByMatricula(String idMatricula);

	public List<Tbasg100Persona> geCdgoPersona(String desgNifpas);

	public List<Tbasg100Persona> getDiasILT(String cdgoPersona);

	public List<Tbasg100Persona> getCdgoPersonaMatricula(String desgMatricula);

	public List<Tbasg100Persona> existePersonaDNI(String desgNifpas);

	public List<Tbasg100Persona> existePersonaRENFEDNI(String desgNifpas);

	public List<GetFindPersonaAltasBajasDTO> findPersonaAltas(List<Integer> codigos, String fecDesde, String fecHasta);

	public List<GetFindPersonaAltasBajasDTO> findPersonaBajas(List<Integer> codigos, String fecDesde, String fecHasta);

	public List<GetDatosPersonaAcreditaDTO> getDatosPersonaAcredita(Integer cdgoPersona);

	public List<Tbasg100Persona> getPersonaFormador(String desgNifpas);

	public List<Tbasg100Persona> getDni(String desgMatricula);

	public int insertPersona(Tbasg100Persona bean);

	public int updatePersonalAct(Tbasg100Persona bean);

	public int updatePersonaMantenimiento(Tbasg100Persona bean);

	public int deletePersona(Tbasg100Persona bean);

	public int updateReqMinimosPersonaAct(RequisitosMinimosDto bean);

	public List<GetPersonaEmpresaInformeDTO> getPersonaEmpresaInforme(Integer cdgoPersona);

	public List<Tbasg100Persona> getTituloConList(String cdgoEstado, String cdgoEstado_1, String cdgoEstado_2,
			String cdgoEstado_3, String cdgoEstado_4);

	public List<Tbasg100Persona> getTituloConListCount(String cdgoEstado, String cdgoEstado_1, String cdgoEstado_2,
			String cdgoEstado_3, String cdgoEstado_4);

	public List<Tbasg100Persona> getTituloConListCountPorEstado(String cdgoEstado, String cdgoEstado_1, String cdgoEstado_2,
			String cdgoEstado_3, String cdgoEstado_4);

	public List<GetMaxEstadoExpListDTO> getMaxEstadoExpList(GetExpStatusFilterParametersDTO filter);
	
	public JSONObject getLeerJson(String tabla);

	public List<Tbasg905OrganizationChartDto> getOrganizationalChart(Integer level, String id);
	
	public int updateRevisionStatus(List<List<String>> expedientCodeList);

}
