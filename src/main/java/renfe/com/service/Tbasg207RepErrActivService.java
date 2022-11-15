package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg207RepErrActivDto;
import renfe.com.model.entity.Tbasg207RepErrActiv;

public interface Tbasg207RepErrActivService {

	public List<Tbasg207RepErrActivDto> getAllTbasg207RepErrActiv(Tbasg207RepErrActivDto filter);

	public Tbasg207RepErrActivDto findByCdgoReprocesado(Integer cdgoReprocesado);

	public Tbasg207RepErrActivDto createTbasg207RepErrActiv(Tbasg207RepErrActivDto tbasg207RepErrActivDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg207RepErrActivDto updateTbasg207RepErrActiv(Integer cdgoReprocesado,
			Tbasg207RepErrActivDto tbasg207RepErrActivDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg207RepErrActiv(Integer cdgoReprocesado);

	public List<Tbasg207RepErrActivDto> findByCdgoReprocesadoIn(List<Integer> cdgoReprocesado);

	public int insertRepErrActiv(Tbasg207RepErrActiv bean);

}
