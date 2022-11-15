package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg117EstadotitDto;
import renfe.com.model.entity.Tbasg117Estadotit;

public interface Tbasg117EstadotitService {

	public List<Tbasg117EstadotitDto> getAllTbasg117Estadotit(Tbasg117EstadotitDto filter);

	public Tbasg117EstadotitDto findByCdgoEstadoCdgoTitFchaEstado(Integer cdgoEstado, Integer cdgoTit,
			String fchaEstado);

	public Tbasg117EstadotitDto createTbasg117Estadotit(Tbasg117EstadotitDto tbasg117EstadotitDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg117EstadotitDto updateTbasg117Estadotit(Integer cdgoEstado, Integer cdgoTit, String fchaEstado,
			Tbasg117EstadotitDto tbasg117EstadotitDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg117Estadotit(Integer cdgoEstado, Integer cdgoTit, String fchaEstado);

	public List<Tbasg117EstadotitDto> findByCdgoEstadoCdgoTitFchaEstadoIn(List<Integer> cdgoEstado,
			List<Integer> cdgoTit, List<String> fchaEstado);

	public List<Tbasg117EstadotitDto> findEstadoTitByCdgoTit(String cdgoTit);

	public List<Tbasg117EstadotitDto> getEstadoTitList();

	public List<Tbasg117EstadotitDto> getEstadoTitUltimo(String cdgoTit);

	public List<Tbasg117EstadotitDto> getEstadoTit(String cdgoTit);

	public List<Tbasg117EstadotitDto> existeEstadoTit(String cdgoTit, String cdgoEstado);

	public int insertEstadoTit(Tbasg117Estadotit bean);

	public int insertEstadoTitSinFecha(Tbasg117Estadotit bean);

	public int updateEstadoTit(Tbasg117Estadotit bean);

	public int desactivateEstadoTit(Tbasg117Estadotit bean);

}
