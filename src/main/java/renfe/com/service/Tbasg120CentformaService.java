package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.dto.GetCentFormaListAscCentHgadoDTO;
import renfe.com.model.dto.Tbasg120CentformaDto;
import renfe.com.model.entity.Tbasg120Centforma;

public interface Tbasg120CentformaService {

	public List<Tbasg120CentformaDto> getAllTbasg120Centforma(Tbasg120CentformaDto filter);

	public Tbasg120CentformaDto findByCdgoCentrofor(Integer cdgoCentrofor);

	public Tbasg120CentformaDto createTbasg120Centforma(Tbasg120CentformaDto tbasg120CentformaDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg120CentformaDto updateTbasg120Centforma(Integer cdgoCentrofor,
			Tbasg120CentformaDto tbasg120CentformaDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg120Centforma(Integer cdgoCentrofor);

	public List<Tbasg120CentformaDto> findByCdgoCentroforIn(List<Integer> cdgoCentrofor);

	public List<Tbasg120CentformaDto> getCentroForName(String desgNombre);

	public List<Tbasg120CentformaDto> getCentFormaCount();

	public List<Tbasg120CentformaDto> getCentFormaViewCount(String cdgoCenthgado);

	public List<Tbasg120CentformaDto> getCentFormaListAscendente();
	
	public List<GetCentFormaListAscCentHgadoDTO> getCentFormaListAscCentHgado(Integer cdgoCenthgado);

	public List<Tbasg120CentformaDto> getCentFormaListDescendente();

	public List<Tbasg120CentformaDto> getCentFormaActiveListAscendente();

	public List<Tbasg120CentformaDto> getCentFormaActiveListDescendente();

	public List<Tbasg120CentformaDto> getCentForma(String cdgoCentrofor);

	public List<Tbasg120CentformaDto> getCentFormaListAscendenteViewCDGO_CENTFORMA(String cdgoCenthgado);

	public List<Tbasg120CentformaDto> getCentFormaListDescendenteViewCDGO_CENTFORMA(String cdgoCenthgado);

	public List<Tbasg120CentformaDto> getCentFormaActiveListAscendenteViewCDGO_CENTFORMA(String cdgoCenthgado);

	public List<Tbasg120CentformaDto> getCentFormaActiveListDescendenteViewCDGO_CENTFORMA(String cdgoCenthgado);

	public int insertCentForma(Tbasg120Centforma bean);

	public int updateCentForma(Tbasg120Centforma bean);
	
	public int estadoCentForma(Tbasg120Centforma bean);

	public int deleteCentFormaByCentHgado(Tbasg120Centforma bean);

}
