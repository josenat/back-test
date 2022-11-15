package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg113Sancion;

public interface Tbasg113SancionRepositoryCustom {

	public List<Tbasg113Sancion> getSancionCount();

	public List<Tbasg113Sancion> getSancionActiveCount();

	public List<Tbasg113Sancion> getSancionListAscendente();

	public List<Tbasg113Sancion> getSancionListDescendente();

	public List<Tbasg113Sancion> getSancionActiveListAscendente();

	public List<Tbasg113Sancion> getSancionActiveListDescendente();

	public List<Tbasg113Sancion> getSancion(String cdgoSancion);

	public int insertSancion(Tbasg113Sancion bean);

	public int updateSancion(Tbasg113Sancion bean);
	
	public int estadoSancion(Tbasg113Sancion bean);

}
