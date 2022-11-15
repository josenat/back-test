package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg106ProvinciaDto;
import renfe.com.model.entity.Tbasg106Provincia;

public interface Tbasg106ProvinciaService {

	public List<Tbasg106ProvinciaDto> getAllTbasg106Provincia(Tbasg106ProvinciaDto filter);

	public Tbasg106ProvinciaDto findByCdgoProvincia(Integer cdgoProvincia);

	public Tbasg106ProvinciaDto createTbasg106Provincia(Tbasg106ProvinciaDto tbasg106ProvinciaDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg106ProvinciaDto updateTbasg106Provincia(Integer cdgoProvincia,
			Tbasg106ProvinciaDto tbasg106ProvinciaDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg106Provincia(Integer cdgoProvincia);

	public List<Tbasg106ProvinciaDto> findByCdgoProvinciaIn(List<Integer> cdgoProvincia);

	public List<Tbasg106ProvinciaDto> getProvinciaCount();

	public List<Tbasg106ProvinciaDto> getProvinciaListAscendente();

	public List<Tbasg106ProvinciaDto> getProvinciaListDescendente();

	public List<Tbasg106ProvinciaDto> getProvinciaListActiveAscendente();

	public List<Tbasg106ProvinciaDto> getProvinciaListActiveDescendente();

	public List<Tbasg106ProvinciaDto> getProvincia(String cdgoProvincia);

	public int insertProvincia(Tbasg106Provincia bean);

	public int updateProvincia(Tbasg106Provincia bean);
	
	public int estadoProvincia(Tbasg106Provincia bean);

}
