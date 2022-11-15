package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg162GcFiltroDto;
import renfe.com.model.entity.Tbasg162GcFiltro;

public interface Tbasg162GcFiltroService {

	public List<Tbasg162GcFiltroDto> getAllTbasg162GcFiltro(Tbasg162GcFiltroDto filter);

	public Tbasg162GcFiltroDto findByCdgoFiltro(Integer cdgoFiltro);

	public Tbasg162GcFiltroDto createTbasg162GcFiltro(Tbasg162GcFiltroDto tbasg162GcFiltroDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg162GcFiltroDto updateTbasg162GcFiltro(Integer cdgoFiltro, Tbasg162GcFiltroDto tbasg162GcFiltroDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg162GcFiltro(Integer cdgoFiltro);

	public List<Tbasg162GcFiltroDto> findByCdgoFiltroIn(List<Integer> cdgoFiltro);

	public List<Tbasg162GcFiltroDto> getGcFiltrosListActive(String cdgoConsulta);

	public List<Tbasg162GcFiltroDto> getGcFiltrosList(String cdgoConsulta);

	public List<Tbasg162GcFiltroDto> getGcFiltro(String cdgoFiltro);

	public int insertGcFiltro(Tbasg162GcFiltro bean);

	public int updateGcFiltro(Tbasg162GcFiltro bean);

	public int deleteGcFiltroLogico(Tbasg162GcFiltro bean);

	public int deleteGcFiltrosConsulta(Tbasg162GcFiltro bean);

}
