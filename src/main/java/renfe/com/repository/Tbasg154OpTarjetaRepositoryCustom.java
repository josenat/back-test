package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg154OpTarjeta;

public interface Tbasg154OpTarjetaRepositoryCustom {

	public List<Tbasg154OpTarjeta> getOperacion(String cdgoNumserie);

	public int insertOperTarjeta(Tbasg154OpTarjeta bean);

}
