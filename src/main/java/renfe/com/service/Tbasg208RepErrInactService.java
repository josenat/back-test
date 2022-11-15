package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg208RepErrInactDto;
import renfe.com.model.entity.Tbasg208RepErrInact;

public interface Tbasg208RepErrInactService {

	public List<Tbasg208RepErrInactDto> getAllTbasg208RepErrInact(Tbasg208RepErrInactDto filter);

	public Tbasg208RepErrInactDto findByCdgoReprocesado(Integer cdgoReprocesado);

	public Tbasg208RepErrInactDto createTbasg208RepErrInact(Tbasg208RepErrInactDto tbasg208RepErrInactDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg208RepErrInactDto updateTbasg208RepErrInact(Integer cdgoReprocesado,
			Tbasg208RepErrInactDto tbasg208RepErrInactDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg208RepErrInact(Integer cdgoReprocesado);

	public List<Tbasg208RepErrInactDto> findByCdgoReprocesadoIn(List<Integer> cdgoReprocesado);

	public int insertRepErrInact(Tbasg208RepErrInact bean);

}
