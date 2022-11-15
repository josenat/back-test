package renfe.com.repository;

import java.util.List;

import renfe.com.dto.CountGetTramosDTO;
import renfe.com.dto.GetEstadosMasExpDTO;
import renfe.com.dto.GetFechaExpFiltradaDTO;
import renfe.com.dto.GetFechaOtorgamientoDTO;
import renfe.com.dto.GetMaxEntornosExpCodListDTO;
import renfe.com.dto.GetMaxEntornosExpListCodigosDTO;
import renfe.com.dto.GetMaxEstaHabInListDTO;
import renfe.com.dto.GetTramoListByCdgoExpDTO;
import renfe.com.dto.GetTramosOrderByCodLineaDTO;
import renfe.com.dto.ParamCountGetTramos;
import renfe.com.model.dto.GetExpedientesPersonaCursoListDTO;

import renfe.com.model.entity.Tbasg118Estadoexp;

public interface Tbasg118EstadoexpRepositoryCustom {

	public List<Tbasg118Estadoexp> getTramosExpInfr(String cdgoExpedient);

	public List<Tbasg118Estadoexp> getTramosExpInfrWithOutState(String cdgoExpedient);

	public List<GetMaxEstaHabInListDTO> getMaxEstaHabInList(String cdgoExpedient);

	public List<Tbasg118Estadoexp> findEstadoExpByCdgoExp(String cdgoExpedient);

	public List<Tbasg118Estadoexp> findFechaSuspensionReactivacionExpByCdgoExp(String cdgoExpedient);

	public List<Tbasg118Estadoexp> findTodosEstadosExpsSuspSancionByCdgoExp(Integer cdgoExpediente);
	
	public List<GetEstadosMasExpDTO> getEstadosMasExp(String cdgoExpedient);


	public List<Tbasg118Estadoexp> getEstadosExp(String cdgoExpedient);

	public List<Tbasg118Estadoexp> getEstadosExpMaxFecha(String cdgoExpedient);

	public List<Tbasg118Estadoexp> getEstadosExpsMaxFecha(List expedientes);

	public List<Tbasg118Estadoexp> getEstadosExpMaxFechaTodo(String cdgoExpedient);

	public List<Tbasg118Estadoexp> getEstadosExpsTodosMaxFecha();

	public List<Tbasg118Estadoexp> getEstadoExpList();

	public int insertEstadoExp(Integer cdgoExpediente, Integer cdgoEstado, String desgUsuact, String mrcaActivo);

	public int updateEstadoExpediente(Tbasg118Estadoexp bean);

	public List<GetExpedientesPersonaCursoListDTO> getExpedientesPersonaCursoList();

	public List<GetMaxEntornosExpListCodigosDTO> getMaxEntornosExpListCodigos(String cdgoExpedient);

	public List<GetMaxEntornosExpCodListDTO> getMaxEntornosExpCodList(Integer cdgoExpediente, Integer cdgoEstado);

	public List<GetFechaOtorgamientoDTO> getFechaOtorgamiento(Integer cdgoExpedient);

	public List<GetTramoListByCdgoExpDTO> getTramoListByCdgoExp(Integer cdgoExpedient);

	public List<Tbasg118Estadoexp> getFechasOtorgamiento(List<Integer> cdgoExpedient);

	public List<GetFechaExpFiltradaDTO> getFechaExpFiltrada(String cdgoPersona);
	
	public List<GetTramosOrderByCodLineaDTO> getTramosOrderByCodLinea(List<Integer> cdgoExpedient);
	
	public List<GetTramosOrderByCodLineaDTO> getFechasOtorgamientoPB(List<Integer> cdgoExpedient);
	
	public List<CountGetTramosDTO> countGetTramos(ParamCountGetTramos filtro);

}
