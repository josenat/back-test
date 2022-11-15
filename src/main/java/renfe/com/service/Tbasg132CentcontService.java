package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.dto.GetCentContListAscendenteeDTO;
import renfe.com.model.dto.Tbasg132CentcontDto;
import renfe.com.model.entity.Tbasg132Centcont;

public interface Tbasg132CentcontService {

	public List<Tbasg132CentcontDto> getAllTbasg132Centcont(Tbasg132CentcontDto filter);

	public Tbasg132CentcontDto findByCdgoCentcont(String cdgoCentcont);

	public Tbasg132CentcontDto createTbasg132Centcont(Tbasg132CentcontDto tbasg132CentcontDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg132CentcontDto updateTbasg132Centcont(String cdgoCentcont, Tbasg132CentcontDto tbasg132CentcontDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg132Centcont(String cdgoCentcont);

	public List<Tbasg132CentcontDto> findByCdgoCentcontIn(List<String> cdgoCentcont);

	public List<Tbasg132CentcontDto> getCentContListRegistroAscendente();

	public List<Tbasg132CentcontDto> getCentContListRegistroDescendente();

	public List<Tbasg132CentcontDto> getCentContCount();

	public List<Tbasg132CentcontDto> getCentContListAscendente(String cdgoAreTer);

	public List<Tbasg132CentcontDto> getCentContListDescendente();

	public List<Tbasg132CentcontDto> getCentContListAscendenteDESG_NOMBRE_PMG();

	public List<Tbasg132CentcontDto> getCentContListDescendenteDESG_NOMBRE_PMG();

	public List<Tbasg132CentcontDto> getCentContListAscendenteCDGO_CENTCONT();

	public List<Tbasg132CentcontDto> getCentContListDescendenteCDGO_CENTCONT();

	public List<Tbasg132CentcontDto> getCentContListByCdgoAreter(Integer cdgoAreter);

	public List<Tbasg132CentcontDto> getCentContListAscendenteDESG_NOMBRE();

	public List<Tbasg132CentcontDto> getCentContListDescendenteDESG_NOMBRE();

	public List<Tbasg132CentcontDto> getCentCont(String cdgoCentcont);

	public List<Tbasg132CentcontDto> getListCentContActive(Integer cdgoAreTer);
	
	public List<GetCentContListAscendenteeDTO> getCentContListAscendentee();

	public int insertCentCont(Tbasg132Centcont bean);

	public int updateCentCont(Tbasg132Centcont bean);
	
	public int estadoCentCont(Tbasg132Centcont bean);

}
