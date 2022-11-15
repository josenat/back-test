package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg164ActTarjeta;

public interface Tbasg164ActTarjetaRepositoryCustom {

	public List<Tbasg164ActTarjeta> getTarjetaActualizar(String cdgoNumserie);

	public int insertActTarjeta(Tbasg164ActTarjeta bean);

}
