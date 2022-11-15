package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg209RepErrFormaDto;
import renfe.com.model.entity.Tbasg209RepErrForma;

public interface Tbasg209RepErrFormaService {

	public List<Tbasg209RepErrFormaDto> getAllTbasg209RepErrForma(Tbasg209RepErrFormaDto filter);

	public Tbasg209RepErrFormaDto findByCdgoReprocesado(Integer cdgoReprocesado);

	public Tbasg209RepErrFormaDto createTbasg209RepErrForma(Tbasg209RepErrFormaDto tbasg209RepErrFormaDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg209RepErrFormaDto updateTbasg209RepErrForma(Integer cdgoReprocesado,
			Tbasg209RepErrFormaDto tbasg209RepErrFormaDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg209RepErrForma(Integer cdgoReprocesado);

	public List<Tbasg209RepErrFormaDto> findByCdgoReprocesadoIn(List<Integer> cdgoReprocesado);

	public int insertRepErrForma(Tbasg209RepErrForma bean);

}
