package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg129Entornos;

public interface Tbasg129EntornosRepositoryCustom {

	public List<Tbasg129Entornos> getEntornosCount();

	public List<Tbasg129Entornos> getEntornosListAscendente();
	
	public List<Tbasg129Entornos> getEntornosList();

	public List<Tbasg129Entornos> getEntornosListDescendente();

	public List<Tbasg129Entornos> getEntornosActiveListAscendente(String nombreLargo);

	public List<Tbasg129Entornos> getEntornosActiveListDescendente(String nombreLargo);

	public List<Tbasg129Entornos> getEntornosActiveWithTramosListAscendente();

	public List<Tbasg129Entornos> getEntornosActiveWithTramosListDescendente();

	public List<Tbasg129Entornos> getEntornos(Integer cdgoEntorno);
	
	public List<Tbasg129Entornos> getEntornosNombre(String cdgoEntorno);

	public List<Tbasg129Entornos> getAlcanceEntorno(Integer cdgoEntorno);

	public List<Tbasg129Entornos> getEntornosByNomCorto(String desgNomcorto);

	public int insertEntornos(Tbasg129Entornos bean);

	public int updateEntornos(Tbasg129Entornos bean);

}
