package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg148FdotorhabDto;
import renfe.com.model.entity.Tbasg148Fdotorhab;

public interface Tbasg148FdotorhabService {

	public List<Tbasg148FdotorhabDto> getAllTbasg148Fdotorhab(Tbasg148FdotorhabDto filter);

	public Tbasg148FdotorhabDto findByCdgoFirma(Integer cdgoFirma);

	public Tbasg148FdotorhabDto createTbasg148Fdotorhab(Tbasg148FdotorhabDto tbasg148FdotorhabDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg148FdotorhabDto updateTbasg148Fdotorhab(Integer cdgoFirma, Tbasg148FdotorhabDto tbasg148FdotorhabDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg148Fdotorhab(Integer cdgoFirma);

	public List<Tbasg148FdotorhabDto> findByCdgoFirmaIn(List<Integer> cdgoFirma);

	public int insertFdOtorHab(Tbasg148Fdotorhab bean);

}
