package renfe.com.repository;

import java.util.List;

import renfe.com.dto.GetSubSerieListAscCdgoSerieDTO;
import renfe.com.model.dto.Tbasg147SubserieDto;
import renfe.com.model.entity.Tbasg147Subserie;

public interface Tbasg147SubserieRepositoryCustom {

	public List<Tbasg147Subserie> getSubSerie(String cdgoSerie, String cdgoSubserie);

	public List<Tbasg147SubserieDto> getSubSerieListAscendente();

	public List<Tbasg147Subserie> getSubSerieListDescendente();

	public List<Tbasg147Subserie> getSubSerieListAscendenteView();

	public List<Tbasg147Subserie> getSubSerieListDescendenteView();

	public List<GetSubSerieListAscCdgoSerieDTO> getSubSerieListAscendenteViewCDGO_SUBSERIE(String cdgoSerie);

	public List<Tbasg147Subserie> getSubSerieListDescendenteViewCDGO_SUBSERIE(String cdgoSerie);

	public List<Tbasg147Subserie> getSubSerieCount();

	public List<Tbasg147Subserie> getSubSerieViewCount(String cdgoSerie);

	public List<Tbasg147SubserieDto> getSubSerieListActive();

	public int insertSubSerie(Tbasg147Subserie bean);

	public int updateSubSerie(Tbasg147Subserie bean);
	
	public int estadoSubSerie(Tbasg147Subserie bean);

	public int deleteSubSerie(Tbasg147Subserie bean);

	public int reactiveSubSerie(Tbasg147Subserie bean);

}
