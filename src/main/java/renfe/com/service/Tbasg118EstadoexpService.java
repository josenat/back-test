package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
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

import renfe.com.model.dto.Tbasg118EstadoexpDto;
import renfe.com.model.entity.Tbasg118Estadoexp;

public interface Tbasg118EstadoexpService {

	public List<Tbasg118EstadoexpDto> getAllTbasg118Estadoexp(Tbasg118EstadoexpDto filter);

	public Tbasg118EstadoexpDto findByCdgoEstadoCdgoExpedientFchaEstado(Integer cdgoEstado, Integer cdgoExpedient,
			Date fchaEstado);

	public Tbasg118EstadoexpDto createTbasg118Estadoexp(Tbasg118EstadoexpDto tbasg118EstadoexpDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg118EstadoexpDto updateTbasg118Estadoexp(Integer cdgoEstado, Integer cdgoExpedient, Date fchaEstado,
			Tbasg118EstadoexpDto tbasg118EstadoexpDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg118Estadoexp(Integer cdgoEstado, Integer cdgoExpedient, Date fchaEstado);

	public List<Tbasg118EstadoexpDto> findByCdgoEstadoCdgoExpedientFchaEstadoIn(List<Integer> cdgoEstado,
			List<Integer> cdgoExpedient, List<Date> fchaEstado);

	public List<Tbasg118EstadoexpDto> getTramosExpInfr(String cdgoExpedient);

	public List<Tbasg118EstadoexpDto> getTramosExpInfrWithOutState(String cdgoExpedient);

	public List<GetMaxEstaHabInListDTO> getMaxEstaHabInList(String cdgoExpedient);

	public List<Tbasg118EstadoexpDto> findEstadoExpByCdgoExp(String cdgoExpedient);

	public List<Tbasg118EstadoexpDto> findFechaSuspensionReactivacionExpByCdgoExp(String cdgoExpedient);

	public List<Tbasg118EstadoexpDto> findTodosEstadosExpsSuspSancionByCdgoExp(Integer cdgoExpediente);

	public List<Tbasg118EstadoexpDto> getEstadosExp(String cdgoExpedient);

	public List<Tbasg118EstadoexpDto> getEstadosExpMaxFecha(String cdgoExpedient);

	public List<Tbasg118EstadoexpDto> getEstadosExpsMaxFecha(List codExpedientes);

	public List<Tbasg118EstadoexpDto> getEstadosExpMaxFechaTodo(String cdgoExpedient);

	public List<Tbasg118EstadoexpDto> getEstadosExpsTodosMaxFecha();

	public List<Tbasg118EstadoexpDto> getEstadoExpList();

	public int insertEstadoExp(Integer cdgoExpediente, Integer cdgoEstado, String desgUsuact, String mrcaActivo);

	public int updateEstadoExpediente(Tbasg118Estadoexp bean);

	public List<GetExpedientesPersonaCursoListDTO> getExpedientesPersonaCursoList();

	public List<GetMaxEntornosExpListCodigosDTO> getMaxEntornosExpListCodigos(String cdgoExpedient);

	public List<GetMaxEntornosExpCodListDTO> getMaxEntornosExpCodList(Integer cdgoExpediente, Integer cdgoEstado);

	public List<GetFechaOtorgamientoDTO> getFechaOtorgamiento(Integer cdgoExpedient);

	public List<GetTramoListByCdgoExpDTO> getTramoListByCdgoExp(Integer cdgoExpedient);

	public List<Tbasg118EstadoexpDto> getFechasOtorgamiento(List<Integer> cdgoExpedient);

	public List<GetFechaExpFiltradaDTO> getFechaExpFiltrada(String cdgoPersona);
	
	public List<GetTramosOrderByCodLineaDTO> getTramosOrderByCodLinea(List<Integer> cdgoExpedient);
	
	public List<GetTramosOrderByCodLineaDTO> getFechasOtorgamientoPB(List<Integer> cdgoExpedient);
	
	public List<CountGetTramosDTO> countGetTramos(ParamCountGetTramos filtro);

	public List<GetEstadosMasExpDTO> getEstadosMasExp(String cdgoExpedient);

}
