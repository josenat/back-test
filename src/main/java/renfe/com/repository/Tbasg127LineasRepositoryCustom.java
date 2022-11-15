package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg127Lineas;

public interface Tbasg127LineasRepositoryCustom {

	public List<Tbasg127Lineas> getLineasCount();

	public List<Tbasg127Lineas> getLineasListAscendente();

	public List<Tbasg127Lineas> getLineasListDescendente();

	public List<Tbasg127Lineas> getLineasActiveListAscendente();

	public List<Tbasg127Lineas> getLineasActiveListDescendente();

	public List<Tbasg127Lineas> getLineas(String cdgoLinea);

	public List<Tbasg127Lineas> getAlcanceLinea(String cdgoLinea);

	public List<Tbasg127Lineas> getLineasListDynamic();

	public int insertLineas(Tbasg127Lineas bean);

	public int updateLineas(Tbasg127Lineas bean);
	
	public int estadoLineas(Tbasg127Lineas bean);

	public int deleteLineas(Tbasg127Lineas bean);

	public int reactiveLineas(Tbasg127Lineas bean);

}
