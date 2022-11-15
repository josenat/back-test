package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg109Psicoambi;

public interface Tbasg109PsicoambiRepositoryCustom {

	public List<Tbasg109Psicoambi> getPsicoAmbiListCount();

	public List<Tbasg109Psicoambi> getPsicoAmbiListAscendente();

	public List<Tbasg109Psicoambi> getPsicoAmbiListDescendente();

	public List<Tbasg109Psicoambi> getPsicoAmbiActiveListAscendente();
	
	public List<Tbasg109Psicoambi> getPsicoAmbiActiveListAscendente1();
	
	public List<Tbasg109Psicoambi> getPsicoAmbiActiveListAscendente2();

	public List<Tbasg109Psicoambi> getPsicoAmbiActiveListDescendente();

	public List<Tbasg109Psicoambi> getPsicoAmbi(Integer cdgoPsicamb);

	public int insertPsicoAmbi(Tbasg109Psicoambi bean);

	public int updatePsicoAmbi(Tbasg109Psicoambi bean);
	
	public int estadoPsicoAmbi(Tbasg109Psicoambi bean);

}
