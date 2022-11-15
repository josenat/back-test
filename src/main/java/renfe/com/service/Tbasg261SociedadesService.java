package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg261SociedadesDto;
import renfe.com.model.entity.Tbasg261Sociedades;

public interface Tbasg261SociedadesService {

	public List<Tbasg261SociedadesDto> getAllTbasg261Sociedades(Tbasg261SociedadesDto filter);

	public Tbasg261SociedadesDto findByCdgoSociedad(String cdgoSociedad);

	public Tbasg261SociedadesDto createTbasg261Sociedades(Tbasg261SociedadesDto tbasg261SociedadesDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg261SociedadesDto updateTbasg261Sociedades(String cdgoSociedad,
			Tbasg261SociedadesDto tbasg261SociedadesDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg261Sociedades(String cdgoSociedad);

	public List<Tbasg261SociedadesDto> findByCdgoSociedadIn(List<String> cdgoSociedad);

	public List<Tbasg261SociedadesDto> getSociedadCount();

	public List<Tbasg261SociedadesDto> getSociedadListAscendente();
	
	public List<Tbasg261SociedadesDto> getSociedadActiveListAscendente();

	public List<Tbasg261SociedadesDto> getSociedadListDescendente();

	public List<Tbasg261SociedadesDto> getSociedad(String cdgoSociedad);

	public List<Tbasg261SociedadesDto> getSociedadByNombre(String descSociedad);

	public List<Tbasg261SociedadesDto> getSociedadListActive();

	public int insertSociedad(Tbasg261Sociedades bean);

	public int updateSociedad(Tbasg261Sociedades bean);
	
	public int estadoSociedad(Tbasg261Sociedades bean);

}
