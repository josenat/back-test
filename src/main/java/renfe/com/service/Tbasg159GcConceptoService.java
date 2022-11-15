package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg159GcConceptoDto;

public interface Tbasg159GcConceptoService {

	public List<Tbasg159GcConceptoDto> getAllTbasg159GcConcepto(Tbasg159GcConceptoDto filter);

	public Tbasg159GcConceptoDto findByCdgoCategoriaCdgoConcepto(String cdgoCategoria, String cdgoConcepto);

	public Tbasg159GcConceptoDto createTbasg159GcConcepto(Tbasg159GcConceptoDto tbasg159GcConceptoDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg159GcConceptoDto updateTbasg159GcConcepto(String cdgoCategoria, String cdgoConcepto,
			Tbasg159GcConceptoDto tbasg159GcConceptoDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg159GcConcepto(String cdgoCategoria, String cdgoConcepto);

	public List<Tbasg159GcConceptoDto> findByCdgoCategoriaCdgoConceptoIn(List<String> cdgoCategoria,
			List<String> cdgoConcepto);

	public List<Tbasg159GcConceptoDto> getGcConceptosActiveList();

}
