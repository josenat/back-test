package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.List;

import org.json.simple.JSONObject;

import renfe.com.dto.GetActasActivasPersonaDTO;
import renfe.com.dto.GetActasNoActivasPersonaDTO;
import renfe.com.dto.GetDatosPersonaAcreditaDTO;
import renfe.com.dto.GetExpStatusFilterParametersDTO;
import renfe.com.dto.GetFechaProxRecicTitConDTO;
import renfe.com.dto.GetFechaProxRecicTitConNoMarcaDTO;
import renfe.com.dto.GetFindPersonaAltasBajasDTO;
import renfe.com.dto.GetMaxEstadoExpListDTO;
import renfe.com.dto.GetMaxEstadoHabilitaListDTO;
import renfe.com.dto.GetMaxEstadoProxRevListDTO;
import renfe.com.dto.GetPerByEstadoListResultDTO;
import renfe.com.dto.GetPersonaCertificadosIdiomasListDTO;
import renfe.com.dto.GetPersonaEmpresaInformeDTO;
import renfe.com.dto.GetPersonaEstadoListDTO;
import renfe.com.dto.GetTituloConListAuxDTO;
import renfe.com.dto.SetExpedientesPersonaListDTO;
import renfe.com.dto.SetMaxEstadoHabilitaList;
import renfe.com.dto.SetPersonaCertificadosIdiomasList;
import renfe.com.dto.SetPersonaEstadoList;
import renfe.com.dto.setMaxEstadoProxRevList;
import renfe.com.model.dto.ActasPersonaDto;
import renfe.com.model.dto.RequisitosMinimosDto;
import renfe.com.model.dto.Tbasg100PersonaDto;
import renfe.com.model.dto.Tbasg905OrganizationChartDto;
import renfe.com.model.entity.Tbasg100Persona;

public interface Tbasg100PersonaService {

	public List<Tbasg100PersonaDto> getAllTbasg100Persona(Tbasg100PersonaDto filter);

	public Tbasg100PersonaDto findByCdgoPersona(Integer cdgoPersona);

