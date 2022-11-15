package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg181BajaLinea;

public interface Tbasg181BajaLineaRepositoryCustom {

	public List<Tbasg181BajaLinea> getBajaLinea(String cdgoLinea);

	public int insertBajaLinea(Tbasg181BajaLinea bean);

}
