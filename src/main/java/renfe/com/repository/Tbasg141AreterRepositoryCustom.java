package renfe.com.repository;

import java.util.List;

import renfe.com.dto.GetAreTerListAscendenteDTO;
import renfe.com.model.entity.Tbasg141Areter;

public interface Tbasg141AreterRepositoryCustom {

	public List<Tbasg141Areter> getAreTerCount();
	
	public List<GetAreTerListAscendenteDTO> getAreTerListAscendente();
	
	public List<GetAreTerListAscendenteDTO> getAreTerActiveListAscendente();

	public List<Tbasg141Areter> getAreTerListDescendenteCDGO_ARETER(Integer cdgoAreAct);

	public List<Tbasg141Areter> getAreTerListAscendenteDESG_NOMBRE();

	public List<Tbasg141Areter> getAreTerListDescendenteDESG_NOMBRE();

	public List<Tbasg141Areter> getAreTerActiveListDescendenteCDGO_ARETER();

	public List<Tbasg141Areter> getAreTerActiveListAscendenteDESG_NOMBRE();

	public List<Tbasg141Areter> getAreTerActiveListDescendenteDESG_NOMBRE();

	public List<Tbasg141Areter> getAreTerActiveListByCdgoAreact(Integer cdgoAreact);

	public List<Tbasg141Areter> getAreTer(String cdgoAreter);

	public List<Tbasg141Areter> getListAreTerByCodsAreTer(List<Integer>cdgoAreTerList);

	public int insertAreTer(Tbasg141Areter bean);

	public int updateAreTer(Tbasg141Areter bean);
	
	public int estadoAreTer(Tbasg141Areter bean);

	public List<Tbasg141Areter> descAreaActPersona(String cdgoPersona);

}
