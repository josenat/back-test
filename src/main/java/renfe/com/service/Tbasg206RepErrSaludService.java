package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg206RepErrSaludDto;
import renfe.com.model.entity.Tbasg206RepErrSalud;

public interface Tbasg206RepErrSaludService {

	public List<Tbasg206RepErrSaludDto> getAllTbasg206RepErrSalud(Tbasg206RepErrSaludDto filter);

	public Tbasg206RepErrSaludDto findByCdgoReprocesado(Integer cdgoReprocesado);

	public Tbasg206RepErrSaludDto createTbasg206RepErrSalud(Tbasg206RepErrSaludDto tbasg206RepErrSaludDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg206RepErrSaludDto updateTbasg206RepErrSalud(Integer cdgoReprocesado,
			Tbasg206RepErrSaludDto tbasg206RepErrSaludDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg206RepErrSalud(Integer cdgoReprocesado);

	public List<Tbasg206RepErrSaludDto> findByCdgoReprocesadoIn(List<Integer> cdgoReprocesado);

	public int insertRepErrSalud(Tbasg206RepErrSalud bean);

}
