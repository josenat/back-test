package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg182AltaEstacionDto;
import renfe.com.model.entity.Tbasg182AltaEstacion;

public interface Tbasg182AltaEstacionService {

	public List<Tbasg182AltaEstacionDto> getAllTbasg182AltaEstacion(Tbasg182AltaEstacionDto filter);

	public Tbasg182AltaEstacionDto findByCdgoEstacionCdgoLinea(String cdgoEstacion, String cdgoLinea);

	public Tbasg182AltaEstacionDto createTbasg182AltaEstacion(Tbasg182AltaEstacionDto tbasg182AltaEstacionDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg182AltaEstacionDto updateTbasg182AltaEstacion(String cdgoEstacion, String cdgoLinea,
			Tbasg182AltaEstacionDto tbasg182AltaEstacionDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg182AltaEstacion(String cdgoEstacion, String cdgoLinea);

	public List<Tbasg182AltaEstacionDto> findByCdgoEstacionCdgoLineaIn(List<String> cdgoEstacion,
			List<String> cdgoLinea);

	public List<Tbasg182AltaEstacionDto> getAltaEstacion(String cdgoEstacion, String cdgoLinea);

	public int insertAltaEstacion(Tbasg182AltaEstacion bean);

}
