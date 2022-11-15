package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg106Provincia;

public interface Tbasg106ProvinciaRepositoryCustom {

	public List<Tbasg106Provincia> getProvinciaCount();

	public List<Tbasg106Provincia> getProvinciaListAscendente();

	public List<Tbasg106Provincia> getProvinciaListDescendente();

	public List<Tbasg106Provincia> getProvinciaListActiveAscendente();

	public List<Tbasg106Provincia> getProvinciaListActiveDescendente();

	public List<Tbasg106Provincia> getProvincia(String cdgoProvincia);

	public int insertProvincia(Tbasg106Provincia bean);

	public int updateProvincia(Tbasg106Provincia bean);
	
	public int estadoProvincia(Tbasg106Provincia bean);

}
