package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.dto.GetSubSerieListAscCdgoSerieDTO;
import renfe.com.model.dto.Tbasg147SubserieDto;
import renfe.com.model.entity.Tbasg147Subserie;

public interface Tbasg147SubserieService {

	public List<Tbasg147SubserieDto> getAllTbasg147Subserie(Tbasg147SubserieDto filter);

	public Tbasg147SubserieDto findByCdgoSerieCdgoSubserie(String cdgoSerie, String cdgoSubserie);

	public Tbasg147SubserieDto createTbasg147Subserie(Tbasg147SubserieDto tbasg147SubserieDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg147SubserieDto updateTbasg147Subserie(String cdgoSerie, String cdgoSubserie,
			Tbasg147SubserieDto tbasg147SubserieDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg147Subserie(String cdgoSerie, String cdgoSubserie);

	public List<Tbasg147SubserieDto> findByCdgoSerieCdgoSubserieIn(List<String> cdgoSerie, List<String> cdgoSubserie);

	public List<Tbasg147SubserieDto> getSubSerie(String cdgoSerie, String cdgoSubserie);

	public List<Tbasg147SubserieDto> getSubSerieListAscendente();

	public List<Tbasg147SubserieDto> getSubSerieListDescendente();

	public List<Tbasg147SubserieDto> getSubSerieListAscendenteView();

	public List<Tbasg147SubserieDto> getSubSerieListDescendenteView();

	public List<GetSubSerieListAscCdgoSerieDTO> getSubSerieListAscendenteViewCDGO_SUBSERIE(String cdgoSerie);

	public List<Tbasg147SubserieDto> getSubSerieListDescendenteViewCDGO_SUBSERIE(String cdgoSerie);

	public List<Tbasg147SubserieDto> getSubSerieCount();

	public List<Tbasg147SubserieDto> getSubSerieViewCount(String cdgoSerie);

	public List<Tbasg147SubserieDto> getSubSerieListActive();

	public int insertSubSerie(Tbasg147Subserie bean);

	public int updateSubSerie(Tbasg147Subserie bean);
	
	public int estadoSubSerie(Tbasg147Subserie bean);

	public int deleteSubSerie(Tbasg147Subserie bean);

	public int reactiveSubSerie(Tbasg147Subserie bean);

}
