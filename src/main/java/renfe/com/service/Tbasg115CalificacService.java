package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg115CalificacDto;
import renfe.com.model.entity.Tbasg115Calificac;

public interface Tbasg115CalificacService {

	public List<Tbasg115CalificacDto> getAllTbasg115Calificac(Tbasg115CalificacDto filter);

	public Tbasg115CalificacDto findByCdgoCalifi(Integer cdgoCalifi);

	public Tbasg115CalificacDto createTbasg115Calificac(Tbasg115CalificacDto tbasg115CalificacDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg115CalificacDto updateTbasg115Calificac(Integer cdgoCalifi, Tbasg115CalificacDto tbasg115CalificacDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg115Calificac(Integer cdgoCalifi);

	public List<Tbasg115CalificacDto> findByCdgoCalifiIn(List<Integer> cdgoCalifi);

	public List<Tbasg115CalificacDto> getCalificacCount();

	public List<Tbasg115CalificacDto> getCalificacListAscendente();

	public List<Tbasg115CalificacDto> getCalificacListDescendente();

	public List<Tbasg115CalificacDto> getCalificacActiveListAscendente();
	
	public List<Tbasg115CalificacDto> getCalificacActiveListAscendenteRevision();

	public List<Tbasg115CalificacDto> getCalificacActiveListDescendente();

	public List<Tbasg115CalificacDto> getCalificac(Integer cdgoCalifi);

	public int insertCalificac(Tbasg115Calificac bean);

	public int updateCalificac(Tbasg115Calificac bean);
	
	public int estadoCalificac(Tbasg115Calificac bean);

	public static Tbasg115CalificacDto entityToDto(Tbasg115Calificac tbasg115Calificac) {
		// TODO Auto-generated method stub
		return null;
	}

}
