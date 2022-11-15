package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg183BajaEstacion;

public interface Tbasg183BajaEstacionRepositoryCustom {

	public List<Tbasg183BajaEstacion> getBajaEstacion(String cdgoEstacion, String cdgoLinea);

	public int insertBajaEstacion(Tbasg183BajaEstacion bean);

}
