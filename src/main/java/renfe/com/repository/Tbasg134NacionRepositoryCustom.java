package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg134Nacion;

public interface Tbasg134NacionRepositoryCustom {

	public List<Tbasg134Nacion> getNacionCount();

	public List<Tbasg134Nacion> getNacionListAscendente();

	public List<Tbasg134Nacion> getNacionListDescendente();

	public List<Tbasg134Nacion> getNacionActiveListAscendente();

	public List<Tbasg134Nacion> getNacionActiveListDescendente();

	public List<Tbasg134Nacion> getNacion(String cdgoNacion);

	public int insertNacion(Tbasg134Nacion bean);

	public int updateNacion(Tbasg134Nacion bean);
	
	public int estadoNacion(Tbasg134Nacion bean);

}