	public Tbasg100PersonaDto createTbasg100Persona(Tbasg100PersonaDto tbasg100PersonaDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg100PersonaDto updateTbasg100Persona(Integer cdgoPersona, Tbasg100PersonaDto tbasg100PersonaDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg100Persona(Integer cdgoPersona);

	public List<Tbasg100PersonaDto> findByCdgoPersonaIn(List<Integer> cdgoPersona);

	public List<Tbasg100PersonaDto> getAcreditacionesCaducadas();

	public List<ActasPersonaDto> getActasPersona(String cdgoPersona);

	public List<Tbasg100PersonaDto> getActasPersonaOrderByCdgoActaForm(String cdgoPersona);

	public List<GetActasActivasPersonaDTO> getActasActivasPersona(String cdgoPersona);

	public List<GetActasNoActivasPersonaDTO> getActasNoActivasPersona(String cdgoPersona);

	public List<Tbasg100PersonaDto> getExaminForName(String desgApell1);

	public List<Tbasg100PersonaDto> getReportList();

	public List<GetPerByEstadoListResultDTO> getPerByEstadoList();

	public List<Tbasg100PersonaDto> getReportHistoricoList();

	public List<Tbasg100PersonaDto> getMaqByTramosList();

	public List<GetTituloConListAuxDTO> getTituloConListAux(Integer cdgoPersona);

	public List<GetFechaProxRecicTitConDTO> getFechaProxRecicTitCon(String cdgoPersona);

	public List<GetFechaProxRecicTitConDTO> getFechaProxRecicTitConByMatricula(String idMatricula);

	public List<GetFechaProxRecicTitConNoMarcaDTO> getFechaProxRecicTitConNoMarca(String cdgoPersona);

	public List<GetFechaProxRecicTitConNoMarcaDTO> getFechaProxRecicTitConNoMarcaS(String cdgoPersona);

	public List<Tbasg100PersonaDto> getPersonaExaminador(String cdgoNif);

	public List<Tbasg100PersonaDto> getPersonaInstructor(String cdgoNif);

	public List<GetPersonaEstadoListDTO> getPersonaEstadoList(SetPersonaEstadoList mapPending);

	public List<Tbasg100PersonaDto> getMaxEstadoHabilitaCount();

	public List<Tbasg100PersonaDto> getMaxEstadoProxRevListCount(); 
	
	public List<GetMaxEstadoHabilitaListDTO> getMaxEstadoHabilitaList(SetMaxEstadoHabilitaList mapPending);

	public List<GetPersonaCertificadosIdiomasListDTO> getPersonaCertificadosIdiomasList(SetPersonaCertificadosIdiomasList mapPending);

	public List<Tbasg100PersonaDto> getPersonaAllList(SetExpedientesPersonaListDTO filter);

	public List<Tbasg100PersonaDto> getPersonaBySociedadesList();

	public List<Tbasg100PersonaDto> getPersona(String cdgoPersona);

	public List<Tbasg100PersonaDto> findPersonaByMatricula(String desgMatricula);

	public List<Tbasg100PersonaDto> findPersonaByNifPas(String desgNifpas);

	public List<Tbasg100PersonaDto> getPersonaByMatricula(String idMatricula);

	public List<Tbasg100PersonaDto> geCdgoPersona(String desgNifpas);
	
	public List<Tbasg100PersonaDto> getCertpsicCdgoPersona(Integer cdgoPersona);

	public List<Tbasg100PersonaDto> getDiasILT(String cdgoPersona);

	public List<Tbasg100PersonaDto> getCdgoPersonaMatricula(String desgMatricula);

	public List<Tbasg100PersonaDto> existePersonaDNI(String desgNifpas);

	public List<Tbasg100PersonaDto> existePersonaRENFEDNI(String desgNifpas);

	public List<GetFindPersonaAltasBajasDTO> findPersonaAltas(List<Integer> codigos, String fecDesde, String fecHasta);

	public List<GetFindPersonaAltasBajasDTO> findPersonaBajas(List<Integer> codigos, String fecDesde, String fecHasta);

	public List<GetDatosPersonaAcreditaDTO> getDatosPersonaAcredita(Integer cdgoPersona);

	public List<Tbasg100PersonaDto> getPersonaFormador(String desgNifpas);

	public List<Tbasg100PersonaDto> getDni(String desgMatricula);

	public int insertPersona(Tbasg100Persona bean);

	public int updatePersonalAct(Tbasg100Persona bean);

	public int updatePersonaMantenimiento(Tbasg100Persona bean);

	public int deletePersona(Tbasg100Persona bean);

	public int updateReqMinimosPersonaAct(RequisitosMinimosDto bean);

	public List<GetPersonaEmpresaInformeDTO> getPersonaEmpresaInforme(Integer cdgoPersona);

	public List<Tbasg100PersonaDto> getTituloConList(String cdgoEstado, String cdgoEstado_1, String cdgoEstado_2,
			String cdgoEstado_3, String cdgoEstado_4);

	public List<Tbasg100PersonaDto> getTituloConListCount(String cdgoEstado, String cdgoEstado_1, String cdgoEstado_2,
			String cdgoEstado_3, String cdgoEstado_4);

	public List<Tbasg100PersonaDto> getTituloConListCountPorEstado(String cdgoEstado, String cdgoEstado_1,
			String cdgoEstado_2, String cdgoEstado_3, String cdgoEstado_4);

	public static Tbasg100PersonaDto entityToDto(Tbasg100Persona entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<GetMaxEstadoProxRevListDTO> getMaxEstadoProxRevList(setMaxEstadoProxRevList mapPending);

	public List<GetMaxEstadoExpListDTO> getMaxEstadoExpList(GetExpStatusFilterParametersDTO filter);
	
	public JSONObject getLeerJson(String tabla);

	public Object getPdfAltasBajasFicheroRefDoExecute(List<Integer> codigos, String fecDesde, String fecHasta, String alta, String baja) throws Exception;	

	public List<Tbasg905OrganizationChartDto> getOrganizationalChart(Integer level, Integer id);

	public int updateRevisionStatus(List<List<String>> expedientCodeList);
}
