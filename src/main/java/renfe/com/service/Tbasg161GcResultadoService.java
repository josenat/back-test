package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg161GcResultadoDto;
import renfe.com.model.entity.Tbasg161GcResultado;

public interface Tbasg161GcResultadoService {

	public List<Tbasg161GcResultadoDto> getAllTbasg161GcResultado(Tbasg161GcResultadoDto filter);

	public Tbasg161GcResultadoDto findByCdgoCategoriaCdgoConceptoCdgoConsulta(String cdgoCategoria, String cdgoConcepto,
			Integer cdgoConsulta);

	public Tbasg161GcResultadoDto createTbasg161GcResultado(Tbasg161GcResultadoDto tbasg161GcResultadoDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg161GcResultadoDto updateTbasg161GcResultado(String cdgoCategoria, String cdgoConcepto,
			Integer cdgoConsulta, Tbasg161GcResultadoDto tbasg161GcResultadoDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg161GcResultado(String cdgoCategoria, String cdgoConcepto, Integer cdgoConsulta);

	public List<Tbasg161GcResultadoDto> findByCdgoCategoriaCdgoConceptoCdgoConsultaIn(List<String> cdgoCategoria,
			List<String> cdgoConcepto, List<Integer> cdgoConsulta);

	public List<Tbasg161GcResultadoDto> getGcResultadosListActive(String cdgoConsulta);

	public List<Tbasg161GcResultadoDto> getGcResultado(String cdgoConsulta, String cdgoCategoria, String cdgoConcepto);

	public int insertGcResultado(Tbasg161GcResultado bean);

	public int updateGcResultado(Tbasg161GcResultado bean);

	public int deleteGcResultadosConsulta(Tbasg161GcResultado bean);

}
