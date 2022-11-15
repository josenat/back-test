package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg110PsicomotiDto;
import renfe.com.model.entity.Tbasg110Psicomoti;

public interface Tbasg110PsicomotiService {

	public List<Tbasg110PsicomotiDto> getAllTbasg110Psicomoti(Tbasg110PsicomotiDto filter);

	public Tbasg110PsicomotiDto findByCdgoMotivo(Integer cdgoMotivo);

	public Tbasg110PsicomotiDto createTbasg110Psicomoti(Tbasg110PsicomotiDto tbasg110PsicomotiDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg110PsicomotiDto updateTbasg110Psicomoti(Integer cdgoMotivo, Tbasg110PsicomotiDto tbasg110PsicomotiDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg110Psicomoti(Integer cdgoMotivo);

	public List<Tbasg110PsicomotiDto> findByCdgoMotivoIn(List<Integer> cdgoMotivo);

	public List<Tbasg110PsicomotiDto> getPsicoMotiCount();

	public List<Tbasg110PsicomotiDto> getPsicoMotiListAscendente();

	public List<Tbasg110PsicomotiDto> getPsicoMotiListDescendente();

	public List<Tbasg110PsicomotiDto> getPsicoMotiActiveListAscendente();

	public List<Tbasg110PsicomotiDto> getPsicoMotiActiveListDescendente();

	public List<Tbasg110PsicomotiDto> getPsicoMoti(Integer cdgoMotivo);

	public int insertPsicoMoti(Tbasg110Psicomoti bean);

	public int updatePsicoMoti(Tbasg110Psicomoti bean);
	
	public int estadoPsicoMoti(Tbasg110Psicomoti bean);

	public static Tbasg110PsicomotiDto entityToDto(Tbasg110Psicomoti tbasg110Psicomoti) {
		// TODO Auto-generated method stub
		return null;
	}

}
