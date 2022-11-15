package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg190DocInfrOrdenante;

public interface Tbasg190DocInfrOrdenanteRepositoryCustom {

	public List<Tbasg190DocInfrOrdenante> getDocInfrOrdenanteList();

	public List<Tbasg190DocInfrOrdenante> getDocInfrOrdenanteByCdgoOrdenante(String cdgoOrdenante);

}
