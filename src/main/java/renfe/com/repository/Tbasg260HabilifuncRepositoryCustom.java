package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg260Habilifunc;

public interface Tbasg260HabilifuncRepositoryCustom {

	public List<Tbasg260Habilifunc> getFuncionesAsocHabil(List<Integer> listHabilitaciones, String cdgoIdioma);

}
