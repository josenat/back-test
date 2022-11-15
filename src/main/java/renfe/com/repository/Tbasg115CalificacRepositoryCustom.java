package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg115Calificac;

public interface Tbasg115CalificacRepositoryCustom {

	public List<Tbasg115Calificac> getCalificacCount();

	public List<Tbasg115Calificac> getCalificacListAscendente();

	public List<Tbasg115Calificac> getCalificacListDescendente();

	public List<Tbasg115Calificac> getCalificacActiveListAscendente();
	
	public List<Tbasg115Calificac> getCalificacActiveListAscendenteRevision();

	public List<Tbasg115Calificac> getCalificacActiveListDescendente();

	public List<Tbasg115Calificac> getCalificac(Integer cdgoCalifi);

	public int insertCalificac(Tbasg115Calificac bean);

	public int updateCalificac(Tbasg115Calificac bean);
	
	public int estadoCalificac(Tbasg115Calificac bean);

}
