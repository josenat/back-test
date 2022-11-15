package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.dto.GetCentHgadoListAscendenteDTO;
import renfe.com.model.dto.Tbasg143CenthgadoDto;
import renfe.com.model.entity.Tbasg143Centhgado;

public interface Tbasg143CenthgadoService {

	public List<Tbasg143CenthgadoDto> getAllTbasg143Centhgado(Tbasg143CenthgadoDto filter);

	public Tbasg143CenthgadoDto findByCdgoCenthgado(Integer cdgoCenthgado);

	public Tbasg143CenthgadoDto createTbasg143Centhgado(Tbasg143CenthgadoDto tbasg143CenthgadoDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg143CenthgadoDto updateTbasg143Centhgado(Integer cdgoCenthgado,
			Tbasg143CenthgadoDto tbasg143CenthgadoDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg143Centhgado(Integer cdgoCenthgado);

	public List<Tbasg143CenthgadoDto> findByCdgoCenthgadoIn(List<Integer> cdgoCenthgado);

	public List<Tbasg143CenthgadoDto> getCentHgado(String cdgoCenthgado);

	public List<Tbasg143CenthgadoDto> getActiveCentHgado(String cdgoCenthgado);

	public List<Tbasg143CenthgadoDto> getCentHgadoByCIF(String desgCif);

	public List<Tbasg143CenthgadoDto> getCentHgadoCount();

	public List<Tbasg143CenthgadoDto> findByCdgoCentFor(String cdgoCentrofor);

	public List<Tbasg143CenthgadoDto> findByCdgoCentMed(String cdgoCenmed);

	public List<GetCentHgadoListAscendenteDTO> getCentHgadoListAscendente();

	public List<Tbasg143CenthgadoDto> getCentHgadoListDescendente();

	public List<Tbasg143CenthgadoDto> getCentHgadoActiveListAscendente();

	public int insertCentHgado(Tbasg143Centhgado bean);

	public int updateCentHgado(Tbasg143Centhgado bean);
	
	public int estadoCentHgado(Tbasg143Centhgado bean);

	public int reactivateCentHgado(Tbasg143Centhgado bean);

}
