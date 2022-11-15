package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg264AmbitoPuertDto;
import renfe.com.model.entity.Tbasg264AmbitoPuert;

public interface Tbasg264AmbitoPuertService {

	public List<Tbasg264AmbitoPuertDto> getAllTbasg264AmbitoPuert(Tbasg264AmbitoPuertDto filter);

	public Tbasg264AmbitoPuertDto findByCdgoPuerto(String cdgoPuerto);

	public Tbasg264AmbitoPuertDto createTbasg264AmbitoPuert(Tbasg264AmbitoPuertDto tbasg264AmbitoPuertDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg264AmbitoPuertDto updateTbasg264AmbitoPuert(String cdgoPuerto,
			Tbasg264AmbitoPuertDto tbasg264AmbitoPuertDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg264AmbitoPuert(String cdgoPuerto);

	public List<Tbasg264AmbitoPuertDto> findByCdgoPuertoIn(List<String> cdgoPuerto);

	public List<Tbasg264AmbitoPuertDto> getListaAmbitoPuertosActiv();

	public List<Tbasg264AmbitoPuertDto> getDescTipoAmbitoPuertos(String cdgoPuerto);

	public List<Tbasg264AmbitoPuertDto> getAmbitoPuertoCount();

	public List<Tbasg264AmbitoPuertDto> getMaxAmbitoPuerto();

	public List<Tbasg264AmbitoPuertDto> getAmbitoPuertoListAscendente();
	
	public List<Tbasg264AmbitoPuertDto> getCdgoPuertAutoInc();

	public List<Tbasg264AmbitoPuertDto> getAmbitoPuertoListDescendente();

	public List<Tbasg264AmbitoPuertDto> getAmbitoPuerto(String cdgoPuerto);

	public List<Tbasg264AmbitoPuertDto> getAmbitoPuertoByNombre(String desgPuerto);

	public List<Tbasg264AmbitoPuertDto> getAmbitoPuertoListActive();

	public int insertAmbitoPuerto(Tbasg264AmbitoPuert bean);

	public int updateAmbitoPuerto(Tbasg264AmbitoPuert bean);
	
	public int estadoAmbitoPuerto(Tbasg264AmbitoPuert bean);

}
