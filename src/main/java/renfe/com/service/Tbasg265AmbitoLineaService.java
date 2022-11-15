package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg265AmbitoLineaDto;
import renfe.com.model.entity.Tbasg265AmbitoLinea;

public interface Tbasg265AmbitoLineaService {

	public List<Tbasg265AmbitoLineaDto> getAllTbasg265AmbitoLinea(Tbasg265AmbitoLineaDto filter);

	public Tbasg265AmbitoLineaDto findByCdgoLinea(String cdgoLinea);

	public Tbasg265AmbitoLineaDto createTbasg265AmbitoLinea(Tbasg265AmbitoLineaDto tbasg265AmbitoLineaDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg265AmbitoLineaDto updateTbasg265AmbitoLinea(String cdgoLinea,
			Tbasg265AmbitoLineaDto tbasg265AmbitoLineaDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg265AmbitoLinea(String cdgoLinea);

	public List<Tbasg265AmbitoLineaDto> findByCdgoLineaIn(List<String> cdgoLinea);

	public List<Tbasg265AmbitoLineaDto> getListaAmbitoLineasActiv();

	public List<Tbasg265AmbitoLineaDto> getDescTipoAmbitoLineas(String cdgoLinea);

	public List<Tbasg265AmbitoLineaDto> getAmbitoLineaCount();

	public List<Tbasg265AmbitoLineaDto> getMaxAmbitoLinea();

	public List<Tbasg265AmbitoLineaDto> getAmbitoLineaListAscendente();
	
	public List<Tbasg265AmbitoLineaDto> getCdgoLineaAutoInc();

	public List<Tbasg265AmbitoLineaDto> getAmbitoLineaListDescendente();

	public List<Tbasg265AmbitoLineaDto> getAmbitoLinea(String cdgoLinea);

	public List<Tbasg265AmbitoLineaDto> getAmbitoLineaByNombre(String desgLinea);

	public List<Tbasg265AmbitoLineaDto> getAmbitoLineaListActive();

	public int insertAmbitoLinea(Tbasg265AmbitoLinea bean);

	public int updateAmbitoLinea(Tbasg265AmbitoLinea bean);
	
	public int estadoAmbitoLinea(Tbasg265AmbitoLinea bean);

}
