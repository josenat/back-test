package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg133Serie;

public interface Tbasg133SerieRepositoryCustom {

	public List<Tbasg133Serie> getSerieCount();

	public List<Tbasg133Serie> getSerieListAscendente();

	public List<Tbasg133Serie> getSerieListDescendente();

	public List<Tbasg133Serie> getSerie(String cdgoSerie);
	
	public List<Tbasg133Serie> getSerieNombre(String cdgoSerie);

	public List<Tbasg133Serie> getSerieByNombre(/** FIXME revisar tipo */
	Object nombre);

	public List<Tbasg133Serie> getSerieListActive();
	
	public List<Tbasg133Serie> getSerieActiveListAscendente();

	public int insertSerie(Tbasg133Serie bean);

	public int updateSerie(Tbasg133Serie bean);
	
	public int estadoSerie(Tbasg133Serie bean);

}
