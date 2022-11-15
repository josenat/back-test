package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg137EspecialiDto;
import renfe.com.model.entity.Tbasg137Especiali;

public interface Tbasg137EspecialiService {

	public List<Tbasg137EspecialiDto> getAllTbasg137Especiali(Tbasg137EspecialiDto filter);

	public Tbasg137EspecialiDto findByCdgoEspec(Integer cdgoEspec);

	public Tbasg137EspecialiDto createTbasg137Especiali(Tbasg137EspecialiDto tbasg137EspecialiDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg137EspecialiDto updateTbasg137Especiali(Integer cdgoEspec, Tbasg137EspecialiDto tbasg137EspecialiDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg137Especiali(Integer cdgoEspec);

	public List<Tbasg137EspecialiDto> findByCdgoEspecIn(List<Integer> cdgoEspec);

	public List<Tbasg137EspecialiDto> getEspecialiCount();

	public List<Tbasg137EspecialiDto> getEspecialiListAscendente();
	
	public List<Tbasg137EspecialiDto> getEspecialiList();

	public List<Tbasg137EspecialiDto> getEspecialiListDescendente();

	public List<Tbasg137EspecialiDto> getEspeciali(Integer cdgoEspec);
	
	public List<Tbasg137EspecialiDto> getAlcanceEspeciali(Integer cdgoEspec);

	public List<Tbasg137EspecialiDto> getEspecialiNombre(String cdgoEspec);

	public List<Tbasg137EspecialiDto> getEspecialiActiveList();

	public int insertEspeciali(Tbasg137Especiali bean);

	public int updateEspeciali(Tbasg137Especiali bean);
	
	public int estadoEspeciali(Tbasg137Especiali bean);

}
