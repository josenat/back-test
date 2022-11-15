package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg179FicheroRefDto;

public interface Tbasg179FicheroRefService {

	public List<Tbasg179FicheroRefDto> getAllTbasg179FicheroRef(Tbasg179FicheroRefDto filter);

	public Tbasg179FicheroRefDto findByCdgoFichero(Integer cdgoFichero);

	public Tbasg179FicheroRefDto createTbasg179FicheroRef(Tbasg179FicheroRefDto tbasg179FicheroRefDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg179FicheroRefDto updateTbasg179FicheroRef(Integer cdgoFichero,
			Tbasg179FicheroRefDto tbasg179FicheroRefDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg179FicheroRef(Integer cdgoFichero);

	public List<Tbasg179FicheroRefDto> findByCdgoFicheroIn(List<Integer> cdgoFichero);

	public List<Tbasg179FicheroRefDto> getFicheroRefList();

	public List<Tbasg179FicheroRefDto> getFicheroRefListByFecha();

	public List<Tbasg179FicheroRefDto> getFicheroRefListByFechaAsc();

}
