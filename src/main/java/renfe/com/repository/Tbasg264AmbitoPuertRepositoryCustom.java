package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg264AmbitoPuert;

public interface Tbasg264AmbitoPuertRepositoryCustom {

	public List<Tbasg264AmbitoPuert> getListaAmbitoPuertosActiv();

	public List<Tbasg264AmbitoPuert> getDescTipoAmbitoPuertos(String cdgoPuerto);

	public List<Tbasg264AmbitoPuert> getAmbitoPuertoCount();

	public List<Tbasg264AmbitoPuert> getMaxAmbitoPuerto();

	public List<Tbasg264AmbitoPuert> getAmbitoPuertoListAscendente();
	
	public List<Tbasg264AmbitoPuert> getCdgoPuertAutoInc();

	public List<Tbasg264AmbitoPuert> getAmbitoPuertoListDescendente();

	public List<Tbasg264AmbitoPuert> getAmbitoPuerto(String cdgoPuerto);

	public List<Tbasg264AmbitoPuert> getAmbitoPuertoByNombre(String desgPuerto);

	public List<Tbasg264AmbitoPuert> getAmbitoPuertoListActive();

	public int insertAmbitoPuerto(Tbasg264AmbitoPuert bean);

	public int updateAmbitoPuerto(Tbasg264AmbitoPuert bean);
	
	public int estadoAmbitoPuerto(Tbasg264AmbitoPuert bean);

}
