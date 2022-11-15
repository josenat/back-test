package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.List;

import com.renfe.webservicesoap.GetInfoHabilitacionResponse;

import renfe.com.dto.DataGetExpedientesPersonaListDTO;
import renfe.com.dto.GetEstadoListDTO;
import renfe.com.dto.GetExpByCdgoPersonaAndCdgoExpedientDTO;
import renfe.com.dto.GetExpeTipoValidezReciclajeDTO;
import renfe.com.dto.GetExpedientesPersonaDTO;
import renfe.com.dto.GetExpedientesPersonaLtDTO;
import renfe.com.dto.GetExpedientesPersonaParam;
import renfe.com.dto.GetFechaFinValidezDTO;
import renfe.com.dto.GetFindFchaExpedienteOtorgadoParaAotDTO;
import renfe.com.dto.GetfindFchaHabilitacionParaAotDTO;
import renfe.com.dto.ParamExpedientesPersonaListDTO;
import renfe.com.dto.SetMaxEstadoHabilitaList;
import renfe.com.model.dto.Tbasg104ExpedientDto;
import renfe.com.model.entity.Tbasg104Expedient;


public interface Tbasg104ExpedientService {

	public List<Tbasg104ExpedientDto> getAllTbasg104Expedient(Tbasg104ExpedientDto filter);

	public Tbasg104ExpedientDto findByCdgoExpedient(Integer cdgoExpedient);

	public Tbasg104ExpedientDto createTbasg104Expedient(Tbasg104ExpedientDto tbasg104ExpedientDto) throws IllegalAccessException, InvocationTargetException;

