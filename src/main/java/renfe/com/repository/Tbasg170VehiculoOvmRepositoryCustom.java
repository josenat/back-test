package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg170VehiculoOvm;

public interface Tbasg170VehiculoOvmRepositoryCustom {

	public List<Tbasg170VehiculoOvm> getVehiculoOVMListAscendente();

	public List<Tbasg170VehiculoOvm> getVehiculoOVMListDescendente();

	public List<Tbasg170VehiculoOvm> getVehiculoOVMCount();

	public List<Tbasg170VehiculoOvm> getVehiculoOVM(String cdgoVehiculo);

	public List<Tbasg170VehiculoOvm> getVehiculoOVMListActive();

	public int insertVehiculoOVM(Tbasg170VehiculoOvm bean);

	public int updateVehiculoOVM(Tbasg170VehiculoOvm bean);
	
	public int estadoVehiculoOVM(Tbasg170VehiculoOvm bean);

}
