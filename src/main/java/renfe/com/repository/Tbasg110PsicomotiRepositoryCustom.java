package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg110Psicomoti;

public interface Tbasg110PsicomotiRepositoryCustom {

	public List<Tbasg110Psicomoti> getPsicoMotiCount();

	public List<Tbasg110Psicomoti> getPsicoMotiListAscendente();

	public List<Tbasg110Psicomoti> getPsicoMotiListDescendente();

	public List<Tbasg110Psicomoti> getPsicoMotiActiveListAscendente();

	public List<Tbasg110Psicomoti> getPsicoMotiActiveListDescendente();

	public List<Tbasg110Psicomoti> getPsicoMoti(Integer cdgoMotivo);

	public int insertPsicoMoti(Tbasg110Psicomoti bean);

	public int updatePsicoMoti(Tbasg110Psicomoti bean);
	
	public int estadoPsicoMoti(Tbasg110Psicomoti bean);

}
