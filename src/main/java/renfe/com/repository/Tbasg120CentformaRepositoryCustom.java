package renfe.com.repository;

import java.util.List;

import renfe.com.dto.GetCentFormaListAscCentHgadoDTO;
import renfe.com.model.dto.Tbasg120CentformaDto;
import renfe.com.model.entity.Tbasg120Centforma;

public interface Tbasg120CentformaRepositoryCustom {

	public List<Tbasg120CentformaDto> getCentroForName(String desgNombre);

	public List<Tbasg120Centforma> getCentFormaCount();

	public List<Tbasg120Centforma> getCentFormaViewCount(String cdgoCenthgado);

	public List<Tbasg120Centforma> getCentFormaListAscendente();
	
	public List<GetCentFormaListAscCentHgadoDTO> getCentFormaListAscCentHgado(Integer cdgoCenthgado);

	public List<Tbasg120Centforma> getCentFormaListDescendente();

	public List<Tbasg120Centforma> getCentFormaActiveListAscendente();

	public List<Tbasg120Centforma> getCentFormaActiveListDescendente();

	public List<Tbasg120Centforma> getCentForma(String cdgoCentrofor);

	public List<Tbasg120Centforma> getCentFormaListAscendenteViewCDGO_CENTFORMA(String cdgoCenthgado);

	public List<Tbasg120Centforma> getCentFormaListDescendenteViewCDGO_CENTFORMA(String cdgoCenthgado);

	public List<Tbasg120Centforma> getCentFormaActiveListAscendenteViewCDGO_CENTFORMA(String cdgoCenthgado);

	public List<Tbasg120Centforma> getCentFormaActiveListDescendenteViewCDGO_CENTFORMA(String cdgoCenthgado);

	public int insertCentForma(Tbasg120Centforma bean);

	public int updateCentForma(Tbasg120Centforma bean);
	
	public int estadoCentForma(Tbasg120Centforma bean);

	public int deleteCentFormaByCentHgado(Tbasg120Centforma bean);

}
