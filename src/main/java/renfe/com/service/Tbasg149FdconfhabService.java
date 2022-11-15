package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg149FdconfhabDto;
import renfe.com.model.entity.Tbasg149Fdconfhab;

public interface Tbasg149FdconfhabService {

	public List<Tbasg149FdconfhabDto> getAllTbasg149Fdconfhab(Tbasg149FdconfhabDto filter);

	public Tbasg149FdconfhabDto findByCdgoFirma(Integer cdgoFirma);

	public Tbasg149FdconfhabDto createTbasg149Fdconfhab(Tbasg149FdconfhabDto tbasg149FdconfhabDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg149FdconfhabDto updateTbasg149Fdconfhab(Integer cdgoFirma, Tbasg149FdconfhabDto tbasg149FdconfhabDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg149Fdconfhab(Integer cdgoFirma);

	public List<Tbasg149FdconfhabDto> findByCdgoFirmaIn(List<Integer> cdgoFirma);

	public int insertFdConfHab(Tbasg149Fdconfhab bean);

}
