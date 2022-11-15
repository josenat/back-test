package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg178SecuenciaDto;
import renfe.com.model.entity.Tbasg178Secuencia;

public interface Tbasg178SecuenciaService {

	public List<Tbasg178SecuenciaDto> getAllTbasg178Secuencia(Tbasg178SecuenciaDto filter);

	public Tbasg178SecuenciaDto findByEntityName(String entityName);

	public Tbasg178SecuenciaDto createTbasg178Secuencia(Tbasg178SecuenciaDto tbasg178SecuenciaDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg178SecuenciaDto updateTbasg178Secuencia(String entityName, Tbasg178SecuenciaDto tbasg178SecuenciaDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg178Secuencia(String entityName);

	public List<Tbasg178SecuenciaDto> findByEntityNameIn(List<String> entityName);

	public List<Tbasg178SecuenciaDto> getSequence(String entityName);

	public int updateSequence(Tbasg178Secuencia bean);

}
