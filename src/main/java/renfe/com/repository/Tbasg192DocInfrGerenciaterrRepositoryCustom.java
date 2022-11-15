package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg192DocInfrGerenciaterr;

public interface Tbasg192DocInfrGerenciaterrRepositoryCustom {

	public List<Tbasg192DocInfrGerenciaterr> getDocInfrGerenciaTerrList();

	public List<Tbasg192DocInfrGerenciaterr> getDocInfrGerenciaTerrByCdgoGerencia(String cdgoGerencia);

}
