package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg261Sociedades;

public interface Tbasg261SociedadesRepositoryCustom {

	public List<Tbasg261Sociedades> getSociedadCount();

	public List<Tbasg261Sociedades> getSociedadListAscendente();
	
	public List<Tbasg261Sociedades> getSociedadActiveListAscendente();

	public List<Tbasg261Sociedades> getSociedadListDescendente();

	public List<Tbasg261Sociedades> getSociedad(String cdgoSociedad);

	public List<Tbasg261Sociedades> getSociedadByNombre(String descSociedad);

	public List<Tbasg261Sociedades> getSociedadListActive();

	public int insertSociedad(Tbasg261Sociedades bean);

	public int updateSociedad(Tbasg261Sociedades bean);
	
	public int estadoSociedad(Tbasg261Sociedades bean);

}
