package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg168AnotacionInspectorDto;

public interface Tbasg168AnotacionInspectorService {

	public List<Tbasg168AnotacionInspectorDto> getAllTbasg168AnotacionInspector(Tbasg168AnotacionInspectorDto filter);

	public Tbasg168AnotacionInspectorDto findByCdgoAnotacion(Integer cdgoAnotacion);

	public Tbasg168AnotacionInspectorDto createTbasg168AnotacionInspector(
			Tbasg168AnotacionInspectorDto tbasg168AnotacionInspectorDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg168AnotacionInspectorDto updateTbasg168AnotacionInspector(Integer cdgoAnotacion,
			Tbasg168AnotacionInspectorDto tbasg168AnotacionInspectorDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg168AnotacionInspector(Integer cdgoAnotacion);

	public List<Tbasg168AnotacionInspectorDto> findByCdgoAnotacionIn(List<Integer> cdgoAnotacion);

	public List<Tbasg168AnotacionInspectorDto> getAnotacionInspectorList();

	public List<Tbasg168AnotacionInspectorDto> getAnotacionInspectorListCount();

	public List<Tbasg168AnotacionInspectorDto> getAnotacionInspectorByCdgoAnotacion(String cdgoAnotacion);

}
