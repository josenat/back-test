package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg114GradoinciDto;
import renfe.com.model.entity.Tbasg114Gradoinci;

public interface Tbasg114GradoinciService {

	public List<Tbasg114GradoinciDto> getAllTbasg114Gradoinci(Tbasg114GradoinciDto filter);

	public Tbasg114GradoinciDto findByCdgoGrado(Integer cdgoGrado);

	public Tbasg114GradoinciDto createTbasg114Gradoinci(Tbasg114GradoinciDto tbasg114GradoinciDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg114GradoinciDto updateTbasg114Gradoinci(Integer cdgoGrado, Tbasg114GradoinciDto tbasg114GradoinciDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg114Gradoinci(Integer cdgoGrado);

	public List<Tbasg114GradoinciDto> findByCdgoGradoIn(List<Integer> cdgoGrado);

	public List<Tbasg114GradoinciDto> getGradoInciCount();

	public List<Tbasg114GradoinciDto> getGradoInciActiveCount();

	public List<Tbasg114GradoinciDto> getGradoInciListAscendente();

	public List<Tbasg114GradoinciDto> getGradoInciListDescendente();

	public List<Tbasg114GradoinciDto> getGradoInciActiveListAscendente();

	public List<Tbasg114GradoinciDto> getGradoInciActiveListDescendente();

	public List<Tbasg114GradoinciDto> getGradoInci(String cdgoGrado);

	public int insertGradoInci(Tbasg114Gradoinci bean);

	public int updateGradoInci(Tbasg114Gradoinci bean);
	
	public int estadoGradoInci(Tbasg114Gradoinci bean);

}
