package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg135Cargo;

public interface Tbasg135CargoRepositoryCustom {

	public List<Tbasg135Cargo> getCargoAltasCargo();
	
	public List<Tbasg135Cargo> getCargo(String cdgoCargo);

	public List<Tbasg135Cargo> getCargoListAscendente();

	public List<Tbasg135Cargo> getCargoListDescendente();

	public List<Tbasg135Cargo> getCargoActiveListAscendente();

	public List<Tbasg135Cargo> getCargoActiveListDescendente();

	public List<Tbasg135Cargo> getCargoCount();

	public int insertCargo(Tbasg135Cargo bean);

	public int updateCargo(Tbasg135Cargo bean);
	
	public int estadoCargo(Tbasg135Cargo bean);

}
