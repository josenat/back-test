package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg111FacultatiDto;
import renfe.com.model.entity.Tbasg111Facultati;

public interface Tbasg111FacultatiService {

	public List<Tbasg111FacultatiDto> getAllTbasg111Facultati(Tbasg111FacultatiDto filter);

	public Tbasg111FacultatiDto findByCdgoFacult(Integer cdgoFacult);

	public Tbasg111FacultatiDto createTbasg111Facultati(Tbasg111FacultatiDto tbasg111FacultatiDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg111FacultatiDto updateTbasg111Facultati(Integer cdgoFacult, Tbasg111FacultatiDto tbasg111FacultatiDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg111Facultati(Integer cdgoFacult);

	public List<Tbasg111FacultatiDto> findByCdgoFacultIn(List<Integer> cdgoFacult);

	public List<Tbasg111FacultatiDto> getFacultati(Integer cdgoFacult);

	public List<Tbasg111FacultatiDto> getFacultatiByNumColegiado(String desgNumcolegiado);

	public List<Tbasg111FacultatiDto> getFacultatiListAscendente();

	public List<Tbasg111FacultatiDto> getFacultatiListDescendente();

	public List<Tbasg111FacultatiDto> getFacultatiViewListAscendente();

	public List<Tbasg111FacultatiDto> getFacultatiViewListDescendente();

	public List<Tbasg111FacultatiDto> getFacultatiActiveListAscendente();

	public List<Tbasg111FacultatiDto> getFacultatiActiveListAscendenteApe1Ape2Nom();

	public List<Tbasg111FacultatiDto> getFacultatiActiveListDescendente();

	public List<Tbasg111FacultatiDto> getFacultatiCount();

	public int insertFacultati(Tbasg111Facultati bean);

	public int updateFacultati(Tbasg111Facultati bean);
	
	public int estadoFacultati(Tbasg111Facultati bean);

	public static Tbasg111FacultatiDto entityToDto(Tbasg111Facultati tbasg111Facultati) {
		// TODO Auto-generated method stub
		return null;
	}

}
