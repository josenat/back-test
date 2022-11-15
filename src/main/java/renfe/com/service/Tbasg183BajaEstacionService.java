package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg183BajaEstacionDto;
import renfe.com.model.entity.Tbasg183BajaEstacion;

public interface Tbasg183BajaEstacionService {

	public List<Tbasg183BajaEstacionDto> getAllTbasg183BajaEstacion(Tbasg183BajaEstacionDto filter);

	public Tbasg183BajaEstacionDto findByCdgoEstacionCdgoLinea(String cdgoEstacion, String cdgoLinea);

	public Tbasg183BajaEstacionDto createTbasg183BajaEstacion(Tbasg183BajaEstacionDto tbasg183BajaEstacionDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg183BajaEstacionDto updateTbasg183BajaEstacion(String cdgoEstacion, String cdgoLinea,
			Tbasg183BajaEstacionDto tbasg183BajaEstacionDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg183BajaEstacion(String cdgoEstacion, String cdgoLinea);

	public List<Tbasg183BajaEstacionDto> findByCdgoEstacionCdgoLineaIn(List<String> cdgoEstacion,
			List<String> cdgoLinea);

	public List<Tbasg183BajaEstacionDto> getBajaEstacion(String cdgoEstacion, String cdgoLinea);

	public int insertBajaEstacion(Tbasg183BajaEstacion bean);

}
