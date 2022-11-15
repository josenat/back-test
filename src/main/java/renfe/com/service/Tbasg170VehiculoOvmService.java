package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg170VehiculoOvmDto;
import renfe.com.model.entity.Tbasg170VehiculoOvm;

public interface Tbasg170VehiculoOvmService {

	public List<Tbasg170VehiculoOvmDto> getAllTbasg170VehiculoOvm(Tbasg170VehiculoOvmDto filter);

	public Tbasg170VehiculoOvmDto findByCdgoVehiculo(Integer cdgoVehiculo);

	public Tbasg170VehiculoOvmDto createTbasg170VehiculoOvm(Tbasg170VehiculoOvmDto tbasg170VehiculoOvmDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg170VehiculoOvmDto updateTbasg170VehiculoOvm(Integer cdgoVehiculo,
			Tbasg170VehiculoOvmDto tbasg170VehiculoOvmDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg170VehiculoOvm(Integer cdgoVehiculo);

	public List<Tbasg170VehiculoOvmDto> findByCdgoVehiculoIn(List<Integer> cdgoVehiculo);

	public List<Tbasg170VehiculoOvmDto> getVehiculoOVMListAscendente();

	public List<Tbasg170VehiculoOvmDto> getVehiculoOVMListDescendente();

	public List<Tbasg170VehiculoOvmDto> getVehiculoOVMCount();

	public List<Tbasg170VehiculoOvmDto> getVehiculoOVM(String cdgoVehiculo);

	public List<Tbasg170VehiculoOvmDto> getVehiculoOVMListActive();

	public int insertVehiculoOVM(Tbasg170VehiculoOvm bean);

	public int updateVehiculoOVM(Tbasg170VehiculoOvm bean);
	
	public int estadoVehiculoOVM(Tbasg170VehiculoOvm bean);

}