	public Tbasg104ExpedientDto updateTbasg104Expedient(Integer cdgoExpedient, Tbasg104ExpedientDto tbasg104ExpedientDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg104Expedient(Integer cdgoExpedient);

	public List<Tbasg104ExpedientDto> findByCdgoExpedientIn(List<Integer> cdgoExpedient);

	public List<Tbasg104ExpedientDto> getTramosPersona(String cdgoPersona, String cdgoEmpresa, String cdgoTipohab,
			String cdgoEntorno);

	public List<Tbasg104ExpedientDto> getTramosPersonaSinTramo(String cdgoPersona, String cdgoEmpresa,
			String cdgoTipohab, String cdgoEntorno);

	public List<Tbasg104ExpedientDto> getFchaProxRevList(String cdgoExpedient);

	public List<Tbasg104ExpedientDto> getFchaProxCursoList(String cdgoExpedient);

	public List<Tbasg104ExpedientDto> getPreviousEstadoExpList(String cdgoExpedient);

	public List<Tbasg104ExpedientDto> getHistoricosEstadosExp(String cdgoExpedient);

	public List<Tbasg104ExpedientDto> getMaqByLineasEstacionesList(/** FIXME revisar tipo */
	Object cdgoLinea);
	
	public List<Tbasg104ExpedientDto> getCdgoPersonaByExp(Integer cdgoExpedient);

	public List<Tbasg104ExpedientDto> getExpediente(Integer cdgoExpedient);

	public List<Tbasg104ExpedientDto> getExpedientesByCdgoExp(List<Integer> cdgoExpedient);

	public List<Tbasg104ExpedientDto> getExpedientesPersona(String cdgoPersona);

	public List<Tbasg104ExpedientDto> getExpedientesPersonaTodo(String cdgoPersona);

	public List<DataGetExpedientesPersonaListDTO> getExpedientesPersonaList(ParamExpedientesPersonaListDTO filtro);
	
	public List<DataGetExpedientesPersonaListDTO> getExpedientesFiltro(ParamExpedientesPersonaListDTO filtro);

	public List<Tbasg104ExpedientDto> getExpedientesPersonaListCount(String cdgoPersona);

	public int getExistHabilitacion(Tbasg104ExpedientDto bean);

	public List<GetExpedientesPersonaDTO> getExpedientesPersonaParam(GetExpedientesPersonaParam filter);

	public List<GetExpedientesPersonaLtDTO> getExpedientesPersonaListCod(String cdgoPersona, Integer cdgoEstado);

	public List<GetExpedientesPersonaLtDTO> getExpedientesPersonaListCodUserBaja(String cdgoPersona);

	public List<Tbasg104ExpedientDto> findExpedientByCdgoPersonaAndTipoHab(String cdgoPersona, List<Integer>listaCodigosHab);

	public List<GetFindFchaExpedienteOtorgadoParaAotDTO> findFchaExpedienteParaAOT(Integer cdgoPersona, Integer cdgoTipohab,
			Integer cdgoAlcanceot);

	public List<GetFindFchaExpedienteOtorgadoParaAotDTO> findFchaExpedienteOtorgadoParaAOT(Integer cdgoPersona, Integer cdgoTipohab,
			Integer cdgoAlcanceot);

	public List<GetfindFchaHabilitacionParaAotDTO> findFchaHabilitacionParaAOT(Integer cdgoExpedient);

	public List<Tbasg104ExpedientDto> findExpedientByCdgoPersonaAndLinea(String cdgoPersona, String cdgoTipohab);

	public List<Tbasg104ExpedientDto> getObservaExt(String cdgoPersona);

	public int updateExpedientExt(String descObservaExt, String descObserva, Character marcaActivo, String descUsuact, Integer cdgoPersona, Integer cdgoExpediente); 
	
	public int insertExpediente(Tbasg104ExpedientDto bean);

	public int updateExpedient(Tbasg104ExpedientDto bean);

	public int updateExpedientMantenimiento(Tbasg104Expedient bean);

	public int updateExpedientB(Tbasg104Expedient bean);

	public int deleteExpedient(Tbasg104Expedient bean);
	
	public int updateEmpresaExpedient(Tbasg104Expedient bean);

	public List<Tbasg104ExpedientDto> getMaxEstadoExpListCount();

	public List<Tbasg104ExpedientDto> getMaxEstadoExpCount();
	
	public List<GetFechaFinValidezDTO> getFechaFinValidez(Integer cdgoExpedient);
	
	public List<GetFechaFinValidezDTO> getFechaFinValidez2(Integer cdgoExpedient);
	
	public List<GetFechaFinValidezDTO> getFechaFinValidez3(Integer cdgoExpedient);

	public List<Tbasg104ExpedientDto> getExpPersonaObject(String cdgoExpedient);
	
	public List<GetExpeTipoValidezReciclajeDTO> getExpeTipoValidezReciclaje(Integer cdgoExpedient);

	public List<Tbasg104ExpedientDto> getEstadoList(String cdgoExpedient, String cdgoEstado, String cdgoEstado_1,
			String cdgoEstado_2, String cdgoEstado_3, String cdgoEstado_4, String cdgoEstado_5, String cdgoEstado_6,
			String cdgoEstado_7, String cdgoEstado_8, String cdgoEstado_9);
	
	public Object getCertificadoComplementarioActionDoExecute(String codPersona) throws Exception;

	public Object getCertificadoComplementarioActionbyMatricula(String idMatricula) throws Exception;

	public Object getCertificadoComplementarioAOTActionDoExecute(Integer codPersona) throws Exception; 
	
	public Object GetHabilitacionEstadoActionDoExecute(String codPersona, Integer codEstado) throws Exception;

	public List<GetExpByCdgoPersonaAndCdgoExpedientDTO> getExpByCdgoPersonaAndCdgoExpedient(Integer cdgoPersona, Integer cdgoExpediente);

	public GetInfoHabilitacionResponse getInfoHabilitacionAction(int tipoId, String id, Boolean indActaPsico, Boolean indActaForm,
																 Boolean indHistoric, BigInteger codTipoHabil, String tipoInfra, String codAlcanceHab, BigInteger codEstado) throws Exception;

	public List<GetEstadoListDTO> getEstadoList(SetMaxEstadoHabilitaList mapPending);
}
