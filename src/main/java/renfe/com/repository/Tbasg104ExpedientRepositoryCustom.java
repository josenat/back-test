package renfe.com.repository;

import java.util.List;

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

public interface Tbasg104ExpedientRepositoryCustom {

	public List<Tbasg104Expedient> getTramosPersona(String cdgoPersona, String cdgoEmpresa, String cdgoTipohab,
			String cdgoEntorno);

	public List<Tbasg104Expedient> getTramosPersonaSinTramo(String cdgoPersona, String cdgoEmpresa, String cdgoTipohab,
			String cdgoEntorno);

	public List<Tbasg104Expedient> getFchaProxRevList(String cdgoExpedient);

	public List<Tbasg104Expedient> getFchaProxCursoList(String cdgoExpedient);

	public List<Tbasg104Expedient> getPreviousEstadoExpList(String cdgoExpedient);

	public List<Tbasg104Expedient> getExpPersonaObject(String cdgoExpedient);

	public List<Tbasg104Expedient> getHistoricosEstadosExp(String cdgoExpedient);

	public List<Tbasg104Expedient> getMaqByLineasEstacionesList(/** FIXME revisar tipo */
	Object cdgoLinea);

	public List<Tbasg104Expedient> getCdgoPersonaByExp(Integer cdgoExpedient);

	public List<GetExpByCdgoPersonaAndCdgoExpedientDTO> getExpByCdgoPersonaAndCdgoExpedient(Integer cdgoPersona, Integer cdgoExpediente);
	
	public List<Tbasg104Expedient> getExpediente(Integer cdgoExpedient);

	public List<Tbasg104Expedient> getExpedientesByCdgoExp(List<Integer> cdgoExpedient);

	public List<Tbasg104Expedient> getExpedientesPersona(String cdgoPersona);

	public List<Tbasg104Expedient> getExpedientesPersonaTodo(String cdgoPersona);

	public List<DataGetExpedientesPersonaListDTO> getExpedientesPersonaList(ParamExpedientesPersonaListDTO filtro);
	
	public List<DataGetExpedientesPersonaListDTO> getExpedientesFiltro(ParamExpedientesPersonaListDTO filtro);

	public List<Tbasg104Expedient> getExpedientesPersonaListCount(String cdgoPersona);

	public int getExistHabilitacion(Tbasg104ExpedientDto bean);

	public List<GetExpedientesPersonaDTO> getExpedientesPersonaParam(GetExpedientesPersonaParam filter);

	public List<GetExpedientesPersonaLtDTO> getExpedientesPersonaListCod(String cdgoPersona, Integer cdgoEstado);

	public List<GetExpedientesPersonaLtDTO> getExpedientesPersonaListCodUserBaja(String cdgoPersona);

	public List<Tbasg104Expedient> findExpedientByCdgoPersonaAndTipoHab(String cdgoPersona, List<Integer>listaCodigosHab);

	public List<GetFindFchaExpedienteOtorgadoParaAotDTO> findFchaExpedienteParaAOT(Integer cdgoPersona, Integer cdgoTipohab,
			Integer cdgoAlcanceot);

	public List<GetFindFchaExpedienteOtorgadoParaAotDTO> findFchaExpedienteOtorgadoParaAOT(Integer cdgoPersona, Integer cdgoTipohab,
			Integer cdgoAlcanceot);

	public List<GetfindFchaHabilitacionParaAotDTO> findFchaHabilitacionParaAOT(Integer cdgoExpedient);

	public List<Tbasg104Expedient> findExpedientByCdgoPersonaAndLinea(String cdgoPersona, String cdgoTipohab);

	public List<Tbasg104Expedient> getObservaExt(String cdgoPersona);

	public int insertExpediente(Tbasg104ExpedientDto bean);
	
	public int updateExpedientExt(String descObservaExt, String descObserva, Character marcaActivo, String descUsuact, Integer cdgoPersona, Integer cdgoExpediente);

	public int updateExpedient(Tbasg104ExpedientDto bean);

	public int updateExpedientMantenimiento(Tbasg104Expedient bean);

	public int updateExpedientB(Tbasg104Expedient bean);

	public int deleteExpedient(Tbasg104Expedient bean);
	
	public int updateEmpresaExpedient(Tbasg104Expedient bean);
	
	public List<Tbasg104Expedient> getMaxEstadoExpListCount();

	public List<Tbasg104Expedient> getMaxEstadoExpCount();
	
	public List<GetFechaFinValidezDTO> getFechaFinValidez(Integer cdgoExpedient);
	
	public List<GetFechaFinValidezDTO> getFechaFinValidez2(Integer cdgoExpedient);
	
	public List<GetFechaFinValidezDTO> getFechaFinValidez3(Integer cdgoExpedient);

	public List<GetEstadoListDTO> getEstadoList(SetMaxEstadoHabilitaList mapPending);
	
	public List<GetExpeTipoValidezReciclajeDTO> getExpeTipoValidezReciclaje(Integer cdgoExpedient);

}
