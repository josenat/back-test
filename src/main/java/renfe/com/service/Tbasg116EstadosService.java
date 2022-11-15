package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg116EstadosDto;

public interface Tbasg116EstadosService {

	public List<Tbasg116EstadosDto> getAllTbasg116Estados(Tbasg116EstadosDto filter);

	public Tbasg116EstadosDto findByCdgoEstado(Integer cdgoEstado);

	public Tbasg116EstadosDto createTbasg116Estados(Tbasg116EstadosDto tbasg116EstadosDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg116EstadosDto updateTbasg116Estados(Integer cdgoEstado, Tbasg116EstadosDto tbasg116EstadosDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg116Estados(Integer cdgoEstado);

	public List<Tbasg116EstadosDto> findByCdgoEstadoIn(List<Integer> cdgoEstado);

	public List<Tbasg116EstadosDto> getEstadosList();

	public List<Tbasg116EstadosDto> getEstadosHabilitacionListActive();
	public List<Tbasg116EstadosDto> getEstadosConduccionListActive();
	public List<Tbasg116EstadosDto> getEstadosListActive();

	public List<Tbasg116EstadosDto> getActiveStatusListForDriving();
	public List<Tbasg116EstadosDto> getEstado(Integer cdgoEstado);

}
