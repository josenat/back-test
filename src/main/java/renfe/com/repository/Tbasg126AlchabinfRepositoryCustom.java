package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg126Alchabinf;

public interface Tbasg126AlchabinfRepositoryCustom {

	public List<Tbasg126Alchabinf> findAlcHabInfByCdgoExp(Integer cdgoExpedient);

	public List<Tbasg126Alchabinf> getAlcHabInf(String cdgoAlchabinf);

	public int insertAlcHabInf(Tbasg126Alchabinf bean);

	public int deleteAlcHabInfByCdgoExp(Tbasg126Alchabinf bean);

	public int deleteAlcHabInf(Tbasg126Alchabinf bean);

	public List<Tbasg126Alchabinf> getPreviousEstaHabInList(String cdgoAlchabinf);

	public List<Tbasg126Alchabinf> getMaxEntornosExpList(String cdgoExpedient);

	public List<Tbasg126Alchabinf> getMaxEntornosExpListDesc(String cdgoExpedient);

	public List<Tbasg126Alchabinf> findTramoByCodExpediente(String cdgoExpedient);

}
