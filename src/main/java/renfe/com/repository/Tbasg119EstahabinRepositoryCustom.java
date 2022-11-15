package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg119Estahabin;

public interface Tbasg119EstahabinRepositoryCustom {

	public List<Tbasg119Estahabin> findEstaHabInByCdgoAlc(String cdgoAlchabinf);

	public int insertEstaHabIn(Integer cdgoAlchabinf, Integer cdgoEstado, String desgUsuact, String mrcaActivo);

}
