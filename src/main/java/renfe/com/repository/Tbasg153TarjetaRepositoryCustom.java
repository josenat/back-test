package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg153Tarjeta;

public interface Tbasg153TarjetaRepositoryCustom {

	public List<Tbasg153Tarjeta> getTarjeta(String cdgoNumserie);

	public List<Tbasg153Tarjeta> getTarjetaPer(String cdgoPersona);

}
