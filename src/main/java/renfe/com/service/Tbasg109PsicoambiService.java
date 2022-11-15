package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg109PsicoambiDto;
import renfe.com.model.entity.Tbasg109Psicoambi;

public interface Tbasg109PsicoambiService {

	public List<Tbasg109PsicoambiDto> getAllTbasg109Psicoambi(Tbasg109PsicoambiDto filter);

	public Tbasg109PsicoambiDto findByCdgoPsicamb(Integer cdgoPsicamb);

	public Tbasg109PsicoambiDto createTbasg109Psicoambi(Tbasg109PsicoambiDto tbasg109PsicoambiDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg109PsicoambiDto updateTbasg109Psicoambi(Integer cdgoPsicamb, Tbasg109PsicoambiDto tbasg109PsicoambiDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg109Psicoambi(Integer cdgoPsicamb);

	public List<Tbasg109PsicoambiDto> findByCdgoPsicambIn(List<Integer> cdgoPsicamb);

	public List<Tbasg109PsicoambiDto> getPsicoAmbiListCount();

	public List<Tbasg109PsicoambiDto> getPsicoAmbiListAscendente();

	public List<Tbasg109PsicoambiDto> getPsicoAmbiListDescendente();

	public List<Tbasg109PsicoambiDto> getPsicoAmbiActiveListAscendente();
	
	public List<Tbasg109PsicoambiDto> getPsicoAmbiActiveListAscendente1();
	
	public List<Tbasg109PsicoambiDto> getPsicoAmbiActiveListAscendente2();

	public List<Tbasg109PsicoambiDto> getPsicoAmbiActiveListDescendente();

	public List<Tbasg109PsicoambiDto> getPsicoAmbi(Integer cdgoPsicamb);

	public int insertPsicoAmbi(Tbasg109Psicoambi bean);

	public int updatePsicoAmbi(Tbasg109Psicoambi bean);
	
	public int estadoPsicoAmbi(Tbasg109Psicoambi bean);

	public static Tbasg109PsicoambiDto entityToDto(Tbasg109Psicoambi tbasg109Psicoambi) {
		// TODO Auto-generated method stub
		return null;
	}

}
