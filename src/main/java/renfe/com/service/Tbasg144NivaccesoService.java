package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg144NivaccesoDto;

public interface Tbasg144NivaccesoService {

	public List<Tbasg144NivaccesoDto> getAllTbasg144Nivacceso(Tbasg144NivaccesoDto filter);

	public Tbasg144NivaccesoDto findByCdgoNivel(String cdgoNivel);

	public Tbasg144NivaccesoDto createTbasg144Nivacceso(Tbasg144NivaccesoDto tbasg144NivaccesoDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg144NivaccesoDto updateTbasg144Nivacceso(String cdgoNivel, Tbasg144NivaccesoDto tbasg144NivaccesoDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg144Nivacceso(String cdgoNivel);

	public List<Tbasg144NivaccesoDto> findByCdgoNivelIn(List<String> cdgoNivel);

	//public List<Tbasg144NivaccesoDto> getNivAccesoCount();
	
	Long getNivAccesoCount();

	public List<Tbasg144NivaccesoDto> getNivAccesoAll();

}
