package renfe.com.repository;

import java.util.List;

import renfe.com.dto.GetCentContListAscendenteeDTO;
import renfe.com.model.entity.Tbasg132Centcont;

public interface Tbasg132CentcontRepositoryCustom {

	public List<Tbasg132Centcont> getCentContListRegistroAscendente();

	public List<Tbasg132Centcont> getCentContListRegistroDescendente();

	public List<Tbasg132Centcont> getCentContCount();

	public List<Tbasg132Centcont> getCentContListAscendente(String cdgoAreTer);

	public List<Tbasg132Centcont> getCentContListDescendente();

	public List<Tbasg132Centcont> getCentContListAscendenteDESG_NOMBRE_PMG();

	public List<Tbasg132Centcont> getCentContListDescendenteDESG_NOMBRE_PMG();

	public List<Tbasg132Centcont> getCentContListAscendenteCDGO_CENTCONT();

	public List<Tbasg132Centcont> getCentContListDescendenteCDGO_CENTCONT();

	public List<Tbasg132Centcont> getCentContListByCdgoAreter(Integer cdgoAreter);

	public List<Tbasg132Centcont> getCentContListAscendenteDESG_NOMBRE();

	public List<Tbasg132Centcont> getCentContListDescendenteDESG_NOMBRE();

	public List<Tbasg132Centcont> getCentCont(String cdgoCentcont);
	
	public List<GetCentContListAscendenteeDTO> getCentContListAscendentee();

	public List<Tbasg132Centcont> getListCentContActive(Integer cdgoAreTer);

	public int insertCentCont(Tbasg132Centcont bean);

	public int updateCentCont(Tbasg132Centcont bean);
	
	public int estadoCentCont(Tbasg132Centcont bean);

}
