package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg163GcFiltroTramoDto;
import renfe.com.model.entity.Tbasg163GcFiltroTramo;

public interface Tbasg163GcFiltroTramoService {

	public List<Tbasg163GcFiltroTramoDto> getAllTbasg163GcFiltroTramo(Tbasg163GcFiltroTramoDto filter);

	public Tbasg163GcFiltroTramoDto findByCdgoFiltroTramo(Integer cdgoFiltroTramo);

	public Tbasg163GcFiltroTramoDto createTbasg163GcFiltroTramo(Tbasg163GcFiltroTramoDto tbasg163GcFiltroTramoDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg163GcFiltroTramoDto updateTbasg163GcFiltroTramo(Integer cdgoFiltroTramo,
			Tbasg163GcFiltroTramoDto tbasg163GcFiltroTramoDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg163GcFiltroTramo(Integer cdgoFiltroTramo);

	public List<Tbasg163GcFiltroTramoDto> findByCdgoFiltroTramoIn(List<Integer> cdgoFiltroTramo);

	public List<Tbasg163GcFiltroTramoDto> getGcFiltrosTramoListActive(String cdgoConsulta);

	public List<Tbasg163GcFiltroTramoDto> getGcFiltroTramo(String cdgoFiltroTramo);

	public int insertGcFiltroTramo(Tbasg163GcFiltroTramo bean);

	public int deleteGcFiltrosTramo(Tbasg163GcFiltroTramo bean);

}
