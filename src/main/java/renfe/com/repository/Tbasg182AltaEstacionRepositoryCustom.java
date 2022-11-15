package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg182AltaEstacion;

public interface Tbasg182AltaEstacionRepositoryCustom {

	public List<Tbasg182AltaEstacion> getAltaEstacion(String cdgoEstacion, String cdgoLinea);

	public int insertAltaEstacion(Tbasg182AltaEstacion bean);

}
