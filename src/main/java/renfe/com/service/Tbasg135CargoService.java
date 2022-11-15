package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg135CargoDto;
import renfe.com.model.entity.Tbasg135Cargo;

public interface Tbasg135CargoService {

	public List<Tbasg135CargoDto> getAllTbasg135Cargo(Tbasg135CargoDto filter);

	public Tbasg135CargoDto findByCdgoCargo(String cdgoCargo);

	public Tbasg135CargoDto createTbasg135Cargo(Tbasg135CargoDto tbasg135CargoDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg135CargoDto updateTbasg135Cargo(String cdgoCargo, Tbasg135CargoDto tbasg135CargoDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg135Cargo(String cdgoCargo);

	public List<Tbasg135CargoDto> findByCdgoCargoIn(List<String> cdgoCargo);

	public List<Tbasg135CargoDto> getCargo(String cdgoCargo);

	public List<Tbasg135CargoDto> getCargoListAscendente();

	public List<Tbasg135CargoDto> getCargoListDescendente();

	public List<Tbasg135CargoDto> getCargoActiveListAscendente();

	public List<Tbasg135CargoDto> getCargoActiveListDescendente();

	public List<Tbasg135CargoDto> getCargoCount();

	public int insertCargo(Tbasg135Cargo bean);

	public int updateCargo(Tbasg135Cargo bean);
	
	public int estadoCargo(Tbasg135Cargo bean);

	public List<Tbasg135CargoDto> getCargoAltasCargo();

}
